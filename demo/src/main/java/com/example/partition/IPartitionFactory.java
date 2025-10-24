/*
 * Copyright (c) Present Technologies Lda., All Rights Reserved.
 * (www.present-technologies.com)
 *
 * This software is the proprietary information of Present Technologies Lda.
 * Use is subject to license terms.
 */
package com.example.partition;

import com.example.message.IMessageFactory;

public interface IPartitionFactory {
    Partition createPartition(IMessageFactory iMessageFactory);
}
