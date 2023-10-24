package com.example.demo.json_classes.response;

public record HttpResponse(int code, String message) implements Response{
}
