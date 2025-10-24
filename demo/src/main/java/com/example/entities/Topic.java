/*
 * Copyright (c) Present Technologies Lda., All Rights Reserved.
 * (www.present-technologies.com)
 *
 * This software is the proprietary information of Present Technologies Lda.
 * Use is subject to license terms.
 */
package com.example.entities;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class Topic {

    private final String name;
    private final int totalPartitions;
    private final Map<UUID, Partition> partitions;

    public Topic(String name, int totalPartitions, Map<UUID, Partition> partitions) {
        this.name = name;
        this.totalPartitions = totalPartitions;
        this.partitions = partitions;
    }

    public String getName() {
        return name;
    }

    public int getTotalPartitions() {
        return totalPartitions;
    }

    public Map<UUID, Partition> getPartitions() {
        return partitions;
    }

    public void addPartition(Partition partition) {
        partitions.put(partition.getPartitionId(), partition);
    }

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
