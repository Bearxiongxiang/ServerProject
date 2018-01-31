package com.beacon.imchat.job;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TestJob implements Job {
    Logger logger = Logger.getLogger(TestJob.class);
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        logger.info("test task");
    }
}
