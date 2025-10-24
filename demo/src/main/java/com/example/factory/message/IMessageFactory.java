/*
 * Copyright (c) Present Technologies Lda., All Rights Reserved.
 * (www.present-technologies.com)
 *
 * This software is the proprietary information of Present Technologies Lda.
 * Use is subject to license terms.
 */
package com.example.factory.message;

import com.example.entities.Message;

public interface IMessageFactory {
    Message createMessage(String key, String value, long offset);
}
