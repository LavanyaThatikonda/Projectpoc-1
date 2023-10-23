package com.projectpoc.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectpoc.entity.ProductCategory;
import com.projectpoc.repository.ProductCategoryRepository;


import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductCategoryService {
    @Autowired
    private ProductCategoryRepository categoryRepository;

    public List<ProductCategory> getAllCategories() {
        return categoryRepository.findAll();
    }

    public ProductCategory getProductCategoryByName(String name) {
        return categoryRepository.findByName(name);
        
    }
    public ProductCategory createProductCategory(ProductCategory productCategory) {
        if (categoryRepository.findByName(productCategory.getName()) != null) {
            throw new RuntimeException("Category With this name already exists");
        }
        return categoryRepository.save(productCategory);
    }
    

     public void deleteProductCategory(int id) {
    	 ProductCategory category = categoryRepository.findById((long) id)
       .orElseThrow(() -> new EntityNotFoundException("Category not found"));
       categoryRepository.delete(category);
   }
     

     public ProductCategory updateProductCategory(Long id, ProductCategory productCategory) {
    	    ProductCategory existingCategory = categoryRepository.findById(id)
    	            .orElseThrow(() -> new EntityNotFoundException("Category not found"));

    	    // Update the existing category properties here
    	    existingCategory.setName(productCategory.getName());
    	    existingCategory.setDescription(productCategory.getDescription());

    	    return categoryRepository.save(existingCategory);
    	}

    
     
}
