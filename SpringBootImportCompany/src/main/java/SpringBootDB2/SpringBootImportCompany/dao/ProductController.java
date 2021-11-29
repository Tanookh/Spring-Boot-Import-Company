package SpringBootDB2.SpringBootImportCompany.dao;

import java.util.Scanner;

import SpringBootDB2.SpringBootImportCompany.beans.Product;

public class ProductController {

    public Product getControllerByAllComponents() {
        Scanner inputScanner = new Scanner(System.in);
        Product product = new Product();
        String generalInputString;
        Double generalInputDouble;
        System.out.println("Enter the product's name: ");
        generalInputString = inputScanner.nextLine();
        product.setName(generalInputString);
        System.out.println("Enter the product's price: ");
        generalInputDouble = inputScanner.nextDouble();
        product.setPrice(generalInputDouble);
        System.out.println("Enter the product's weight: ");
        generalInputDouble = inputScanner.nextDouble();
        product.setWeight(generalInputDouble);
        inputScanner.nextLine();
        System.out.println("Is the product kosher?\nLeave empty or type 'y' for yes or 'n' for no: ");
        generalInputString = inputScanner.nextLine();
        if(generalInputString.equals("n") || generalInputString.equals("N"))
        {
            product.setKosher(false);
        }
        System.out.println("Enter the product's Manufacturer: ");
        generalInputString = inputScanner.nextLine();
        product.setManufacturer(generalInputString);
        System.out.println("Enter the product's Manufacturer land: ");
        generalInputString = inputScanner.nextLine();
        product.setManufacturerLand(generalInputString);
        StringBuilder sb = new StringBuilder();
        System.out.println("Enter the product's expiration date");
        System.out.println("Year: ");
        generalInputString = inputScanner.nextLine();
        sb.append(generalInputString);
        sb.append("/");
        System.out.println("Month: ");
        generalInputString = inputScanner.nextLine();
        sb.append(generalInputString);
        sb.append("/");
        System.out.println("Day: ");
        generalInputString = inputScanner.nextLine();
        sb.append(generalInputString);
        sb.append(" ");
        System.out.println("Hour: ");
        generalInputString = inputScanner.nextLine();
        sb.append(generalInputString);
        sb.append(":");
        System.out.println("Minute: ");
        generalInputString = inputScanner.nextLine();
        sb.append(generalInputString);
        generalInputString = sb.toString();
        product.setExpiryDate(generalInputString);
        return product;
    }

    public Product getControllerByFewComponents() {
        Scanner inputScanner = new Scanner(System.in);
        Product product = new Product();
        String generalInputString;
        Double generalInputDouble;
        System.out.println("Enter the product's name: ");
        generalInputString = inputScanner.nextLine();
        product.setName(generalInputString);
        System.out.println("Enter the product's price: ");
        generalInputDouble = inputScanner.nextDouble();
        product.setPrice(generalInputDouble);
        System.out.println("Enter the product's weight: ");
        generalInputDouble = inputScanner.nextDouble();
        product.setWeight(generalInputDouble);
        product.setManufacturer("N/A");
        product.setManufacturerLand("N/A");
        product.setExpiryDate("N/A");
        return product;
    }
    
}
