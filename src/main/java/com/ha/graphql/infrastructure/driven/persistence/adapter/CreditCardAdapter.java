package com.ha.graphql.infrastructure.driven.persistence.adapter;

import com.ha.graphql.domain.model.CreditCard;
import com.ha.graphql.domain.port.CreditCardPort;
import com.ha.graphql.infrastructure.driven.mapper.CreditCardMapper;
import com.ha.graphql.infrastructure.driven.persistence.entity.CreditCardEntity;
import com.ha.graphql.infrastructure.driven.persistence.repository.CreditCardEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CreditCardAdapter implements CreditCardPort {

	private CreditCardEntityRepository creditCardEntityRepository;
	private CreditCardMapper creditCardMapper;

	@Autowired
	public void setCreditCardEntityRepository(CreditCardEntityRepository creditCardEntityRepository) {
		this.creditCardEntityRepository = creditCardEntityRepository;
	}

	@Autowired
	public void setCreditCardMapper(CreditCardMapper creditCardMapper) {
		this.creditCardMapper = creditCardMapper;
	}

	@Override
	public CreditCard getById(Long id) {
		log.debug("[START] -> Persistence - Retrieving creditCard with id {}", id);
		CreditCardEntity creditCardEntity = creditCardEntityRepository.findById(id).orElse(null);
		log.debug("[END] -> Persistence - Retrieving creditCard with id {}", id);
		return creditCardMapper.toDto(creditCardEntity);
	}
}
