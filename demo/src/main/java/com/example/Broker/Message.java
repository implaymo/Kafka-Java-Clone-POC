package com.example.Broker;

public record Message(String key, String value, long offset, long timestamp) {
    
}
