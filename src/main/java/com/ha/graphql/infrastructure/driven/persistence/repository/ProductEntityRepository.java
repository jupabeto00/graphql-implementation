package com.ha.graphql.infrastructure.driven.persistence.repository;

import com.ha.graphql.infrastructure.driven.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductEntityRepository extends JpaRepository<ProductEntity, Long> {
	Optional<ProductEntity> findByNumberAndUser_Id(String number, Long userId);
	Optional<List<ProductEntity>> findByUser_Id(Long userId);

	Optional<ProductEntity> findByNumber(String number);
}