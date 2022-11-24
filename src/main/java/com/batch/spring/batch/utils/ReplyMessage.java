package com.batch.spring.batch.utils;

import lombok.Data;

/**
 * 俊翔，學習加油，今天是 2022/11/10 下午 05:47
 * 時間: 17 47
 * 好好努力~桿八爹
 */

@Data
public class ReplyMessage {

    private String message;

    public ReplyMessage(String message) {
        this.message = message;
    }
}
