package com.example;

import com.example.Broker.Message;

public class MessageFactory {
    public Message createMessage(String key, String value, long offset) {
        return new Message(key, value, offset, System.currentTimeMillis());
    }
}
