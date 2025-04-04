package com.ha.graphql.infrastructure.driven.mapper;

import com.ha.graphql.domain.model.User;
import com.ha.graphql.infrastructure.driven.persistence.entity.UserEntity;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
	UserEntity toEntity(User user);

	User toDto(UserEntity userEntity);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	UserEntity partialUpdate(User user, @MappingTarget UserEntity userEntity);
}