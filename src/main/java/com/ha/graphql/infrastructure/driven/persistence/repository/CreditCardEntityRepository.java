package com.ha.graphql.infrastructure.driven.persistence.repository;

import com.ha.graphql.infrastructure.driven.persistence.entity.CreditCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CreditCardEntityRepository extends JpaRepository<CreditCardEntity, Long> {
	Optional<CreditCardEntity> findByProduct_Id(Long productId);
}