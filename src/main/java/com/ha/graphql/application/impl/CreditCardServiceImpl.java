package com.ha.graphql.application.impl;

import com.ha.graphql.application.port.CreditCardService;
import com.ha.graphql.domain.exception.PersistenceError;
import com.ha.graphql.domain.model.CreditCard;
import com.ha.graphql.domain.port.CreditCardPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CreditCardServiceImpl implements CreditCardService {

	private CreditCardPort creditCardPort;

	@Autowired
	public void setCreditCardPort(CreditCardPort creditCardPort) {
		this.creditCardPort = creditCardPort;
	}

	@Override
	public CreditCard retrieveById(Long id) {
		log.debug("[START] ->  Retrieving creditCard with id {}", id);
		CreditCard creditCard = creditCardPort.getById(id);

		if (creditCard == null) {
			throw new PersistenceError("ID", "Credit Card ID not found.");
		}

		log.debug("[END] ->  Retrieving creditCard with id {}", id);
		return creditCard;
	}
}
