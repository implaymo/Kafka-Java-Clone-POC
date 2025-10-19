package com.example;

import java.util.concurrent.atomic.AtomicLong;
import java.util.ArrayList;
import java.util.List;

import com.example.Broker.Message;

public class Partition {
    private final int partitionId;
    private final List<Message> messages;
    AtomicLong currentOffset;
    private final MessageFactory messageFactory;

    public Partition(int partitionId, MessageFactory messageFactory) {
        this.partitionId = partitionId;
        this.messages = new ArrayList<>();
        this.messageFactory = messageFactory;
    }

    public synchronized long append(String key, String value) {
        long offset = currentOffset.getAndIncrement();
        messages.add(messageFactory.createMessage(key, value, offset));
        return offset;
    }

    
}
