package com.ha.graphql.application.port;

import com.ha.graphql.domain.model.Account;

public interface AccountService {
	Account retrieveById(Long id);
	Account retrieveByProductId(Long productId);
}
