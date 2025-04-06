package com.ha.graphql.infrastructure.driven.persistence.repository;

import com.ha.graphql.infrastructure.driven.persistence.entity.MovementsEntity;
import com.ha.graphql.infrastructure.driven.persistence.model.MovResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovementsEntityRepository extends JpaRepository<MovementsEntity, Long> {
	List<MovementsEntity> findByProduct_Id(Long productId);

	@Query(
			value =
					"""
							SELECT new com.ha.graphql.infrastructure.driven.persistence.model.MovResult(
									me.id,
									me.transactionDate,
									me.description,
									me.amount,
									CASE
										WHEN (SELECT COUNT(sub) FROM MovementsEntity sub WHERE sub.id > :id) > 0
										THEN true
										ELSE false
									END
								)
							FROM MovementsEntity me
							WHERE me.id > :id
							ORDER BY me.createdAt ASC
							LIMIT :limit
							"""
	)
	List<MovResult> movementWithNextPageCursor(Long id, int limit);

	@Query(
			value =
					"""
							SELECT new com.ha.graphql.infrastructure.driven.persistence.model.MovResult(
									me.id,
									me.transactionDate,
									me.description,
									me.amount,
									CASE
										WHEN (SELECT COUNT(sub) FROM MovementsEntity sub WHERE sub.id < :id) > 0
										THEN true
										ELSE false
									END
								)
								FROM MovementsEntity me
								WHERE me.id < :id
								ORDER BY me.createdAt ASC
								LIMIT :limit
							"""
	)
	List<MovResult> movementWithPreviousPageCursor(Long id, int limit);

	@Query(
			value =
					"""
								SELECT new com.ha.graphql.infrastructure.driven.persistence.model.MovResult(
									me.id,
									me.transactionDate,
									me.description,
									me.amount,
									false
								 )
								FROM MovementsEntity me
								WHERE me.product.id = :productId
								ORDER BY me.createdAt ASC
								LIMIT :limit
							"""
	)
	List<MovResult> movementWithoutCursor(Long productId, int limit);
}