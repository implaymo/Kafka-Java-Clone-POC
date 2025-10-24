package com.example.message;

public record Message(String key, String value, long offset, long timestamp) {
}
