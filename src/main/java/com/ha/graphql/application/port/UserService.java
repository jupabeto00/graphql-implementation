package com.ha.graphql.application.port;

import com.ha.graphql.domain.model.User;

public interface UserService {
	User retrieveById(Long id);
	User retrieveByName(String Name);
}
