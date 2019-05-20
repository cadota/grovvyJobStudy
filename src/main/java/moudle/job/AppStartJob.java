package moudle.job;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.quartz.*;
import utils.UploadUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 定时任务====quartz启动类
 * Created by lizhen on 2018/4/9 0009.
 */
public class AppStartJob {


    public static void main(String[] args) throws SchedulerException {
       /* JobUtil.createJob("test","test","0/2 * * * * ?");
        Map<String ,String> map = new HashMap<String, String>();
        map.put("params","test!");
        JobUtil.createJob("test1","test·","0/2 * * * * ?",map);*/

       GroovyJob.doIt();
    }
}