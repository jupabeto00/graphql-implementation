package com.ha.graphql.application.port;

import com.ha.graphql.domain.model.Movements;
import com.ha.graphql.domain.model.graphql.CursorInfo;
import com.ha.graphql.domain.model.graphql.MovementsConnection;

import java.util.List;

public interface MovementsService {
	List<Movements> retrieveMovementsByProductId(Long productId);

	MovementsConnection retrieveMovementsByProductIdPaginated(Long productId, CursorInfo cursorInfo);
}
