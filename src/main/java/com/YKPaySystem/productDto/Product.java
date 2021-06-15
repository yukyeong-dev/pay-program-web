package com.YKPaySystem.productDto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Product {
	
	@JsonProperty("productCode")
	private String productCode;
	
	@JsonProperty("productName")
	private String productName;
	
	@JsonProperty("productExplain")
	private String productExplain;
	
	@JsonProperty("productPrice")
	private int productPrice;	
	
	@JsonProperty("productBarcode")
	private String productBarcode;
	
	@JsonProperty("productImgUrl")
	private String productImgUrl;
	
	@JsonProperty("productOldprice")
	private String productOldprice;


	public Product() {
		
	}

	public String getProductOldprice() {
		return productOldprice;
	}

	public void setProductOldprice(String productOldprice) {
		this.productOldprice = productOldprice;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductExplain() {
		return productExplain;
	}

	public void setProductExplain(String productExplain) {
		this.productExplain = productExplain;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductBarcode() {
		return productBarcode;
	}

	public void setProductBarcode(String productBarcode) {
		this.productBarcode = productBarcode;
	}

	public String getProductImgUrl() {
		return productImgUrl;
	}

	public void setProductImgUrl(String productImgUrl) {
		this.productImgUrl = productImgUrl;
	}

	public Product(String productCode, String productName, String productExplain, int productPrice,
			String productBarcode, String productImgUrl, String productOldprice) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productExplain = productExplain;
		this.productPrice = productPrice;
		this.productBarcode = productBarcode;
		this.productImgUrl = productImgUrl;
		this.productOldprice = productOldprice;
	}

	
	
	
}
