package com.ha.graphql.infrastructure.driving.model;

import lombok.*;

import java.time.OffsetDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
	private OffsetDateTime timestamp;
	private String message;
	private List<ErrorDetails> errors;
}
