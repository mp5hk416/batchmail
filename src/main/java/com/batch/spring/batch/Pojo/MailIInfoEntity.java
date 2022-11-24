package com.batch.spring.batch.Pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * 俊翔，學習加油，今天是 2022/11/10 上午 11:43
 * 時間: 11 43
 * 好好努力~桿八爹
 */
@Data
@Builder
@Entity(name = "mail_sys")
@NoArgsConstructor
@AllArgsConstructor
public class MailIInfoEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    private String senderAddress;
    private String recipientAddress;
    private String subject;
    private String content;
    private Short state;
    private Integer emailSent;
    private Timestamp sendingDate;

}
