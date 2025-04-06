package com.ha.graphql.domain.model.graphql;

import java.time.LocalDateTime;

public record MovementsResult(
		Long id,
		LocalDateTime transactionDate,
		String description,
		Double amount,
		Boolean hasPage
		) {
}
