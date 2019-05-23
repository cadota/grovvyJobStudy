package utils;

import moudle.job.AutoCreatLibsJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("Duplicates")
public class JobUtil {
    public static SchedulerFactory sf = new StdSchedulerFactory();
    public static Scheduler scheduler;

    static {
        try {
            scheduler = sf.getScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
    public static void createJob(String jobName,String triggerName,String runTime) throws SchedulerException {
        JobDetail jb = JobBuilder.newJob(AutoCreatLibsJob.class)
                .withDescription("自动化上传任务") //job的描述
                .withIdentity(jobName, "ramGroup") //moudle.job 的name和group
                .build();
        long time = System.currentTimeMillis() + 3 * 1000L; //3秒后启动任务
        Date statTime = new Date(time);

        //4.创建Trigger
        //使用SimpleScheduleBuilder或者CronScheduleBuilder
        Trigger t = TriggerBuilder.newTrigger()
                .withDescription("")
                .withIdentity(triggerName, "ramTriggerGroup")
                //.withSchedule(SimpleScheduleBuilder.simpleSchedule())
                .startAt(statTime)  //默认当前时间启动，下面的用到了Quartz表达式：http://cron.qqe2.com/
                .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")) //两秒执行一次
                .build();
        //5.注册任务和定时器
        scheduler.scheduleJob(jb, t);
        //6.启动 调度器
        scheduler.start();
    }

    /**
     *
     * @param jobName 任务名称（唯一）
     * @param triggerName 触发器名称（唯一）
     * @param runTime 执行时间，参考quartz写法
     * @param map 传递给任务类的参数
     * @throws SchedulerException
     */
    public static void createJob(String jobName, String triggerName, String runTime,Map<String,String> map) throws SchedulerException {
        JobDetail jb = JobBuilder.newJob(AutoCreatLibsJob.class)
                .withDescription("自动化上传任务") //job的描述
                .withIdentity(jobName, "ramGroup") //moudle.job 的name和group
                .build();
        long time = System.currentTimeMillis() + 3 * 1000L; //3秒后启动任务
        Date statTime = new Date(time);
        Set<String> keySet = map.keySet();
        if(keySet!=null)
        for(String key:keySet){
            jb.getJobDataMap().put(key, map.get(key));
        }
        //4.创建Trigger
        //使用SimpleScheduleBuilder或者CronScheduleBuilder
        Trigger t = TriggerBuilder.newTrigger()
                .withDescription("")
                .withIdentity(triggerName, "ramTriggerGroup")
                //.withSchedule(SimpleScheduleBuilder.simpleSchedule())
                .startAt(statTime)  //默认当前时间启动，下面的用到了Quartz表达式：http://cron.qqe2.com/
                .withSchedule(CronScheduleBuilder.cronSchedule(runTime)) //两秒执行一次
                .build();
        //5.注册任务和定时器
        scheduler.scheduleJob(jb, t);
        //6.启动 调度器
        scheduler.start();
    }
}
