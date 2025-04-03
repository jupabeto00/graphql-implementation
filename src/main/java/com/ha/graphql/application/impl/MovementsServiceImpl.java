package com.ha.graphql.application.impl;

import com.ha.graphql.application.port.MovementsService;
import com.ha.graphql.domain.exception.PersistenceError;
import com.ha.graphql.domain.model.Movements;
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
}
