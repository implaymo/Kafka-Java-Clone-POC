/*
 * Copyright (c) Present Technologies Lda., All Rights Reserved.
 * (www.present-technologies.com)
 *
 * This software is the proprietary information of Present Technologies Lda.
 * Use is subject to license terms.
 */
package com.example.service;

import java.util.Map;
import java.util.UUID;

import com.example.entities.Partition;
import com.example.entities.Topic;
import com.example.factory.topic.ITopicFactory;

public class TopicService {

    private ITopicFactory iTopicFactory;

    public TopicService(ITopicFactory iTopicFactory) {
        this.iTopicFactory = iTopicFactory;
    }

    public Topic createTopic(String name, int totalPartitions, Map<UUID, Partition> partitions) {
        return iTopicFactory.createTopic(name, totalPartitions, partitions);
    }

}
