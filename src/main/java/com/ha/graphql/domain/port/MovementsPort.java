package com.ha.graphql.domain.port;

import com.ha.graphql.domain.model.Movements;
import com.ha.graphql.domain.model.graphql.MovementsResult;

import java.util.List;

public interface MovementsPort {
	    /**
     * Retrieves a list of movements by product ID.
     *
     * @param productId the ID of the product
     * @return a list of movements
     */
    List<Movements> getByProductId(Long productId);

    /**
     * Retrieves a list of movement results with a next page cursor.
     *
     * @param id the ID for the cursor
     * @param limit the maximum number of results to return
     * @return a list of movement results
     */
    List<MovementsResult> movementsWithNextPageCursor(Long id, int limit);

    /**
     * Retrieves a list of movement results with a previous page cursor.
     *
     * @param id the ID for the cursor
     * @param limit the maximum number of results to return
     * @return a list of movement results
     */
    List<MovementsResult> booksWithPreviousPageCursor(Long id, int limit);

    /**
     * Retrieves a list of movement results without using a cursor.
     *
     * @param productId the ID of the product
     * @param limit the maximum number of results to return
     * @return a list of movement results
     */
    List<MovementsResult> booksWithoutCursor(Long productId, int limit);
}
