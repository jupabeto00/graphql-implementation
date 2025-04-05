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
		log.debug("[START] -> Retrieving paginated movements for product id {}", productId);

		int pageSize = cursorInfo.pageSize();
		List<MovementsResult> results;

		// If the cursor has a next page cursor, retrieve the next page of movements
		if (cursorInfo.hasCursors() && cursorInfo.hasNextPageCursor()) {
			log.debug("Retrieving movements with next page cursor");
			results = movementsPort.movementsWithNextPageCursor(
					CursorInfo.decode(cursorInfo.getCursor()),
					pageSize
			);
		}
		// If the cursor has a previous page cursor, retrieve the previous page of movements
		else if (cursorInfo.hasCursors() && cursorInfo.hasPrevPageCursor()) {
			log.debug("Retrieving movements with previous page cursor");
			results = movementsPort.booksWithPreviousPageCursor(
					CursorInfo.decode(cursorInfo.getCursor()),
					pageSize
			);
		}
		// If the cursor does not have a next or previous page cursor, retrieve the first page of movements
		else {
			log.debug("Retrieving movements without cursor");
			results = movementsPort.booksWithoutCursor(productId, pageSize);
		}

		// Map the results to a list of edges
		List<MovementsEdge> edges = results.stream()
				.limit(pageSize)
				.map(movResult -> new MovementsEdge(
						CursorInfo.encode(movResult.id()),
						Movements.builder()
								.id(movResult.id())
								.transactionDate(movResult.transactionDate())
								.description(movResult.description())
								.amount(movResult.amount())
								.build()
				))
				.toList();

		// Determine if there are more pages after and before the current page
		boolean hasNextPage = results.size() > pageSize;
		boolean hasPreviousPage = cursorInfo.hasCursors() && results.size() == pageSize;

		log.debug("Retrieved {} movements, hasNextPage: {}, hasPreviousPage: {}", edges.size(), hasNextPage, hasPreviousPage);

		// Create a connection object with the list of edges and page information
		MovementsConnection connection = new MovementsConnection(
				edges,
				new PageInfo(
						CursorInfo.encode(edges.getFirst().node().id()),
						CursorInfo.encode(edges.getLast().node().id()),
						hasNextPage,
						hasPreviousPage
				)
		);

		log.debug("[END] -> Completed retrieving paginated movements for product id {}", productId);
		return connection;
	}
}
