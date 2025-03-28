package com.ha.graphql.domain.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.ha.graphql.infrastructure.driven.persistence.entity.MovementsEntity}
 */
public record Movements(Long id, Product product, LocalDateTime transactionDate, String description, Double amount,
                        String createdAt) implements Serializable {
}