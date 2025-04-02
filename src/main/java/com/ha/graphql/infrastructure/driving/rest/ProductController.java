package com.ha.graphql.infrastructure.driving.rest;

import com.ha.graphql.application.port.AccountService;
import com.ha.graphql.domain.model.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class ProductController {

	private AccountService accountService;

	@Autowired
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	@QueryMapping()
	public Account getAccount(@Argument Long id) {
			return accountService.retrieveById(id);
	}
}
