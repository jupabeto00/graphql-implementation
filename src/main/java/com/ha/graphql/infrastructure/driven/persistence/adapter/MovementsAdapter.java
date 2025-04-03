package com.ha.graphql.infrastructure.driven.persistence.adapter;

import com.ha.graphql.domain.model.Movements;
import com.ha.graphql.domain.port.MovementsPort;
import com.ha.graphql.infrastructure.driven.mapper.MovementsMapper;
import com.ha.graphql.infrastructure.driven.persistence.entity.MovementsEntity;
import com.ha.graphql.infrastructure.driven.persistence.repository.MovementsEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MovementsAdapter implements MovementsPort {

	private MovementsEntityRepository movementsEntityRepository;
	private MovementsMapper movementsMapper;

	@Autowired
	public void setMovementsEntityRepository(MovementsEntityRepository movementsEntityRepository) {
		this.movementsEntityRepository = movementsEntityRepository;
	}

	@Autowired
	public void setMovementsMapper(MovementsMapper movementsMapper) {
		this.movementsMapper = movementsMapper;
	}

	@Override
	public List<Movements> getByProductId(Long productId) {
		log.debug("[START] -> Persistence - Retrieving movements with product id {}", productId);
		List<MovementsEntity> movements = movementsEntityRepository.findByProduct_Id(productId);
		log.debug("[END] -> Persistence - Retrieving movements with product id {}", productId);
		return movementsMapper.toDto(movements);
	}
}
