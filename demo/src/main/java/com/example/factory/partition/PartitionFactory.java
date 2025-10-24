/*
 * Copyright (c) Present Technologies Lda., All Rights Reserved.
 * (www.present-technologies.com)
 *
 * This software is the proprietary information of Present Technologies Lda.
 * Use is subject to license terms.
 */
package com.example.factory.partition;

import com.example.entities.Partition;
import com.example.factory.message.IMessageFactory;

public class PartitionFactory implements IPartitionFactory {

    private final IMessageFactory iMessageFactory;

    public PartitionFactory(IMessageFactory iMessageFactory) {
        this.iMessageFactory = iMessageFactory;
    }

    @Override
    public Partition createPartition(IMessageFactory iMessageFactory) {
        return new Partition(iMessageFactory);
    }
}
