/*
 * Copyright (c) Present Technologies Lda., All Rights Reserved.
 * (www.present-technologies.com)
 *
 * This software is the proprietary information of Present Technologies Lda.
 * Use is subject to license terms.
 */
package com.example.topic;

public class TopicFactory implements ITopicFactory {

    @Override
    public Topic createTopic(String name, int totalPartitions) {
        return new Topic(name, totalPartitions);
    }

}
