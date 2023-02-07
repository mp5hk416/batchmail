package com.batch.spring.batch.processor;


import java.util.Objects;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;

import com.batch.spring.batch.Pojo.MailIInfoEntity;
import com.batch.spring.batch.Pojo.MailTemplateDTO;
import com.batch.spring.batch.service.MailTemplateService;
import com.batch.spring.batch.service.impl.SpringMailService;

import lombok.extern.slf4j.Slf4j;

/**
 * 俊翔，學習加油，今天是 2022/11/10 下午 12:57
 * 時間: 12 57
 * 好好努力~桿八爹
 */

@Slf4j
public class MailProcessor implements ItemProcessor<MailIInfoEntity, MailIInfoEntity> {

    @Autowired
    SpringMailService springMailService;
	@Autowired
	private MailTemplateService mailTemplateService;
	
    @Override
    public MailIInfoEntity process(MailIInfoEntity mailIInfoEntity){
        log.info("needProcessor需要處裡的資料:{}", mailIInfoEntity);

        try {
            long start = System.currentTimeMillis();
            log.info("開始時間:{}",start);
            MailTemplateDTO data = mailTemplateService.findById((long) 1);//固定只會有一筆
            springMailService.sendSimpleMessage(mailIInfoEntity.getEmailAddress(), mailIInfoEntity.getEmailAddress(), data.getTitle(), data.getContent());
            mailIInfoEntity.setStatus(1);
            long end = System.currentTimeMillis();
            log.info("結束時間:{}",end);
            log.info("耗時:{}毫秒",end-start);
        } catch (Exception e){
            log.info("信件異常，觸發回報機制");
            SimpleMailMessage message = new SimpleMailMessage();//出錯改用簡單信件
            message.setFrom(mailIInfoEntity.getEmailAddress());
            message.setTo("a0987183369@gmail.com");
            message.setSubject("信件寄出異常回報");
            message.setText(mailIInfoEntity.toString());
            try {
                springMailService.sendSimpleMessage(message.getFrom(), Objects.requireNonNull(message.getTo())[0],message.getSubject(),message.getText());
            } catch (Exception e1) {
                log.info("服務器內部錯誤:{}",e1.getMessage());
            }
        }

        return mailIInfoEntity;
    }
}
