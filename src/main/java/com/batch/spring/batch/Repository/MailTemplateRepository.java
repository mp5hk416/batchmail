package com.batch.spring.batch.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.batch.spring.batch.Pojo.MailtemplateEntity;

public interface MailTemplateRepository extends JpaRepository<MailtemplateEntity, Long> {
    
}