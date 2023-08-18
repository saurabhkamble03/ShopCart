package com.shopcart.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.shopcart.entity.Orders;

public interface OrdersRepository extends CrudRepository<Orders, Integer>{

	@Query(value = "SELECT * FROM shopcart.orders WHERE user_id = :user_id", nativeQuery = true)
	Orders getOrder(int user_id);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM shopcart.orders WHERE user_id = :user_id", nativeQuery = true)
	void deleteOrder(int user_id);

	@Modifying
	@Transactional
	@Query(value = "UPDATE shopcart.orders SET status = 'Delivered' WHERE user_id = :user_id AND order_id = :order_id ", nativeQuery = true)
	void updateStatus(int user_id, int order_id);

	@Query(value = " SELECT * FROM shopcart.orders WHERE user_id = :user_id", nativeQuery = true)
	List<Orders> getOrders(int user_id);

	@Query(value = "SELECT * FROM shopcart.orders WHERE status = 'In-Progress'; ", nativeQuery = true)
	List<Orders> getPendingOrders();

}
