package com.shopcart.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.shopcart.entity.Cart;

public interface CartRepository extends CrudRepository<Cart, Integer> {

	@Query(value = "SELECT price FROM shopcart.items WHERE item_id = :item_id", nativeQuery = true)
	int getPrice(int item_id);

	@Query(value = "SELECT * FROM shopcart.cart WHERE user_id = :user_id", nativeQuery = true)
	List<Cart> getCartByUserId(int user_id);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM shopcart.cart WHERE item_id = :item_id AND user_id = :user_id", nativeQuery = true)
	void deleteItemFromCart(int item_id,int user_id);

	@Query(value = "SELECT SUM(shopcart.cart.subtotal) FROM shopcart.cart WHERE shopcart.cart.user_id = :user_id ;", nativeQuery = true)
	float getSubtotal(int user_id);

	@Modifying
	@Transactional
	@Query(value = "UPDATE shopcart.cart \r\n"
			+ "SET shopcart.cart.item_quantity = shopcart.cart.item_quantity - 1 WHERE (shopcart.cart.item_id = :item_id) AND (shopcart.cart.user_id = :user_id)", nativeQuery = true)
	void minusItem(int item_id, int user_id);

	@Modifying
	@Transactional
	@Query(value = "UPDATE shopcart.cart \r\n"
			+ "SET subtotal = item_quantity * (SELECT price FROM shopcart.items WHERE item_id = :item_id) WHERE item_id = :item_id AND user_id = :user_id", nativeQuery = true)
	void updateCart(int item_id, int user_id);

	@Modifying
	@Transactional
	@Query(value = "UPDATE shopcart.cart \r\n"
			+ "SET shopcart.cart.item_quantity = shopcart.cart.item_quantity + 1 WHERE (shopcart.cart.item_id = :item_id) AND (shopcart.cart.user_id = :user_id)", nativeQuery = true)
	void plusItem(int item_id, int user_id);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM shopcart.cart WHERE user_id = :user_id", nativeQuery = true)
	void deleteCart(int user_id);

}
