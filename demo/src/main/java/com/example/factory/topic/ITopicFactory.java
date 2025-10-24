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

public interface ITopicFactory {

    Topic createTopic(String name, int totalPartitions, Map<UUID, Partition> partitions);

}
