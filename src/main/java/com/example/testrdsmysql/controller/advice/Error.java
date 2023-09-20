package com.example.testrdsmysql.controller.advice;

import java.time.LocalDateTime;

public record Error(String message, LocalDateTime timestamp) {
}
