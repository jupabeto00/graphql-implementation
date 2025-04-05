package com.ha.graphql.domain.port;

import com.ha.graphql.domain.model.Account;

public interface AccountPort {
	/**
	 * Returns an Account by id
	 * @param id the id to search
	 * @return the Account if found, null otherwise
	 */
	Account getById(Long id);

	/**
	 * Returns an Account by productId
	 * @param id the productId to search
	 * @return the Account if found, null otherwise
	 */
	Account getByProductId(Long id);
}
