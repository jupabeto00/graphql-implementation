package com.ha.graphql.application.port;

import com.ha.graphql.domain.model.CreditCard;

public interface CreditCardService {
	CreditCard retrieveById(Long id);
	CreditCard retrieveByProductId(Long productId);
}
