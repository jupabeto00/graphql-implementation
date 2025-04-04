package com.ha.graphql.infrastructure.driven.mapper;

import com.ha.graphql.domain.model.Product;
import com.ha.graphql.infrastructure.driven.persistence.entity.ProductEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {
	ProductEntity toEntity(Product product);

	Product toDto(ProductEntity productEntity);
	List<Product> toDto(List<ProductEntity> productEntity);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	ProductEntity partialUpdate(Product product, @MappingTarget ProductEntity productEntity);
}