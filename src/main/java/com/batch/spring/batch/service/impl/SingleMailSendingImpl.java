package com.batch.spring.batch.service.impl;

import com.batch.spring.batch.Pojo.MailIInfoEntity;
import com.batch.spring.batch.Pojo.MailInfoDTO;
import com.batch.spring.batch.mapper.SingleMailMapper;
import com.batch.spring.batch.service.SingleMailSending;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;

/**
 * 俊翔，學習加油，今天是 2022/11/15 下午 01:35
 * 時間: 13 35
 * 好好努力~桿八爹
 */
@Slf4j
@Service
public class SingleMailSendingImpl implements SingleMailSending {

    @Autowired
    private SingleMailMapper singleMailMapper;

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String senderAddress;

    @Override
    public void SingleMailSend(MailInfoDTO mailInfoDTO) {

        List<MailIInfoEntity> mailList = singleMailMapper.getMailList();
        log.info("獲取資訊:{}",mailList);
        List<String> recipients = new ArrayList<>();
        for (MailIInfoEntity mailIInfoEntity : mailList) {
            String recipientAddress = mailIInfoEntity.getRecipientAddress();
            log.info("獲取寄件地址:{}",recipientAddress);
            recipients.add(recipientAddress);

        }
        String[] recipientArrays = recipients.toArray(new String[recipients.size()]);
        log.info("string打樁:{}",recipientArrays);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(senderAddress);
        message.setTo(recipientArrays);
        message.setSubject(mailInfoDTO.getSubject());
        message.setText(mailInfoDTO.getContent());
        log.info("信件打樁:{}",message);
        javaMailSender.send(message);


    }
}
