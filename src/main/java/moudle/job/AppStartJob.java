package moudle.job;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.quartz.*;
import utils.ParamsUtils;
import utils.UploadUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static moudle.job.GroovyJob.doIt;

/**
 * 定时任务====quartz启动类
 * Created by lizhen on 2018/4/9 0009.
 */
public class AppStartJob {


    public static void main(String[] args) throws SchedulerException {
        doIt();
        //String result = UploadUtils.uploadFile("D:\\下载说明.txt");
        String result = ParamsUtils.getAreaCode("HK弘康人寿[北京,上海,江苏,河南]");
         result = ParamsUtils.getAreaCode("HK弘康人寿");
        System.out.println(result);
    }
}