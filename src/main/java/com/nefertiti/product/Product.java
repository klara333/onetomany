package com.nefertiti.product;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.nefertiti.category.Category;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 128, nullable = false, unique = true)
	private String name;
	
	private float price;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Set<ProductDetails> details = new HashSet<ProductDetails>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	

public Set<ProductDetails> getDetails() {
		return details;
	}

	public void setDetails(Set<ProductDetails> details) {
		this.details = details;
	}

	//	///////////////////////////////////////////////////
	public void addDetail(String name, String value) {
		this.details.add(new ProductDetails(name, value, this));
	}

	public void setDetail(Integer id, String name, String value) {
		this.details.add(new ProductDetails(id, name, value, this));
	}
	
//	//////////////////////////////////////////////////////
	@Override
	public String toString() {
		return "Product [name=" + name + ", category=" + category + "]";
	}

}
