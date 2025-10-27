/*
 * Copyright (c) Present Technologies Lda., All Rights Reserved.
 * (www.present-technologies.com)
 *
 * This software is the proprietary information of Present Technologies Lda.
 * Use is subject to license terms.
 */
package com.example.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.example.entities.Partition;
import com.example.entities.Topic;
import com.example.factory.topic.ITopicFactory;

public class TopicService {

    private final ITopicFactory iTopicFactory;
    private final PartitionService partitionService;


    public TopicService(ITopicFactory iTopicFactory, PartitionService partitionService) {
        this.iTopicFactory = iTopicFactory;
        this.partitionService = partitionService;
    }

    public Topic createTopic(String name, int totalPartitions) {
        Map<UUID, Partition> partitions = new HashMap<>();
        for (int i = 0; i < totalPartitions; i++) {
            Partition partition = partitionService.createPartition();
            partitions.put(partition.getPartitionId(), partition);
        }
        return iTopicFactory.createTopic(name, totalPartitions, partitions);
    }

}
