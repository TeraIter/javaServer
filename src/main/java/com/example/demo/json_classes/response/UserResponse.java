package com.example.demo.json_classes.response;

public record UserResponse(String name, String surname, String email, String password) implements Response {
}
