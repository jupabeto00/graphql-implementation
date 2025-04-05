package com.ha.graphql.application.impl;

import com.ha.graphql.application.port.MovementsService;
import com.ha.graphql.domain.exception.PersistenceError;
import com.ha.graphql.domain.model.Movements;
import com.ha.graphql.domain.model.graphql.*;
import com.ha.graphql.domain.port.MovementsPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class MovementsServiceImpl implements MovementsService {
	private MovementsPort movementsPort;

	@Autowired
	public void setMovementsPort(MovementsPort movementsPort) {
		this.movementsPort = movementsPort;
	}

	@Override
	public List<Movements> retrieveMovementsByProductId(Long productId) {
		log.debug("[START] ->  Retrieving movements with product id {}", productId);
		List<Movements> movements = movementsPort.getByProductId(productId);

		if (movements == null) {
			throw new PersistenceError("ID", "Movements with Product ID not found.");
		}

		log.debug("[END] ->  Retrieving movements with product id {}", productId);
		return movements;
	}

	@Override
	public MovementsConnection retrieveMovementsByProductIdPaginated(Long productId, CursorInfo cursorInfo) {
		int pageSize = cursorInfo.pageSize();

		// Limit is pageSize + 1
		var limit = pageSize + 1;
		List<MovementsResult> movementsResult;
		boolean hasNextPage;
		boolean hasPreviousPage;
		String startCursor;
		String endCursor;

		if (cursorInfo.hasCursors() && cursorInfo.hasNextPageCursor()) {
			movementsResult =
					movementsPort.movementsWithNextPageCursor(CursorInfo.decode(cursorInfo.getCursor()), limit);
			int resultSize = movementsResult.size();
			var firstResult = movementsResult.getFirst();
			hasPreviousPage = firstResult.hasPage();
			startCursor = CursorInfo.encode(firstResult.id());
			int endCursorIndex = resultSize > pageSize ? pageSize - 1 : resultSize - 1;
			endCursor = CursorInfo.encode(movementsResult.get(endCursorIndex).id());
			hasNextPage = resultSize > pageSize;

		} else if (cursorInfo.hasCursors() && cursorInfo.hasPrevPageCursor()) {
			movementsResult =
					movementsPort.booksWithPreviousPageCursor(
							CursorInfo.decode(cursorInfo.getCursor()), limit);
			int resultSize = movementsResult.size();
			var firstResult = movementsResult.getFirst();
			hasNextPage = firstResult.hasPage();
			startCursor = CursorInfo.encode(firstResult.id());
			int endCursorIndex = resultSize > pageSize ? pageSize - 1 : resultSize - 1;
			endCursor = CursorInfo.encode(movementsResult.get(endCursorIndex).id());
			hasPreviousPage = resultSize > pageSize;
		} else {
			movementsResult = movementsPort.booksWithoutCursor(productId, limit);
			int resultSize = movementsResult.size();
			hasPreviousPage = false;
			MovementsResult firstResult = movementsResult.getFirst();
			startCursor = CursorInfo.encode(firstResult.id());
			int endCursorIndex = resultSize > pageSize ? pageSize - 1 : resultSize - 1;
			endCursor = CursorInfo.encode(movementsResult.get(endCursorIndex).id());
			hasNextPage = resultSize > pageSize;
		}

		List<MovementsEdge> movementsEdges =
				movementsResult.stream()
						.limit(cursorInfo.pageSize())
						.map(
								movResult ->
										new MovementsEdge(
												CursorInfo.encode(movResult.id()),
												Movements.builder()
														.id(movResult.id())
														.transactionDate(movResult.transactionDate())
														.description(movResult.description())
														.amount(movResult.amount())
														.build()
										)
						)
						.toList();

		MovementsConnection movementsConnection = new MovementsConnection(
				movementsEdges,
				new PageInfo(
						startCursor,
						endCursor,
						hasNextPage,
						hasPreviousPage
				)
		);

		log.debug("Pages, {}", movementsConnection);

		return movementsConnection;
	}
}
