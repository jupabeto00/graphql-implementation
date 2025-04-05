package com.ha.graphql.domain.port;

import com.ha.graphql.domain.model.Product;

import java.util.List;

public interface ProductPort {
	/**
	 * Returns a product by its number.
	 *
	 * @param number the product number.
	 * @return the product, or null if it does not exist.
	 */
	Product getByNumber(String number);

	/**
	 * Returns a product by its number and user id.
	 *
	 * @param number the product number.
	 * @param userId the user id.
	 * @return the product, or null if it does not exist.
	 */
	Product getByNumberAndUserId(String number, Integer userId);

	/**
	 * Returns all products associated with a user.
	 *
	 * @param userId the user id.
	 * @return the list of products, or an empty list if there are no products associated with the user.
	 */
	List<Product> getByUserId(Integer userId);
}