package com.example.broker;

import java.util.concurrent.atomic.AtomicLong;
import java.util.ArrayList;
import java.util.List;

public class Partition {

    private final int partitionId;
    private final List<Message> messages;
    AtomicLong currentOffset;
    private final MessageFactory messageFactory;

    public Partition(int partitionId, MessageFactory messageFactory) {
        this.partitionId = partitionId;
        this.messages = new ArrayList<>();
        this.messageFactory = messageFactory;
        this.currentOffset = new AtomicLong(0);
    }

    public synchronized long append(String key, String value) {
        long offset = currentOffset.getAndIncrement();
        messages.add(messageFactory.createMessage(key, value, offset));
        return offset;
    }

    public List<Message> read(AtomicLong offset) {
        List<Message> messagesToRead = new ArrayList<>();
        if (offset.get() >= messages.size()) {
            return messagesToRead;
        }

        int startIndex = (int) offset.get() + 1;
        int endIndex = (int) currentOffset.get() - 1;

        for (int i = startIndex; i <= endIndex; i++) {
            messagesToRead.add(messages.get(i));
        }

        return messagesToRead;
    }
}
