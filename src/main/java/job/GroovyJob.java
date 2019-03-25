package job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class GroovyJob implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String id = context.getJobDetail().getKey().getName();
        System.out.println("quartz MyJob date:" + new Date().getTime()+id);
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        String strData = dataMap.getString("xxxxxxxxxxxxxxx");
        System.out.println(strData);
    }
}