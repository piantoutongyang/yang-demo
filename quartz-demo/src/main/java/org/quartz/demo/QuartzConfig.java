package org.quartz.demo;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail uploadTaskDetail() {
        return JobBuilder.newJob(UploadTask.class).withIdentity("uploadTask").storeDurably().build();
    }

    @Bean
    public Trigger uploadTaskTrigger() {
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/5 * * * * ?");
        return TriggerBuilder.newTrigger().forJob(uploadTaskDetail())
                .withIdentity("uploadTask")
                .withSchedule(scheduleBuilder)
                .build();
    }
    
    @Bean
    public JobDetail infoTaskDetail() {
        return JobBuilder.newJob(InfoTask.class).withIdentity("infoTask").storeDurably().build();
    }

    @Bean
    public Trigger infoTaskTrigger() {
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/5 * * * * ?");
        return TriggerBuilder.newTrigger().forJob(infoTaskDetail())
                .withIdentity("infoTask")
                .withSchedule(scheduleBuilder)
                .build();
    }
}
