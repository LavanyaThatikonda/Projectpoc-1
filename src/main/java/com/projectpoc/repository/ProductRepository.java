package com.projectpoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectpoc.entity.Product;

public interface ProductRepository extends JpaRepository<Product ,Long>{

}
