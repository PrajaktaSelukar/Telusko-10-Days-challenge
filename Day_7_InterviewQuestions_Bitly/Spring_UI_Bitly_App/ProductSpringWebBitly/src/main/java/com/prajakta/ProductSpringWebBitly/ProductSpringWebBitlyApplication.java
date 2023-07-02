package com.prajakta.ProductSpringWebBitly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductSpringWebBitlyApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(ProductSpringWebBitlyApplication.class, args);
		} catch (Exception e) {
			System.err.println("An error occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
