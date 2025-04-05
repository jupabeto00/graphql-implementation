package com.ha.graphql.domain.model.graphql;

public record PageInfo(
		String startCursor, String endCursor, Boolean hasNextPage, Boolean hasPreviousPage
) {
}
