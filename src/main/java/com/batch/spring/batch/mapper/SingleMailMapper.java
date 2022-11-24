package com.batch.spring.batch.mapper;

import com.batch.spring.batch.Pojo.MailIInfoEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SingleMailMapper {
    List<MailIInfoEntity> getMailList();
}
