package com.ha.graphql.application.port;

import com.ha.graphql.domain.model.User;

public interface UserService {
	/**
	 * Retrieves a user by their unique identifier.
	 *
	 * @param id the unique identifier of the user to retrieve
	 * @return the User object corresponding to the given id
	 */
	User retrieveById(Long id);
}
