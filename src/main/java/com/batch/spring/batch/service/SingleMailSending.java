package com.batch.spring.batch.service;

import com.batch.spring.batch.Pojo.MailInfoDTO;
import org.springframework.stereotype.Service;

public interface SingleMailSending {

    void SingleMailSend(MailInfoDTO mailInfoDTO);
}
