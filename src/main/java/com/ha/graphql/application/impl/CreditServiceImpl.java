package com.ha.graphql.application.impl;

import com.ha.graphql.application.port.CreditService;
import com.ha.graphql.domain.model.Credit;
import com.ha.graphql.domain.port.CreditPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CreditServiceImpl implements CreditService {

	private CreditPort creditPort;

	@Autowired
	public void setCreditPort(CreditPort creditPort) {
		this.creditPort = creditPort;
	}

	@Override
	public Credit retrieveByProductId(Long id) {
		log.debug("[START] ->  Retrieving credit with product id {}", id);
		Credit credit = creditPort.getByProductId(id);

		log.debug("[END] ->  Retrieving credit with product id {}", id);
		return credit;
	}
}

