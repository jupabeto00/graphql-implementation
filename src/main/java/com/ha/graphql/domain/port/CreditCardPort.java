package com.ha.graphql.domain.port;

import com.ha.graphql.domain.model.CreditCard;

public interface CreditCardPort {
	CreditCard getById(Long id);
	CreditCard getByProductId(Long id);
}
