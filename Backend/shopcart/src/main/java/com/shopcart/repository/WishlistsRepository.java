package com.shopcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shopcart.entity.Wishlists;

public interface WishlistsRepository extends JpaRepository<Wishlists, Integer>{

	@Query(value = "SELECT * FROM shopcart.wishlists WHERE user_id = :user_id", nativeQuery = true)
	List<Wishlists> getWishlists(int user_id);

}
