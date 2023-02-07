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
 * 俊翔，學習加油，今天是 2023/01/30 下午 17:45
 * 時間: 17 45
 * 好好努力~桿八爹
 */
@Data
@Builder
@Entity(name = "mail_template")
@NoArgsConstructor
@AllArgsConstructor
public class MailtemplateEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    private String title;
    private String content;

}
