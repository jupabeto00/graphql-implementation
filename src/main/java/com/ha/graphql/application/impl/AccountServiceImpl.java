package com.ha.graphql.application.impl;

import com.ha.graphql.application.port.AccountService;
import com.ha.graphql.domain.exception.PersistenceError;
import com.ha.graphql.domain.model.Account;
import com.ha.graphql.domain.port.AccountPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

	private AccountPort accountPort;

	@Autowired
	public void setAccountPort(AccountPort accountPort) {
		this.accountPort = accountPort;
	}

	@Override
	public Account retrieveById(Long id) {
		log.debug("[START] ->  Retrieving account with id {}", id);
		Account account = accountPort.getById(id);

		if (account == null) {
			throw new PersistenceError("ID", "Account ID not found.");
		}

		log.debug("[END] ->  Retrieving account with id {}", id);
		return account;
	}

}
