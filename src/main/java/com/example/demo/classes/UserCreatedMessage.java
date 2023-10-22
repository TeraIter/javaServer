package com.example.demo.classes;

import org.springframework.http.HttpStatusCode;

public record UserCreatedMessage(int code, String message) {
}
