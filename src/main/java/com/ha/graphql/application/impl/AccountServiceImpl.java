package com.ha.graphql.application.impl;

import com.ha.graphql.application.port.AccountService;
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
	public Account retrieveByProductId(Long productId) {
		log.debug("[START] ->  Retrieving account with product id {}", productId);
		Account account = accountPort.getByProductId(productId);

		log.debug("[END] ->  Retrieving account with product id {}", productId);
		return account;
	}
}
