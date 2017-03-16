package com.example.product;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="products")
public class Products {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="description")
	@NotEmpty(message = "*Please provide your name")
	private String description;
	
	@Temporal(TemporalType.DATE)
	@Column(name="purchased_date")
	@NotNull(message="not nul xxx")
	@DateTimeFormat(pattern="dd-MMM-yyyy")
	private Date purchsedDate;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="product_detial_id")
	private ProductDetail productDetail;
	
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL)
	private List<ProductOrder> productOrder;
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPurchsedDate() {
		return purchsedDate;
	}

	public void setPurchsedDate(Date purchsedDate) {
		this.purchsedDate = purchsedDate;
	}

	public Products() {
		
	}

	public ProductDetail getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(ProductDetail productDetail) {
		this.productDetail = productDetail;
	}

	public Products(long id, String description, Date purchsedDate, ProductDetail productDetail,
			List<ProductOrder> productOrder) {
		super();
		this.id = id;
		this.description = description;
		this.purchsedDate = purchsedDate;
		this.productDetail = productDetail;
		this.productOrder = productOrder;
	}
	
	
	
	
	

}
