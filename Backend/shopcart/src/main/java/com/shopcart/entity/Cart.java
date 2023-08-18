package com.shopcart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
	
	@Id
	@Column(name = "cart_id")
	private int cart_id;
	
	@ManyToOne(targetEntity = Users.class)
	@JoinColumn(name = "user_id")
	private Users user;
	
	@ManyToOne(targetEntity = Items.class)
	@JoinColumn(name = "item_id")
	private Items item;
	
	@Column(name = "item_quantity")
	private int item_quantity;
	
	@Column(name = "subtotal")
	private float subtotal;
	
	public Cart() {
				
	}

	public Cart(int cart_id, Users user, Items item, int item_quantity, float subtotal) {
		
		this.cart_id = cart_id;
		this.user = user;
		this.item = item;
		this.item_quantity = item_quantity;
		this.subtotal = subtotal;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Items getItem() {
		return item;
	}

	public void setItem(Items item) {
		this.item = item;
	}

	public int getItem_quantity() {
		return item_quantity;
	}

	public void setItem_quantity(int item_quantity) {
		this.item_quantity = item_quantity;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", user=" + user + ", item=" + item + ", item_quantity=" + item_quantity
				+ ", subtotal=" + subtotal + "]";
	}

}
