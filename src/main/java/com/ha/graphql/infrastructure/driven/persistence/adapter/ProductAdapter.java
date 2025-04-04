package com.ha.graphql.infrastructure.driven.persistence.adapter;

import com.ha.graphql.domain.model.Product;
import com.ha.graphql.domain.port.ProductPort;
import com.ha.graphql.infrastructure.driven.mapper.ProductMapper;
import com.ha.graphql.infrastructure.driven.persistence.entity.ProductEntity;
import com.ha.graphql.infrastructure.driven.persistence.repository.ProductEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

	@Override
	public Product getByIdAndUserId(Long id, Integer userId) {
		log.debug("[START] -> Persistence - Retrieving product with id {} and userId {}", id, userId);
		ProductEntity product = productEntityRepository.findByIdAndUser_Id(id, Long.valueOf(userId)).orElse(null);
		log.debug("[END] -> Persistence - Retrieving product with id {} and userId {}", id, userId);
		return productMapper.toDto(product);
	}

	@Override
	public List<Product> getByUserId(Integer userId) {
		log.debug("[START] -> Persistence - Retrieving product with userId {}", userId);
		List<ProductEntity> product = productEntityRepository.findByUser_Id(Long.valueOf(userId)).orElse(null);
		log.debug("[END] -> Persistence - Retrieving product with userId {}", userId);
		return productMapper.toDto(product);
	}
}
