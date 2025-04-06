package com.ha.graphql.application.port;

import com.ha.graphql.domain.model.Account;

public interface AccountService {
	/**
	 * Retrieves an account based on the given product ID.
	 *
	 * @param productId the ID of the product associated with the account
	 * @return the account associated with the specified product ID
	 */
	Account retrieveByProductId(Long productId);
}
