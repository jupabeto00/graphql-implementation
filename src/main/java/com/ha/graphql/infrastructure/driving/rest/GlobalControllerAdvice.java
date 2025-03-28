package com.ha.graphql.infrastructure.driving.rest;

import com.ha.graphql.domain.exception.PersistenceError;
import com.ha.graphql.infrastructure.driving.model.ErrorDetails;
import com.ha.graphql.infrastructure.driving.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Collections;

@RestControllerAdvice
public class GlobalControllerAdvice extends RuntimeException {


	@ExceptionHandler(PersistenceError.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handlePersistenceError(PersistenceError e) {
		return ErrorResponse.builder()
				.timestamp(OffsetDateTime.now(ZoneId.of("America/Bogota")))
				.message(e.getMessage())
				.errors(Collections.singletonList(
						ErrorDetails.builder()
								.field(e.getField())
								.message(e.getCause().getMessage())
								.build()
				))
				.build();
	}
}
