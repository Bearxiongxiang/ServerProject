package com.beacon.imchat.listener;


import com.beacon.imchat.job.TestJob;
import com.beacon.imchat.service.SchedulerSingleton;
import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Tina on 9/19/2017.
 */
public class LoaderListener implements ServletContextListener {
    Logger logger = Logger.getLogger(this.getClass());

    /**
     * 设置任务调度器
     */
    private void setScheduler() {
        SchedulerSingleton singleton = SchedulerSingleton.getInstance();
        singleton.start();

        //0 0 8 ? * SUN *
        singleton.scheduleJob(singleton.getJobDetail(TestJob.class, "TestJob", "TestGroup"),
                singleton.getTrigger("TestJob", "TestGroup", 2 ));
    }


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        setScheduler();
        logger.info("start listener");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("end listener");
    }
}
