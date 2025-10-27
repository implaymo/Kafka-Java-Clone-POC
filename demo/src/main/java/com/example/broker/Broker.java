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
import com.example.entities.Topic;
import com.example.service.TopicService;

public class Broker {

    private final TopicService topicService;
    private Map<String, Topic> topics;

    public Broker(TopicService topicService) {
        this.topicService = topicService;
        this.topics = new HashMap<>();
    }

    public boolean createTopic(String name, int totalPartitions) {
        Topic topic = topicService.createTopic(name, totalPartitions);
        topics.put(name, topic);
        return true;
    }
}
