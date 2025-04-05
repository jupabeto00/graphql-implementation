package com.ha.graphql.application.port;

import com.ha.graphql.domain.model.Product;

import java.util.List;

public interface ProductService {
	Product retrieveByNumber(String number);
	Product findByNumberAndUserId(String number, Integer userId);
	List<Product> retrieveByUserId(Integer userId);
}
