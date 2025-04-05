package com.ha.graphql.application.port;

import com.ha.graphql.domain.model.Credit;

public interface CreditService {
	/**
	 * Retrieve a Credit instance given a product ID.
	 *
	 * @param productId The product ID to search for.
	 * @return The Credit instance associated with the given product ID, or
	 *         {@code null} if no matching credit is found.
	 */
	Credit retrieveByProductId(Long productId);
}
