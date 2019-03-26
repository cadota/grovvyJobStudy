package moudle.job;

import org.quartz.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 定时任务====quartz启动类
 * Created by lizhen on 2018/4/9 0009.
 */
public class AppStartJob {


    public static void main(String[] args) throws SchedulerException {
        JobUtil.createJob("test","test","0/2 * * * * ?");
        Map<String ,String> map = new HashMap<String, String>();
        map.put("xxxxxxxxxxxxxxx","asdqdafasf");
        JobUtil.createJob("test1","test·","0/2 * * * * ?",map);
    }
}