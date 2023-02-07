package com.batch.spring.batch.service;

import com.batch.spring.batch.Pojo.MailTemplateDTO;

public interface MailTemplateService {

	MailTemplateDTO findById(Long id);
}
