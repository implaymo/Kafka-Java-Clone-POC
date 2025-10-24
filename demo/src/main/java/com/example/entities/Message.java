package com.example.entities;

public record Message(String key, String value, long offset, long timestamp) {
}
