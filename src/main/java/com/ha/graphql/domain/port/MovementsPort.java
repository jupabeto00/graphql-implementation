package com.ha.graphql.domain.port;

import com.ha.graphql.domain.model.Movements;
import com.ha.graphql.domain.model.graphql.MovementsResult;

import java.util.List;

public interface MovementsPort {
	List<Movements> getByProductId(Long productId);

	List<MovementsResult> movementsWithNextPageCursor(Long id, int limit);

	List<MovementsResult> booksWithPreviousPageCursor(Long id, int limit);

	List<MovementsResult> booksWithoutCursor(Long productId, int limit);
}
