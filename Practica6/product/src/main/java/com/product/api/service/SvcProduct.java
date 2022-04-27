package com.product.api.service;

import java.util.List;

import com.product.api.dto.ApiResponse;
import com.product.api.entity.Product;

public interface SvcProduct {

	List<Product> getProducts(Integer category_id);
	
	ApiResponse updateProduct(Integer product_id, Product product);
}
