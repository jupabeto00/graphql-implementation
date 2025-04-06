package com.ha.graphql.application.port;

import com.ha.graphql.domain.model.Movements;
import com.ha.graphql.domain.model.graphql.CursorInfo;
import com.ha.graphql.domain.model.graphql.MovementsConnection;

import java.util.List;

public interface MovementsService {
	/**
	 * Retrieve all movements for a given product id.
	 *
	 * @param productId the product id
	 * @return a list of movements
	 */
	List<Movements> retrieveMovementsByProductId(Long productId);

    /**
     * Retrieve paginated movements for a given product id.
     *
     * @param productId the product id
     * @param cursorInfo information for pagination, including page size and cursors
     * @return a connection object containing a list of movements edges and page information
     */
	MovementsConnection retrieveMovementsByProductIdPaginated(Long productId, CursorInfo cursorInfo);
}
