package job;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import util.JobUtil;

public class GroovyJob implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String id = context.getJobDetail().getKey().getName();
        Binding binding = new Binding();
        binding.setVariable("x", 10);
        binding.setVariable("language", id);
        GroovyShell shell = new GroovyShell(binding);
        Object value = shell.evaluate("println \"Welcome to $language\"; y = x * 2; z = x * 3; return x ");
        shell.evaluate(JobUtil.runContext);
        System.err.println(value +", " + value.equals(10));
        System.err.println(binding.getVariable("y") +", " + binding.getVariable("y").equals(20));
        System.err.println(binding.getVariable("z") +", " + binding.getVariable("z").equals(30));
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        String strData = dataMap.getString("xxxxxxxxxxxxxxx");
        System.out.println(strData);
    }
}