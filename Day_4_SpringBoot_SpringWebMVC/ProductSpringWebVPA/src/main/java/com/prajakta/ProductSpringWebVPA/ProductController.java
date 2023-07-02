package com.prajakta.ProductSpringWebVPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/product/{name}")
    public Product getProduct(@PathVariable String name) {
        return service.getProduct(name);
    }

    @PostMapping("/product")
    public void addProduct(@RequestBody Product p){
        service.addProduct(p);
    }

    @GetMapping("/product/name/{name}")
    public List<Product> getProductByName(@PathVariable String name){
        return service.getProductByName(name.toLowerCase());
    }
    @GetMapping("/product/getSearchByText/{searchText}")
    public List<Product> getProductsByText(@PathVariable String searchText){
        return service.getProductsByText(searchText.toLowerCase());
    }
    @GetMapping("/product/getOutOfWarranty/{warranty}")
    public List<Product> getOutOfWarranty(@PathVariable Integer warranty){
        return service.getOutOfWarranty(warranty);
    }
}
