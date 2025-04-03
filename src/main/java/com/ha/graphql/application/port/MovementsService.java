package com.ha.graphql.application.port;

import com.ha.graphql.domain.model.Movements;

import java.util.List;

public interface MovementsService {
	List<Movements> retrieveMovementsByProductId(Long productId);
}
