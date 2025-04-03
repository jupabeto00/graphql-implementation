package com.ha.graphql.domain.port;

import com.ha.graphql.domain.model.Credit;

public interface CreditPort {
	Credit getById(Long id);
}
