package com.ha.graphql.infrastructure.driven.mapper;

import com.ha.graphql.domain.model.Movements;
import com.ha.graphql.infrastructure.driven.persistence.entity.MovementsEntity;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MovementsMapper {
	MovementsEntity toEntity(Movements movements);

	Movements toDto(MovementsEntity movementsEntity);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	MovementsEntity partialUpdate(Movements movements, @MappingTarget MovementsEntity movementsEntity);
}