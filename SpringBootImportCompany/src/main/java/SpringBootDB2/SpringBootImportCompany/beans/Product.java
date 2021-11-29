package SpringBootDB2.SpringBootImportCompany.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private double price;
	private double weight;
	private boolean kosher = true;
	private String manufacturer;
	private String manufacturerLand;
	private String expiryDate;
	
	public Product(String name, double price, double weight, boolean kosher, String manufacturer, String manufacturerLand, String expiryDate)
	{
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.kosher = kosher;
		this.manufacturer = manufacturer;
		this.manufacturerLand = manufacturerLand;
		this.expiryDate = expiryDate;
	}
	
	public Product(String name, double price, double weight)
	{
		this.name = name;
		this.price = price;
		this.weight = weight;
	}
	
}
