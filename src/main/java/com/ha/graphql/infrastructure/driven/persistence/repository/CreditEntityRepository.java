package com.ha.graphql.infrastructure.driven.persistence.repository;

import com.ha.graphql.infrastructure.driven.persistence.entity.CreditEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CreditEntityRepository extends JpaRepository<CreditEntity, Long> {
	Optional<CreditEntity> findByProduct_Id(Long productId);
}