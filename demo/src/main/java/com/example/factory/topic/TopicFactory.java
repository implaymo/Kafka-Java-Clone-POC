/*
 * Copyright (c) Present Technologies Lda., All Rights Reserved.
 * (www.present-technologies.com)
 *
 * This software is the proprietary information of Present Technologies Lda.
 * Use is subject to license terms.
 */
package com.example.factory.topic;

import java.util.Map;
import java.util.UUID;

import com.example.entities.Partition;
import com.example.entities.Topic;

public class TopicFactory implements ITopicFactory {

    @Override
    public Topic createTopic(String name, int totalPartitions, Map<UUID, Partition> partitions) {
        return new Topic(name, totalPartitions, partitions);
    }

}
