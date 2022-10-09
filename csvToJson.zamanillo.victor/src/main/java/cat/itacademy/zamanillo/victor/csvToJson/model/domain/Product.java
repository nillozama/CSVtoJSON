package cat.itacademy.zamanillo.victor.csvToJson.model.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
	
	//@JsonProperty("Name")
	private String name;
	//@JsonProperty("Brand")
	private String brand;
	//@JsonProperty("Price")
	private double price;
	//@JsonProperty("Stock")
	private int stock;
	
	public Product() {	
		
	}
	
	@JsonCreator
	public Product(@JsonProperty("Name") String name, @JsonProperty("Brand") String brand, @JsonProperty("Price") double price, @JsonProperty("Stock")int stock) {
		super();
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.stock=stock;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
}
