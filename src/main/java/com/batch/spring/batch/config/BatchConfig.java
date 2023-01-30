package com.batch.spring.batch.config;

import com.batch.spring.batch.Pojo.MailIInfoEntity;
import com.batch.spring.batch.mapper.MailInfoEntityMapper;
import com.batch.spring.batch.processor.MailProcessor;
import com.batch.spring.batch.writer.MailWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Random;

/**
 * 俊翔，學習加油，今天是 2022/11/10 上午 10:46
 * 時間: 10 46
 * 好好努力~桿八爹
 */
@Configuration
@Slf4j
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    DataSource dataSource;

    private final String JOB_NAME = "senderJob";
    private final String STEP_NAME = "senderStep";

    Random random = new Random();
    int randomNum = random.nextInt();

    @Bean(name="generateJob")
    public Job senderJob(){
        return this.jobBuilderFactory.get(JOB_NAME+randomNum)
                .start(senderStep())
                .build();
    }

    @Bean
    public Step senderStep() {
        return this.stepBuilderFactory.get(STEP_NAME)
                .<MailIInfoEntity, MailIInfoEntity>chunk(100)
                .reader(mailReader())
                .processor(mailProcessor())
                .writer(mailWriter())
                .build();
    }

    @Bean
    public MailWriter mailWriter() {
        return new MailWriter();
    }

    @Bean
    public ItemProcessor<MailIInfoEntity, MailIInfoEntity> mailProcessor() {
        return new MailProcessor();
    }

    @Bean
    public ItemReader<MailIInfoEntity> mailReader() {
        String sql = "SELECT * FROM mail_sys WHERE state = 1 AND email_sent = 0";
        return new JdbcCursorItemReaderBuilder<MailIInfoEntity>()
                .name("mailReader")
                .sql(sql)
                .dataSource(dataSource)
                .rowMapper(new MailInfoEntityMapper())
                .build();
    }
}
