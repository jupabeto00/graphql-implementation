package com.ha.graphql.infrastructure.driven.mapper;

import com.ha.graphql.domain.model.graphql.MovementsResult;
import com.ha.graphql.infrastructure.driven.persistence.model.MovResult;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MovementsResultMapper {
	MovResult toEntity(MovementsResult movementsResult);

	MovementsResult toDto(MovResult movResult);
	List<MovementsResult> toDto(List<MovResult> movResult);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	MovResult partialUpdate(MovementsResult movementsResult, @MappingTarget MovResult movResult);
}