package com.ha.graphql.application.port;

import com.ha.graphql.domain.model.Product;

public interface ProductService {
	Product retrieveById(Long id);
}
