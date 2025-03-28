package com.ha.graphql.infrastructure.driven.persistence.repository;

import com.ha.graphql.infrastructure.driven.persistence.entity.MovementsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementsEntityRepository extends JpaRepository<MovementsEntity, Long> {
}