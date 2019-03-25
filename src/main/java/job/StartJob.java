package job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import util.Util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 定时任务====quartz启动类
 * Created by lizhen on 2018/4/9 0009.
 */
public class StartJob {


    public static void main(String[] args) throws SchedulerException {
        Util.createJob("test","test","0/2 * * * * ?");
        Map<String ,String> map = new HashMap<String, String>();
        map.put("xxxxxxxxxxxxxxx","asdqdafasf");
        Util.createJob("test1","test","0/2 * * * * ?",map);
    }
}