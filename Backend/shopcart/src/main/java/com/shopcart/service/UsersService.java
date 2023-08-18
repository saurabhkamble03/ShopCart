package com.shopcart.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopcart.entity.Users;
import com.shopcart.login.Encryption;
import com.shopcart.login.Login;
import com.shopcart.repository.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository repo;

	@Autowired
	HttpServletRequest request;

	@Autowired
	HttpSession session;

	public boolean addUser(Users user) {

//		if (session.getAttribute("admin_id") == null) {
//
//			System.out.println("Admin not logged in");
//			return false;

//		} else {
		for (Users dbuser : repo.findAll()) {
			if (dbuser.getUsername().equals(user.getUsername())) {
				System.out.println("Username already exists");
				return false;
			}

		}
		try {
			repo.save(user);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
//		}

	}

	public Users getUser(int user_id) {

		try {
			if (session.getAttribute("user_id") == null) {
				System.out.println("User not logged in");
				return null;
			} else {

				return repo.findById(user_id).get();
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	public boolean updateUser(int user_id, Users user) {

		try {
			if (session.getAttribute("user_id") == null) {

				System.out.println("User not logged in");
				return false;

			} else {

				Users dbuser = repo.findById(user_id).get();
				String first_name = user.getFirst_name();
				String last_name = user.getLast_name();
				String email_id = user.getEmail_id();
				String mobile_no = user.getMobile_no();
				String address = user.getAddress();
				String state = user.getState();
				String city = user.getCity();
				String street = user.getStreet();
				String zip_code = user.getZip_code();

				if (first_name == null) {
					first_name = dbuser.getFirst_name();
				}

				if (last_name == null) {
					last_name = dbuser.getLast_name();
				}

				if (email_id == null) {
					email_id = dbuser.getEmail_id();
				}

				if (mobile_no == null) {
					mobile_no = dbuser.getMobile_no();
				}

				if (address == null) {
					address = dbuser.getAddress();
				}

				if (state == null) {
					state = dbuser.getState();
				}

				if (city == null) {
					city = dbuser.getCity();
				}

				if (street == null) {
					street = dbuser.getStreet();
				}

				if (zip_code == null) {
					zip_code = dbuser.getZip_code();
				}

				repo.updateUser(user_id, first_name, last_name, email_id, mobile_no, address, state, city, street,
						zip_code);

				return true;

			}
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
//		}

	}

	public boolean userLogin(Login login) {

		session = request.getSession();

		Users user = repo.getUserByUsername(login.getUsername());
//		System.out.println(login.getUsername());

		try {
			if (user.equals(null)) {
				return false;
			}

			String encryptedPassword = user.getPassword();
			String password = Encryption.decrypt(encryptedPassword, "secretkey");

			if (password.equals(login.getPassword())) {
				int user_id = user.getUser_id();
				session.setAttribute("user_id", user_id);
				System.out.println(true);
				System.out.println(session.getAttribute("user_id"));
				session.setMaxInactiveInterval(0);
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return false;
	}

	public String userLogout() {

		try {
			session.removeAttribute("user_id");
			session.invalidate();
			return "Logged out successfully";
		} catch (Exception e) {
			System.out.println(e);
			return "Something went wrong";
		}
	}

	public int getSession() {
		System.out.println(session);

		try {
			System.out.println(session.getAttribute("user_id"));
			int user_id = (int) session.getAttribute("user_id");
			return user_id;
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Session not present");
			return 0;
		}
	}

}
