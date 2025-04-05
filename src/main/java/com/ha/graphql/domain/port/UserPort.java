package com.ha.graphql.domain.port;

import com.ha.graphql.domain.model.User;

public interface UserPort {
	/**
	 * Finds a user by the given ID.
	 *
	 * @param id the user ID.
	 * @return the user with the given ID, or {@code null} if no such user exists.
	 */
	User getById(Long id);
}
