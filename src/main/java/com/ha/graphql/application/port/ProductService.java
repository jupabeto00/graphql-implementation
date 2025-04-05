package com.ha.graphql.application.port;

import com.ha.graphql.domain.model.Product;

import java.util.List;

public interface ProductService {
	/**
	 * Retrieves a product by its unique number identifier.
	 *
	 * @param number the unique identifier of the product
	 * @return the product corresponding to the given number
	 */
	Product retrieveByNumber(String number);

	/**
	 * Retrieves a product by its unique number and associated user ID.
	 *
	 * @param number the unique identifier of the product
	 * @param userId the identifier of the user associated with the product
	 * @return the product corresponding to the given number and user ID
	 */
	Product findByNumberAndUserId(String number, Integer userId);

	/**
	 * Retrieves a list of products associated with the given user ID.
	 *
	 * @param userId the identifier of the user associated with the products
	 * @return a list of products associated with the given user ID
	 */
	List<Product> retrieveByUserId(Integer userId);
}
