package com.ha.graphql.domain.port;

import com.ha.graphql.domain.model.CreditCard;

public interface CreditCardPort {
	/**
	 * Returns a CreditCard entity by its id.
	 * @param id unique identifier of the CreditCard entity.
	 * @return CreditCard entity.
	 */
	CreditCard getById(Long id);

	/**
	 * Returns a CreditCard entity by a product id.
	 * @param id unique identifier of the Product entity.
	 * @return CreditCard entity.
	 */
	CreditCard getByProductId(Long id);
}
