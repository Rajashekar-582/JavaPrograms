package com.example3.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import javax.persistence.JoinColumn;

@Entity
@Table(name="carts")
public class Cart
{
	
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name="cart_id")
   private int id;
   
   @Column(name="Price")
   private int price;
   
   @ManyToMany
   @JoinTable(name="cart_Product",joinColumns=@JoinColumn(name="cart_id"),
   inverseJoinColumns=@JoinColumn(name="Product_id"))
   private Set<Product> products=new HashSet<Product>();

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public Set<Product> getProducts() {
	return products;
}

public void setProducts(Set<Product> products) {
	this.products = products;
}

public Cart(int id, int price, Set<Product> products) {
	super();
	this.id = id;
	this.price = price;
	this.products = products;
}

public Cart() {
	super();
	// TODO Auto-generated constructor stub
}

    
   

}