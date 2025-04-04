package com.ha.graphql.domain.port;

import com.ha.graphql.domain.model.User;

public interface UserPort {
	User getById(Long id);
	User getByName(String name);
}
