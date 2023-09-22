package com.example.testrdsmysql.controller.advice;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record ErrorDTO(@JsonProperty("message") String message,
                       @JsonProperty("timestamp") LocalDateTime timestamp) {
}
