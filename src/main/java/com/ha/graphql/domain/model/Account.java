package com.ha.graphql.domain.model;

import lombok.Builder;

import java.io.Serializable;

@Builder
public record Account(Long id, Product product, Double balance) implements Serializable {
}