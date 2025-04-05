package com.ha.graphql.application.port;

import com.ha.graphql.domain.model.CreditCard;

public interface CreditCardService {
	/**
	 * Retrieve a credit card by its ID.
	 *
	 * @param id the credit card's ID
	 * @return the retrieved credit card
	 */
	CreditCard retrieveById(Long id);
	/**
	 * Retrieve a credit card by its product's ID.
	 *
	 * @param productId the product's ID
	 * @return the retrieved credit card
	 */
	CreditCard retrieveByProductId(Long productId);
}
