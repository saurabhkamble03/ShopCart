package com.shopcart.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.shopcart.entity.Items;

public interface ItemsRepository extends CrudRepository<Items, Integer> {

	@Query(value = "SELECT * FROM shopcart.items WHERE category_id = (SELECT category_id FROM shopcart.categories WHERE category_name = :category);", nativeQuery = true)
	List<Items> getItemsByCategory(String category);

	@Modifying
	@Transactional
	@Query(value = "UPDATE shopcart.items SET item_name = :item_name, price = :price, quantity = :quantity, img = :img WHERE item_id = :item_id", nativeQuery = true)
	void updateItem(@Param("item_id") int item_id,@Param("item_name") String item_name,@Param("price") float price,@Param("quantity") int quantity,@Param("img") String img);

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO shopcart.categories (category_name) \r\n"
			+ "VALUES (:category_name);", nativeQuery = true)
	void createCategory(String category_name);


}
