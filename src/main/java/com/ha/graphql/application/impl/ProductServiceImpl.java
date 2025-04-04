package com.ha.graphql.application.impl;

import com.ha.graphql.application.port.ProductService;
import com.ha.graphql.domain.exception.PersistenceError;
import com.ha.graphql.domain.model.Product;
import com.ha.graphql.domain.port.ProductPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

	private ProductPort productPort;

	@Autowired
	public void setProductPort(ProductPort productPort) {
		this.productPort = productPort;
	}

	@Override
	public Product retrieveById(Long id) {
		log.debug("[START] ->  Retrieving product with id {}", id);
		Product product = productPort.getById(id);

		if (product == null) {
			throw new PersistenceError("ID", "Product ID not found.");
		}

		log.debug("[END] ->  Retrieving product with id {}", id);
		return product;
	}

	@Override
	public Product findByIdAndUserId(Long id, Integer userId) {
		log.debug("[START] ->  Retrieving product with id {} and userId {}", id, userId);
		Product product = productPort.getByIdAndUserId(id, userId);

		if (product == null) {
			throw new PersistenceError("ID", "Product ID not found.");
		}

		log.debug("[END] ->  Retrieving product with id {} and userId {}", id, userId);
		return product;
	}

	@Override
	public List<Product> retrieveByUserId(Integer userId) {
		log.debug("[START] ->  Retrieving product with userId {}", userId);
		List<Product> product = productPort.getByUserId(userId);

		if (product == null) {
			throw new PersistenceError("ID", "Product ID not found.");
		}

		log.debug("[END] ->  Retrieving product with userId {}", userId);
		return product;
	}
}
