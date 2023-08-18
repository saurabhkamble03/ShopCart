package com.shopcart.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.shopcart.entity.Users;

public interface UsersRepository extends CrudRepository<Users,Integer>{

	@Query(value = "SELECT * FROM shopcart.users WHERE username = :username" , nativeQuery = true)
	Users getUserByUsername(String username);

	@Transactional
	@Modifying
	@Query(value = "UPDATE shopcart.users SET first_name = :first_name, last_name = :last_name, email_id = :email_id, mobile_no = :mobile_no, address = :address, state = :state, city = :city, street = :street, zip_code = :zip_code WHERE user_id = :user_id ", nativeQuery = true)
	void updateUser(@Param("user_id") int user_id,@Param("first_name") String first_name,
			@Param("last_name") String last_name,@Param("email_id") String email_id,
			@Param("mobile_no") String mobile_no,@Param("address") String address,
			@Param("state") String state,@Param("city") String city,@Param("street") String street,
			@Param("zip_code") String zip_code);

}
