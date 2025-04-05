package com.ha.graphql.domain.model.graphql;

import com.ha.graphql.domain.model.Movements;

public record MovementsEdge(
		String cursor,
		Movements node
) {
}
