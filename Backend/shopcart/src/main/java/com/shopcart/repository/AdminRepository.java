package com.shopcart.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.shopcart.entity.Admin;

public interface AdminRepository extends CrudRepository<Admin,Integer>{

	@Query(value = "SELECT * FROM admin WHERE username = :username", nativeQuery = true)
	Admin getAdminByUsername(String username);

}
