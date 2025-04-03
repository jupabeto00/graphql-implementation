package com.ha.graphql.domain.port;

import com.ha.graphql.domain.model.Movements;

import java.util.List;

public interface MovementsPort {
	List<Movements> getByProductId(Long productId);
}
