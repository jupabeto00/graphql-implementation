package com.ha.graphql.domain.port;

import com.ha.graphql.domain.model.Product;

import java.util.List;

public interface ProductPort {
	Product getByNumber(String number);
	Product getByNumberAndUserId(String number, Integer userId);
	List<Product> getByUserId(Integer userId);
}
