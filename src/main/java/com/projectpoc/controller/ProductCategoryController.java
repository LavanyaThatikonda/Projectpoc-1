package com.projectpoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectpoc.entity.ProductCategory;
import com.projectpoc.service.ProductCategoryService;




@RestController
@RequestMapping("/category")
public class ProductCategoryController {
	
	@Autowired
	private  ProductCategoryService productCategoryService;
	
	@PostMapping("/hello")
    public ProductCategory createProductCategory(@RequestBody ProductCategory productCategory) {
        return productCategoryService.createProductCategory(productCategory);
    }
	@DeleteMapping("/delete/{id}")
    public void deleteProductCategory(@PathVariable int id) {
        productCategoryService.deleteProductCategory(id);
    }
	 @GetMapping("/{name}")
    public ProductCategory getProductCategoryByName(@PathVariable String name) {
	        return productCategoryService.getProductCategoryByName(name);
	    }
	 @PutMapping("/update/{id}")
	    public ProductCategory updateProductCategory(@PathVariable Long id, @RequestBody ProductCategory productCategory) {
	        return productCategoryService.updateProductCategory(id, productCategory);
	    }

	 @GetMapping("/getall")
		public List<ProductCategory> getall(){
			return  productCategoryService.getAllCategories();
		}
	
	
}
