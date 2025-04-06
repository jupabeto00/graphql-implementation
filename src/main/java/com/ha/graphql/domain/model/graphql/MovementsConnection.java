package com.ha.graphql.domain.model.graphql;

import java.util.List;

public record MovementsConnection(
		List<MovementsEdge>edges,
		PageInfo pageInfo
) {
}
