package com.ha.graphql.domain.port;

import com.ha.graphql.domain.model.Product;

public interface ProductPort {
	Product getById(Long id);
}
