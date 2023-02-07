package com.batch.spring.batch.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batch.spring.batch.Pojo.MailTemplateDTO;
import com.batch.spring.batch.Pojo.MailtemplateEntity;
import com.batch.spring.batch.Repository.MailTemplateRepository;
import com.batch.spring.batch.service.MailTemplateService;


@Service
public class MailTemplateImpl implements MailTemplateService{

	@Autowired
	private MailTemplateRepository mailTemplateRepository;
	
	/**
	 * 取得MAIL用template資料
	 */
	public MailTemplateDTO findById(Long id) {
		MailTemplateDTO mailTemplateDTO = new MailTemplateDTO();
		MailtemplateEntity data = mailTemplateRepository.findById(id).orElse(new MailtemplateEntity());
		mailTemplateDTO.setTitle(data.getTitle());
		mailTemplateDTO.setContent(data.getContent());
		
		return mailTemplateDTO;
	}
}
