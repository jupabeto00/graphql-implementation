package com.ha.graphql.infrastructure.driven.persistence.adapter;

import com.ha.graphql.domain.model.Product;
import com.ha.graphql.domain.port.ProductPort;
import com.ha.graphql.infrastructure.driven.mapper.ProductMapper;
import com.ha.graphql.infrastructure.driven.persistence.entity.ProductEntity;
import com.ha.graphql.infrastructure.driven.persistence.repository.ProductEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductAdapter implements ProductPort {

	private ProductEntityRepository productEntityRepository;
	private ProductMapper productMapper;

	@Autowired
	public void setProductEntityRepository(ProductEntityRepository productEntityRepository) {
		this.productEntityRepository = productEntityRepository;
	}

	@Autowired
	public void setProductMapper(ProductMapper productMapper) {
		this.productMapper = productMapper;
	}

	@Override
	public Product getById(Long id) {
		log.debug("[START] -> Persistence - Retrieving product with id {}", id);
		ProductEntity product = productEntityRepository.findById(id).orElse(null);
		log.debug("[END] -> Persistence - Retrieving product with id {}", id);
		return productMapper.toDto(product);
	}
}
