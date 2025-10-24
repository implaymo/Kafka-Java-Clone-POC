/*
 * Copyright (c) Present Technologies Lda., All Rights Reserved.
 * (www.present-technologies.com)
 *
 * This software is the proprietary information of Present Technologies Lda.
 * Use is subject to license terms.
 */
package com.example.broker;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.example.entities.Partition;
import com.example.service.PartitionService;
import com.example.entities.Topic;
import com.example.service.TopicService;

public class Broker {

    private final PartitionService partitionService;
    private final TopicService topicService;
    private Map<String, Topic> topics;

    public Broker(PartitionService partitionService, TopicService topicService) {
        this.partitionService = partitionService;
        this.topicService = topicService;
        this.topics = new HashMap<>();
    }

    public Topic createTopic(String name, int totalPartitions) {
        Map<UUID, Partition> partitions = new HashMap<>();
        for (int i = 0; i < totalPartitions; i++) {
            Partition partition = partitionService.createPartition();
            partitions.put(partition.getPartitionId(), partition);
        }
        return topicService.createTopic(name, totalPartitions, partitions);
    }
}
