package com.product.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.api.dto.ApiResponse;
import com.product.api.entity.Product;
import com.product.api.service.SvcProduct;
import com.product.exception.ApiException;

@RestController
@RequestMapping("/product")
public class CtrlProduct {

	@Autowired
	SvcProduct svc;
	
	/* Controlador encargardo de listar los productos por categoria*/
	@GetMapping("/category/{category_id}")
	public ResponseEntity<List<Product>> getProducts(@PathVariable int category_id){
		return new ResponseEntity<>(svc.getProducts(category_id), HttpStatus.OK);
	}

	/* Controlador encargardo de actualizar un producto*/	
	@PutMapping("/{product_id}")
	public ResponseEntity<ApiResponse> updateProduct(@PathVariable int product_id, @Valid @RequestBody Product product, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			throw new ApiException(HttpStatus.BAD_REQUEST, bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return new ResponseEntity<>(svc.updateProduct(product_id, product), HttpStatus.OK);
	}
	
}
