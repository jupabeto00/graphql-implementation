package com.ha.graphql.infrastructure.driven.mapper;

import com.ha.graphql.domain.model.CreditCard;
import com.ha.graphql.infrastructure.driven.persistence.entity.CreditCardEntity;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CreditCardMapper {
	CreditCardEntity toEntity(CreditCard creditCard);

	CreditCard toDto(CreditCardEntity creditCardEntity);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	CreditCardEntity partialUpdate(CreditCard creditCard, @MappingTarget CreditCardEntity creditCardEntity);
}