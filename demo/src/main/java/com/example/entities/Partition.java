package com.example.entities;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import java.util.ArrayList;
import java.util.List;

import com.example.factory.message.IMessageFactory;

public class Partition {

    private final UUID partitionId;
    private final List<Message> messages;
    AtomicLong currentOffset;
    private final IMessageFactory iMessageFactory;

    public Partition(IMessageFactory messageFactory) {
        this.partitionId = UUID.randomUUID();
        this.messages = new ArrayList<>();
        this.iMessageFactory = messageFactory;
        this.currentOffset = new AtomicLong(0);
    }

    public UUID getPartitionId() {
        return partitionId;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public AtomicLong getCurrentOffset() {
        return currentOffset;
    }

    public IMessageFactory getiMessageFactory() {
        return iMessageFactory;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Partition partition = (Partition) obj;
        return partitionId.equals(partition.partitionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partitionId);
    }
}
