package com.product.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.product.api.dto.ApiResponse;
import com.product.api.entity.Product;
import com.product.api.repository.RepoProduct;
import com.product.exception.ApiException;

@Service
public class SvcProductImp implements SvcProduct {

	@Autowired
	RepoProduct repo;
	
	@Override
	public List<Product> getProducts(Integer category_id) {
		List<Product> product = repo.findByCategoryId(category_id);
		if (product == null)
			throw new ApiException(HttpStatus.NOT_FOUND, "product does not exists");
		else 
			return product;
	}

	
	
	@Override
	public ApiResponse updateProduct(Integer product_id, Product product) {
		Product productSaved = (Product) repo.findByProductId(product_id);
		if(productSaved == null) 
			throw new ApiException(HttpStatus.NOT_FOUND,"product does not exists");
		else {
			if(productSaved.getStatus() == 0) 
				throw new ApiException(HttpStatus.BAD_REQUEST,"product is not activate");	
			else {
				productSaved = (Product) repo.findByProduct(product.getProduct());
				if(productSaved != null) 
					throw new ApiException(HttpStatus.BAD_REQUEST, "product already exists"); 
				repo.updateProduct(product_id, product.getProduct(), product.getGtin(), product.getDescription(), product.getPrice(), product.getStock());
				return new ApiResponse("product update");					
			}
		}
	}

}
