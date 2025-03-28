package com.ha.graphql.domain.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.ha.graphql.infrastructure.driven.persistence.entity.ProductEntity}
 */
public record Product(Long id, String type, LocalDateTime createdDate) implements Serializable {
  }