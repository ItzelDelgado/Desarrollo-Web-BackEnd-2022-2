package com.product.api.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.product.api.entity.Product;

@Repository
public interface RepoProduct extends JpaRepository<Product, Integer> {

	@Query(value="SELECT * FROM product WHERE category_id = :category_id", nativeQuery = true)
	List<Product> findByCategoryId(@Param("category_id") Integer category_id);
	
	@Query(value="SELECT * FROM product WHERE product_id = :product_id AND status = 1", nativeQuery = true)
	Product findByProductId(@Param("product_id") Integer product_id);
	
	@Query(value="SELECT * FROM product WHERE product = :product", nativeQuery = true)
	Product findByProduct(@Param("product") String product);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE product SET product = :product, price = :price, description = :description,  gtin = :gtin, stock = :stock WHERE product_id = :product_id", nativeQuery = true)
	Integer updateProduct(@Param("product_id") Integer product_id, @Param("product") String product, @Param("gtin") String gtin, @Param("description") String description, @Param("price") Double price, @Param("stock") Integer stock);
}
