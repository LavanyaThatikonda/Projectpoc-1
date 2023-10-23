package com.projectpoc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projectpoc.entity.Product;
import com.projectpoc.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	private  ProductService productService;
	
	@GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

//    @PostMapping
//    public Product createProduct(@RequestBody Product product,
//                                 @RequestParam("categoryId") Long categoryId,
//                                 @RequestParam("companyId") Integer companyId) {
//        return productService.createProduct(product, categoryId, companyId);
    
    
    @PostMapping
    public void createProduct(@RequestBody Product product) {
        // Log the received product to inspect the format
        System.out.println("Received Product: " + product);
        // Rest of your code
    }

    
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,
                                 @RequestBody Product updatedProduct,
                                 @RequestParam("categoryId") Long categoryId,
                                 @RequestParam("companyId") Integer companyId) {
        return productService.updateProduct(id, updatedProduct, categoryId, companyId);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

}
