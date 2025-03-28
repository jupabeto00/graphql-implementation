package com.ha.graphql.infrastructure.driving.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
	private String field;
	private String message;
}
