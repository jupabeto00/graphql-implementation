package com.ha.graphql.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;

import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public record Movements(Long id, Product product, LocalDateTime transactionDate, String description, Double amount,
                        String createdAt) implements Serializable {
}