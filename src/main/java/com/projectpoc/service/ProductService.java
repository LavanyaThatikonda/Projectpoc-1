package com.projectpoc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectpoc.entity.Company;
import com.projectpoc.entity.Product;
import com.projectpoc.entity.ProductCategory;
import com.projectpoc.repository.CompanyRepository;
import com.projectpoc.repository.ProductCategoryRepository;
import com.projectpoc.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductCategoryRepository categoryRepository;
    private final CompanyRepository companyRepository;

    @Autowired
    public ProductService(ProductRepository productRepository,
                          ProductCategoryRepository categoryRepository,
                          CompanyRepository companyRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.companyRepository = companyRepository;
    }
        
        public List<Product> getAllProducts() {
            return productRepository.findAll();
        }

        public Optional<Product> getProductById(Long productId) {
             return productRepository.findById(productId);
        }
        
        public Product createProduct(Product product, Long categoryId, Integer companyId) {
            ProductCategory category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new EntityNotFoundException("Product Category not found with id: " + categoryId));

            Company company = companyRepository.findById(companyId)
                    .orElseThrow(() -> new EntityNotFoundException("Product Company not found with id: " + companyId));

            product.setCategory(category);
            product.setCompany(company);

            return productRepository.save(product);
        }
        public Product updateProduct(Long productId, Product updatedProduct, Long categoryId, Integer companyId) {
            // Check if product exists
            Product existingProduct = productRepository.findById(productId)
                    .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + productId));

            ProductCategory category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new EntityNotFoundException("Product Category not found with id: " + categoryId));

            Company company = companyRepository.findById(companyId)
                    .orElseThrow(() -> new EntityNotFoundException("Product Company not found with id: " + companyId));
            existingProduct.setProductName(updatedProduct.getProductName());
            existingProduct.setProductCode(updatedProduct.getProductCode());
            existingProduct.setTotalStock(updatedProduct.getTotalStock());
            existingProduct.setCost(updatedProduct.getCost());
            existingProduct.setExpireDate(updatedProduct.getExpireDate());
            existingProduct.setManufacturingDate(updatedProduct.getManufacturingDate());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setCategory(category);
            existingProduct.setCompany(company);

            return productRepository.save(existingProduct);
        }
            public void deleteProduct(Long productId) {
                // Check if product exists
                Product existingProduct = productRepository.findById(productId)
                        .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + productId));

                productRepository.delete(existingProduct);
            }

    
    }

