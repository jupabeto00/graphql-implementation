package com.ha.graphql.domain.port;

import com.ha.graphql.domain.model.Credit;

public interface CreditPort {
	/**
	 * Retrieve a Credit by its unique identifier.
	 *
	 * @param id the unique identifier of the Credit
	 * @return the Credit with the specified id
	 */
	Credit getById(Long id);

	/**
	 * Retrieve a Credit by its associated Product id.
	 *
	 * @param id the unique identifier of the Product
	 * @return the Credit associated with the specified Product id
	 */
	Credit getByProductId(Long id);
}
