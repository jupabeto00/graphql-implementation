package com.ha.graphql.application.port;

import com.ha.graphql.domain.model.Product;

import java.util.List;

public interface ProductService {
	Product retrieveById(Long id);
	Product findByIdAndUserId(Long id, Integer userId);
	List<Product> retrieveByUserId(Integer userId);
}
