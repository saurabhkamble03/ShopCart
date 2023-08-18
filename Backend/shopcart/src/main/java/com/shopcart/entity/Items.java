package com.shopcart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Items {

	@Id
	@Column(name = "item_id")
	private int item_id;
	
	@ManyToOne(targetEntity = Categories.class)
	@JoinColumn(name = "category_id")
	Categories category;
	
	@Column(name = "item_name")
	private String item_name;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "img")
	private String img;
	
	public Items() {
		
	}

	public Items(int item_id, Categories category, String item_name, float price, int quantity, String img) {

		this.item_id = item_id;
		this.category = category;
		this.item_name = item_name;
		this.price = price;
		this.quantity = quantity;
		this.img = img;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Items [item_id=" + item_id + ", category=" + category + ", item_name=" + item_name + ", price=" + price
				+ ", quantity=" + quantity + ", img=" + img + "]";
	}

}
