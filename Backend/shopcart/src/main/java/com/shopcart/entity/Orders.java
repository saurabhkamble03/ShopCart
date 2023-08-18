package com.shopcart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {

	@Id
	@Column(name = "order_id")
	private int order_id;
	
	@OneToOne(targetEntity = Users.class)
	@JoinColumn(name = "user_id")
	private Users user;
	
	@Column(name = "total")
	private float total;
	
	@Column(name = "status")
	private String status;
	
	public Orders() {
		
	}

	public Orders(int order_id, Users user, float total, String status) {
		
		this.order_id = order_id;
		this.user = user;
		this.total = total;
		this.status = status;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", user=" + user + ", total=" + total + ", status=" + status + "]";
	}
	
}
