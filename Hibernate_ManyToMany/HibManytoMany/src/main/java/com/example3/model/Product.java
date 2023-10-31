package com.example3.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;

@Entity
@Table(name="products")
public class Product 
{
	@Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   @Column(name="product_id")
	   private int id;
	   
	   @Column(name="Product_name")
	   private String Name;
	   
	   @ManyToMany(mappedBy="products")
	  private Set<Cart> carts= new HashSet<Cart>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Set<Cart> getCarts() {
		return carts;
	}

	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}

	public Product(int id, String name, Set<Cart> carts) {
		super();
		this.id = id;
		Name = name;
		this.carts = carts;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	   
	   
	   
	   
	   
}

