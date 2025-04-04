package com.ha.graphql.application.port;

import com.ha.graphql.domain.model.Credit;

public interface CreditService {
	Credit retrieveById(Long id);
	Credit retrieveByProductId(Long productId);
}
