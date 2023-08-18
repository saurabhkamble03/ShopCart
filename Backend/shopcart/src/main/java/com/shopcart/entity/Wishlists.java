package com.shopcart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "wishlists")
public class Wishlists {
	
	@Id
	@Column(name = "wishlist_id")
	private int wishlist_id;
	
	@ManyToOne(targetEntity = Users.class)
	@JoinColumn(name = "user_id")
	private Users user;
	
	@OneToOne(targetEntity = Items.class)
	@JoinColumn(name = "item_id")
	private Items item;
	
	public Wishlists() {
		
	}

	public Wishlists(int wishlist_id, Users user, Items item) {
		
		this.wishlist_id = wishlist_id;
		this.user = user;
		this.item = item;
	}

	public int getWishlist_id() {
		return wishlist_id;
	}

	public void setWishlist_id(int wishlist_id) {
		this.wishlist_id = wishlist_id;
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

	@Override
	public String toString() {
		return "Wishlists [wishlist_id=" + wishlist_id + ", user=" + user + ", item=" + item + "]";
	}
	
}
