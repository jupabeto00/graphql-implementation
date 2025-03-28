package com.ha.graphql.domain.port;

import com.ha.graphql.domain.model.Account;

public interface AccountPort {
	Account getById(Long id);
}
