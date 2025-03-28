package com.ha.graphql.domain.model;

import java.io.Serializable;

/**
 * DTO for {@link com.ha.graphql.infrastructure.driven.persistence.entity.CreditEntity}
 */
public record Credit(Long id, Product product, Double balance) implements Serializable {
}