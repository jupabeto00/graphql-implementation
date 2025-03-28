package com.ha.graphql.domain.model;

import java.io.Serializable;

public record Account(Long id, Product product, Double balance) implements Serializable {
}