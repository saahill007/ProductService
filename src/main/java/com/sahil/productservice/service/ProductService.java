package com.sahil.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahil.productservice.model.Product;
import com.sahil.productservice.model.dto.ProductRequest;
import com.sahil.productservice.model.dto.ProductResponse;
import com.sahil.productservice.repository.ProductRepository;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@Builder
@Slf4j
public class ProductService {
	
	@Autowired
	ProductRepository repo;
	public void createProductService(ProductRequest productRequest) {
		Product product = Product.builder()
				.name(productRequest.getName())
				.desc(productRequest.getDesc())
				.price(productRequest.getPrice())
				.build();
		repo.save(product);
		
		log.info("Product {} is added in the database",product.getId());
		
	}
	public List<ProductResponse> getAllProducts() {
		List<Product> products = repo.findAll();
		
		return products.stream().map(product->mapToProductResponse(product)).toList();
		
	}
	public ProductResponse mapToProductResponse(Product product) {
		return ProductResponse.builder()
				.name(product.getName())
				.id(product.getId())
				.desc(product.getDesc())
				.price(product.getPrice())
				.build();
	}
}
