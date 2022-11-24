package com.batch.spring.batch.writer;


import com.batch.spring.batch.Pojo.MailIInfoEntity;
import com.batch.spring.batch.Repository.MailRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 俊翔，學習加油，今天是 2022/11/10 下午 02:59
 * 時間: 14 59
 * 好好努力~桿八爹
 */
@Slf4j
public class MailWriter implements ItemWriter<MailIInfoEntity> {

    @Autowired
    MailRepository mailRepository;

    @Override
    public void write(List<? extends MailIInfoEntity> list) throws Exception {

        mailRepository.saveAllAndFlush(list);
    }
}
