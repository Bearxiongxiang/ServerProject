package com.beacon.imchat.service;

import org.apache.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class SchedulerSingleton {

    private static Logger logger = Logger.getLogger(SchedulerSingleton.class);

    private static Scheduler scheduler;

    /** 任务停止标识 */
    private static boolean shutdown = false;

    private static class LazyHolder {
        private static final SchedulerSingleton INSTANCE = new SchedulerSingleton();
    }

    private SchedulerSingleton(){}

    public static final SchedulerSingleton getInstance() {
        if (scheduler == null) {
            try {
                scheduler = new StdSchedulerFactory().getScheduler();
            } catch (SchedulerException e) {
                logger.error("----- Init Scheduler Fail -----");
                logger.error(e.getMessage());
            }
        }
        return LazyHolder.INSTANCE;
    }

    /**
     * 给 “任务调度器” 绑定 “任务” 与 “触发器”
     * @param job 任务
     * @param trigger 触发器
     */
    public void scheduleJob( JobDetail job, Trigger trigger){
        try {
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            logger.error("----- Scheduler Allocating Task Fail -----");
            logger.error(e.getMessage());
        }
    }

    /** 启动任务调度器 */
    public void start(){
        try {
            if (scheduler != null) {
                scheduler.start();
                logger.info("------- Start Scheduler - YES -------");
            }
        } catch (SchedulerException e) {
            logger.error("----- Start Scheduler - NO -----");
            logger.error(e.getMessage());
        }
    }

    /** 关闭任务调度器 */
    public void shutdown(){
        try {
            setShutdown(true);
            if (scheduler != null) {
                scheduler.shutdown(true);
                logger.info("----- Shutdown Scheduler - YES -----");
            }
        }catch (SchedulerException e) {
            logger.error("----- Shutdown Scheduler - NO -----");
            logger.error(e.getMessage());
        }
    }

    /**
     * 创建任务
     * @param jobClass 任务处理类
     * @param jobName 任务名称
     * @param jobGroup 任务组名
     */
    public JobDetail getJobDetail( Class<? extends Job> jobClass, String jobName, String jobGroup){
        return JobBuilder.newJob( jobClass).withIdentity( jobName, jobGroup).build();
    }

    /**
     * 创建Cron执行触发器
     * @param triggerName 触发器名称
     * @param triggerGroup 触发器组名
     * @param cron 规则
     */
    public Trigger getTrigger( String triggerName, String triggerGroup, String cron){
        return TriggerBuilder.newTrigger().withIdentity( triggerName, triggerGroup)
                .withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();
    }

    /**
     * 创建定时执行触发器
     * @param triggerName 触发器名称
     * @param triggerGroup 触发器组名
     * @param second 秒
     */
    public Trigger getTrigger( String triggerName, String triggerGroup, int second){
        return TriggerBuilder.newTrigger().withIdentity( triggerName, triggerGroup)
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(second).repeatForever()
                ).build();
    }

    public static boolean isShutdown() {
        return shutdown;
    }

    public static void setShutdown(boolean shutdown) {
        SchedulerSingleton.shutdown = shutdown;
    }

}
