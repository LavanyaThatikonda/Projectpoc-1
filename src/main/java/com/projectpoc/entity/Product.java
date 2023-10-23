package com.projectpoc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private String productCode;
    private int totalStock;
    private double cost;
    private String expireDate;
    private String manufacturingDate;
    private String description;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory category;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    

	public Product() {
		super();
	}

	public Product(Long id, String productName, String productCode, int totalStock, double cost, String expireDate,
			String manufacturingDate, String description, ProductCategory category, Company company) {
		super();
		this.id = id;
		this.productName = productName;
		this.productCode = productCode;
		this.totalStock = totalStock;
		this.cost = cost;
		this.expireDate = expireDate;
		this.manufacturingDate = manufacturingDate;
		this.description = description;
		this.category = category;
		this.company = company;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public int getTotalStock() {
		return totalStock;
	}

	public void setTotalStock(int totalStock) {
		this.totalStock = totalStock;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public String getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(String manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
    
}
