package com.selukar.ProductSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class ProductSpringApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProductSpringApplication.class, args);

		//dependency injection of product service class using getBean
		ProductService service = context.getBean(ProductService.class);

		getAllProducts(service);

		System.out.println("=================================");
		//Assignment 1 : Products by name
		getProductByName(service);

		System.out.println("=================================");
		//Assignment 2 : Products by containing text
		getProductsByText(service);

		System.out.println("=================================");
		//Assignment 3 : Out of warranty products
		getOutOfWarranty(service);

	}
	public static void getAllProducts(ProductService service){
		System.out.println("=================================");
		System.out.println("Available data in Database");
		List<Product> products = service.getAllProducts();
		for(Product p : products){
			System.out.println(p);
		}
	}
	public static void getProductByName(ProductService service){
		List<Product> products = service.getProductByName("BlackBeast");
		System.out.println("Data which is having name as BlackBeast in Database");
		for(Product p : products){
			System.out.println(p);
		}
	}
	public static void getProductsByText(ProductService service){
		List<Product> products = service.getProductsByText("laptop");
		System.out.println("Data which is having laptop text in any column in Database");
		for(Product p : products){
			System.out.println(p);
		}
	}
	public static void getOutOfWarranty(ProductService service){
		List<Product> products = service.getOutOfWarranty(2023);
		System.out.println("Out of warranty products");
		for(Product p : products){
			System.out.println(p);
		}
		System.out.println("=================================");
	}

}
