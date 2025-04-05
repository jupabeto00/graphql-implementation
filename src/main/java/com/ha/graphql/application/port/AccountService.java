package com.ha.graphql.application.port;

import com.ha.graphql.domain.model.Account;

public interface AccountService {
	Account retrieveByProductId(Long productId);
}
