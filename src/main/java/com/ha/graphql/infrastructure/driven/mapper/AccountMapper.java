package com.ha.graphql.infrastructure.driven.mapper;

import com.ha.graphql.domain.model.Account;
import com.ha.graphql.infrastructure.driven.persistence.entity.AccountEntity;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AccountMapper {
	AccountEntity toEntity(Account account);

	Account toDto(AccountEntity accountEntity);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	AccountEntity partialUpdate(Account account, @MappingTarget AccountEntity accountEntity);
}