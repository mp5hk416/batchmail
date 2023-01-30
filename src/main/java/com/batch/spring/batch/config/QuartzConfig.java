package com.batch.spring.batch.config;

//import org.quartz.JobBuilder;
//import org.quartz.JobDetail;
import com.batch.spring.batch.QuartzJob.TimerJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 俊翔，學習加油，今天是 2022/11/11 下午 03:42
 * 時間: 15 42
 * 好好努力~桿八爹
 */
@Configuration
public class QuartzConfig {


    Scheduler scheduler;

    {
        try {
            scheduler = new StdSchedulerFactory().getScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Bean
    public JobDetail mailJobDetail(){
        System.out.println("方法定時運行");
        return JobBuilder.newJob(TimerJob.class)
                .withIdentity("TimerJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger mailJobTrigger(){
        System.out.println("方法定時器開始運作");
        //0秒0分後每5分處發一次
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0 0/5 * * * ?");
        return TriggerBuilder.newTrigger()
                .forJob(mailJobDetail())
                .withIdentity("mailJobTrigger")
                .withSchedule(cronScheduleBuilder)
                .build();

    }

}
