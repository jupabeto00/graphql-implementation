package com.ha.graphql.infrastructure.driven.persistence.adapter;

import com.ha.graphql.domain.model.Account;
import com.ha.graphql.domain.port.AccountPort;
import com.ha.graphql.infrastructure.driven.mapper.AccountMapper;
import com.ha.graphql.infrastructure.driven.persistence.entity.AccountEntity;
import com.ha.graphql.infrastructure.driven.persistence.repository.AccountEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AccountAdapter implements AccountPort {

	private AccountEntityRepository accountRepository;
	private AccountMapper accountMapper;

	@Autowired
	public void setAccountRepository(AccountEntityRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Autowired
	public void setAccountMapper(AccountMapper accountMapper) {
		this.accountMapper = accountMapper;
	}

	@Override
	public Account getById(Long id) {
		log.debug("[START] -> Persistence - Retrieving account with id {}", id);
		AccountEntity accountEntity = accountRepository.findById(id).orElse(null);
		log.debug("[END] -> Persistence - Retrieving account with id {}", id);
		return accountMapper.toDto(accountEntity);
	}
}
