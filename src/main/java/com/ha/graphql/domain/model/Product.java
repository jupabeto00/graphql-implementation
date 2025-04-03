package com.ha.graphql.domain.model;

import lombok.Builder;

import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
public record Product(Long id, String number, String type, LocalDateTime createdDate) implements Serializable {
  }