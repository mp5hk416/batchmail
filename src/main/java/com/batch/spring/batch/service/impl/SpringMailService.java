package com.batch.spring.batch.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 俊翔，學習加油，今天是 2022/11/10 下午 01:05
 * 時間: 13 05
 * 好好努力~桿八爹
 */
//寄件方法
@Service
@Slf4j
public class SpringMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendSimpleMessage(String from, String to, String subject, String text) throws MessagingException {

//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(from);
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(text);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        mimeMessage.setFrom(from);
        mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
        mimeMessage.setSubject(subject);
        mimeMessage.setContent(text,"text/html;charset=utf-8");

        javaMailSender.send(mimeMessage);
    }
}
