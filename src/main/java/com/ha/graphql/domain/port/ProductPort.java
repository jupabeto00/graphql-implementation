package com.ha.graphql.domain.port;

import com.ha.graphql.domain.model.Product;

import java.util.List;

public interface ProductPort {
	Product getById(Long id);
	Product getByIdAndUserId(Long id, Integer userId);
	List<Product> getByUserId(Integer userId);
}
