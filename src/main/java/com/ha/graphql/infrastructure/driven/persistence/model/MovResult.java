package com.ha.graphql.infrastructure.driven.persistence.model;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record MovResult(
		Long id,
		LocalDateTime transactionDate,
		String description,
		Double amount,
		Boolean hasPage
		) {
}
