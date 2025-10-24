package com.example.factory.message;

import com.example.entities.Message;

public class MessageFactory implements IMessageFactory {
    public Message createMessage(String key, String value, long offset) {
        return new Message(key, value, offset, System.currentTimeMillis());
    }
}
