package com.example.message;

public class MessageFactory implements IMessageFactory {
    public Message createMessage(String key, String value, long offset) {
        return new Message(key, value, offset, System.currentTimeMillis());
    }
}
