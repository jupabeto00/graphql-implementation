package com.ha.graphql.infrastructure.driven.persistence.repository;

import com.ha.graphql.infrastructure.driven.persistence.entity.CreditEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditEntityRepository extends JpaRepository<CreditEntity, Long> {
}