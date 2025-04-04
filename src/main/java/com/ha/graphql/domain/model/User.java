package com.ha.graphql.domain.model;

import lombok.Builder;

import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
public record User(Long id, String name, LocalDateTime createdDate) implements Serializable {
}