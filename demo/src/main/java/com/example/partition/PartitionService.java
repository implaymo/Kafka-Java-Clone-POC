/*
 * Copyright (c) Present Technologies Lda., All Rights Reserved.
 * (www.present-technologies.com)
 *
 * This software is the proprietary information of Present Technologies Lda.
 * Use is subject to license terms.
 */
package com.example.partition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.example.message.IMessageFactory;
import com.example.message.Message;

public class PartitionService {

    private IMessageFactory iMessageFactory;

    public PartitionService(IMessageFactory iMessageFactory) {
        this.iMessageFactory = iMessageFactory;
    }

    public synchronized long appendMessages(String key, String value, List<Message> messages, AtomicLong currentOffset) {
        long offset = currentOffset.getAndIncrement();
        messages.add(iMessageFactory.createMessage(key, value, offset));
        return offset;
    }

    public List<Message> readMessages(Partition partition, AtomicLong offset) {
        List<Message> messagesToRead = new ArrayList<>();
        if (partition.getCurrentOffset().get() >= partition.getMessages().size()) {
            return messagesToRead;
        }

        int startIndex = (int) offset.get() + 1;
        int endIndex = (int) partition.getCurrentOffset().get() - 1;

        for (int i = startIndex; i <= endIndex; i++) {
            messagesToRead.add(partition.getMessages().get(i));
        }

        return messagesToRead;
    }
}
