package com.ha.graphql.domain.exception;

import lombok.Getter;

@Getter
public class PersistenceError extends RuntimeException {
	private final String field;

	public PersistenceError(String field, String message) {
		super(message);
		this.field = field;
	}
}
