package SpringBootDB2.SpringBootImportCompany;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import SpringBootDB2.SpringBootImportCompany.beans.Product;
import SpringBootDB2.SpringBootImportCompany.dao.ProductController;
import SpringBootDB2.SpringBootImportCompany.dao.ProductRepository;

@SpringBootApplication
public class SpringBootImportCompanyApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootImportCompanyApplication.class, args);
		ProductRepository productRepo = context.getBean(ProductRepository.class);
		ProductController productControl = new ProductController();
		Product product = new Product();
		Scanner inputScanner = new Scanner(System.in);
		int input, menuInput, generalInputInt;
		String generalInputString;
		double generalInputDouble;
		do {
			System.out.println("\nSelect one from the actions below:\n1) Add a product.\n2) Print the product's info.\n3) Print the product's price."
					+ "\n4) Print the product's price - weight ratio.\n5) Which product is more expensive.\n6) Check expiration date.\n7) Exit.");
			input = inputScanner.nextInt();
			switch(input)
			{
				case 1:
				{
					System.out.println("How to add a product?\n1) By entering all info\n2) By entering name, price and weight.");
					menuInput = inputScanner.nextInt();
					switch(menuInput)
					{
						case 1:
						{
							product = productControl.getControllerByAllComponents();
							productRepo.save(product);
							break;
						}
						case 2:
						{
							product = productControl.getControllerByFewComponents();
							productRepo.save(product);
							break;
						}
						default:
						{
							System.out.println("Wrong input.");
							break;
						}
					}
					break;
				}
				case 2:
				{
					System.out.println("Enter the product's name: ");
					inputScanner.nextLine();
					generalInputString = inputScanner.nextLine();
					if(productRepo.findByName(generalInputString).getName().equals(generalInputString))
					{
						System.out.println(productRepo.findByName(generalInputString));
						break;
					}
					System.out.println("No products found.");
					break;
				}
				case 3:
				{
					System.out.println("Enter the product's name: ");
					inputScanner.nextLine();
					generalInputString = inputScanner.nextLine();
					if(productRepo.findByName(generalInputString).getName().equals(generalInputString))
					{
						System.out.println("The product's price is: " + productRepo.findByName(generalInputString).getPrice());
						break;
					}
					System.out.println("No products found.");
					break;
				}
				case 4:
				{
					System.out.println("Enter the product's name: ");
					inputScanner.nextLine();
					generalInputString = inputScanner.nextLine();
					if(productRepo.findByName(generalInputString).getName().equals(generalInputString))
					{
						System.out.println("The product's price - weight ratio is: " + (productRepo.findByName(generalInputString).getPrice() / productRepo.findByName(generalInputString).getWeight()));
						break;
					}
					System.out.println("No products found.");
					break;
				}
				case 5:
				{
					System.out.println("Enter the first product's name: ");
					inputScanner.nextLine();
					generalInputString = inputScanner.nextLine();
					System.out.println("Enter the second product's name: ");
					String generalSecondInputString = inputScanner.nextLine();
					if(productRepo.findByName(generalInputString).getName().equals(generalInputString) && productRepo.findByName(generalSecondInputString).getName().equals(generalSecondInputString))
					{
						if(productRepo.findByName(generalInputString).getPrice() > productRepo.findByName(generalSecondInputString).getPrice())
						{
							System.out.println(generalInputString + " is more expensive.");
						}
						else if(productRepo.findByName(generalInputString).getPrice() < productRepo.findByName(generalSecondInputString).getPrice())
						{
							System.out.println(generalSecondInputString + " is more expensive.");
						}
						else if(productRepo.findByName(generalInputString).getPrice() == productRepo.findByName(generalSecondInputString).getPrice())
						{
							System.out.println("Both products are the same price.");
						}
						break;
					}
					System.out.println("One or both the products were not found.");
					break;
				}
				case 6: 
				{
					System.out.println("Enter the product's name: ");
					inputScanner.nextLine();
					generalInputString = inputScanner.nextLine();
					if(productRepo.findByName(generalInputString).getName().equals(generalInputString) && !productRepo.findByName(generalInputString).getExpiryDate().equals("N/A"))
					{
						System.out.println("The product's expiration date is: " + productRepo.findByName(generalInputString).getExpiryDate());
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");  
   						LocalDateTime now = LocalDateTime.now();
   						System.out.println("Today's date is: " + dtf.format(now));
						String today = dtf.format(now);
						String expDate = productRepo.findByName(generalInputString).getExpiryDate();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm");
						try
						{
							if(sdf.parse(expDate).before(sdf.parse(dtf.format(now))))
							{
								System.out.println("The product is out of date.");
								break;
							}
							else
							{
								System.out.println("The product is still good.");
								break;
							}
						}
						catch (Exception e)
						{
							System.out.println("Can't compare dates.");
						}
						break;
					}
					else if(productRepo.findByName(generalInputString).getExpiryDate().equals("N/A"))
					{
						System.out.println("The product does not have an expiration date.");
						break;
					}
					System.out.println("No products found.");
					break;
				}
				case 7:
				{
					System.out.println("Exiting...");
					return;
				}
				default:
				{
					System.out.println("Wrong input.");
					break;
				}
					
			}
				
		}
		while(true);
	}

}
