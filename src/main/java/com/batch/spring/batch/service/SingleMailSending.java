package com.batch.spring.batch.service;

import com.batch.spring.batch.Pojo.MailTemplateDTO;

public interface SingleMailSending {

    void SingleMailSend(MailTemplateDTO mailTemplateDTO);
}
