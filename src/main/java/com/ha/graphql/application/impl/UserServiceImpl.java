package com.ha.graphql.application.impl;

import com.ha.graphql.application.port.UserService;
import com.ha.graphql.domain.exception.PersistenceError;
import com.ha.graphql.domain.model.Product;
import com.ha.graphql.domain.model.User;
import com.ha.graphql.domain.port.UserPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	private UserPort userPort;

	@Autowired
	public void setUserPort(UserPort userPort) {
		this.userPort = userPort;
	}

	@Override
	public User retrieveById(Long id) {
		log.debug("[START] ->  Retrieving user with id {}", id);
		User user = userPort.getById(id);

		if (user == null) {
			throw new PersistenceError("ID", "User ID not found.");
		}

		log.debug("[END] ->  Retrieving user with id {}", id);
		return user;
	}

	@Override
	public User retrieveByName(String name) {
		log.debug("[START] ->  Retrieving user with name {}", name);
		User user = userPort.getByName(name);

		if (user == null) {
			throw new PersistenceError("ID", "User Name not found.");
		}

		log.debug("[END] ->  Retrieving user with Name {}", name);
		return user;
	}
}
