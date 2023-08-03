package com.sahil.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sahil.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
