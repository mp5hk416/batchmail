package com.batch.spring.batch.QuartzJob;

import com.batch.spring.batch.Repository.MailRepository;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Random;

/**
 * 俊翔，學習加油，今天是 2022/11/11 下午 04:39
 * 時間: 16 39
 * 好好努力~桿八爹
 */
@Slf4j
public class TimerJob implements Job{


    @Autowired
    MailRepository mailRepository;

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    @Qualifier("generateJob")
    org.springframework.batch.core.Job batchJob;



    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

    	Integer s = 0;

        System.out.println("啟用定時工作");

        Long total = mailRepository.countByStatus(s);
        if (total<0){
            log.info("無相關信件需寄出");
        }

        Random random = new Random();
        int randomNum = random.nextInt();

        JobParameter jobParameter = new JobParameter(String.valueOf(randomNum));
        JobParameters jobParameters = new JobParametersBuilder().addParameter("unique",jobParameter).toJobParameters();


        try {
            jobLauncher.run(batchJob,jobParameters);
        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException | JobParametersInvalidException e) {
            e.printStackTrace();
        }


    }
}
