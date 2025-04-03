package com.ha.graphql.infrastructure.driven.persistence.adapter;

import com.ha.graphql.domain.model.Credit;
import com.ha.graphql.domain.port.CreditPort;
import com.ha.graphql.infrastructure.driven.mapper.CreditMapper;
import com.ha.graphql.infrastructure.driven.persistence.entity.CreditEntity;
import com.ha.graphql.infrastructure.driven.persistence.repository.CreditEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CreditAdapter implements CreditPort {

	private CreditEntityRepository creditEntityRepository;
	private CreditMapper creditMapper;

	@Autowired
	public void setCreditEntityRepository(CreditEntityRepository creditEntityRepository) {
		this.creditEntityRepository = creditEntityRepository;
	}

	@Autowired
	public void setCreditMapper(CreditMapper creditMapper) {
		this.creditMapper = creditMapper;
	}

	@Override
	public Credit getById(Long id) {
		log.debug("[START] -> Persistence - Retrieving credit with id {}", id);
		CreditEntity creditEntity = creditEntityRepository.findById(id).orElse(null);
		log.debug("[END] -> Persistence - Retrieving credit with id {}", id);
		return creditMapper.toDto(creditEntity);
	}
}
