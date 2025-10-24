/*
 * Copyright (c) Present Technologies Lda., All Rights Reserved.
 * (www.present-technologies.com)
 *
 * This software is the proprietary information of Present Technologies Lda.
 * Use is subject to license terms.
 */
package com.example.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.example.partition.Partition;

public class Topic {

    private final String name;
    private final int totalPartitions;
    private final List<Partition> partitions;

    public Topic(String name, int totalPartitions) {
        this.name = name;
        this.totalPartitions = totalPartitions;
        this.partitions = new ArrayList<>();
    }

    public String getName() { return name; }
    public int getTotalPartitions() { return totalPartitions; }
    public List<Partition> getPartitions() { return partitions; }
    public void addPartition(Partition partition) { partitions.add(partition); }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Topic topic = (Topic) obj;
        return totalPartitions == topic.totalPartitions &&
                Objects.equals(name, topic.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, totalPartitions);
    }
}
