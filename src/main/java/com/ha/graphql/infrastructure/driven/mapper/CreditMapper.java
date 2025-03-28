package com.ha.graphql.infrastructure.driven.mapper;

import com.ha.graphql.domain.model.Credit;
import com.ha.graphql.infrastructure.driven.persistence.entity.CreditEntity;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CreditMapper {
	CreditEntity toEntity(Credit credit);

	Credit toDto(CreditEntity creditEntity);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	CreditEntity partialUpdate(Credit credit, @MappingTarget CreditEntity creditEntity);
}