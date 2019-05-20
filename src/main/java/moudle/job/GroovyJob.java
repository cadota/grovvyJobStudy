package moudle.job;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import utils.HttpClientUtils;
import utils.UploadUtils;

import java.util.List;

public class GroovyJob implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String id = context.getJobDetail().getKey().getName();
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        String strData = dataMap.getString("params");
        System.out.println(id+strData);


    }
    public static void doIt(){
//业务开始
        //上传
        String result = UploadUtils.uploadFile("G:\\untitled.png");
        JSONObject jsonObject = JSON.parseObject(result);
        JSONArray DATA = jsonObject.getJSONArray("DATA");
        List<String> list = DATA.toJavaObject(List.class);
        System.out.println(list.size());
        //表单
        String word = "{\"app\":\"libsBackManager\",\"methodName\":\"findChildLibs\",\"data\":{\"pageSize\":10,\"currPage\":1,\"userName\":\"BJOO3694\",\"search\":\"\",\"parentLibId\":\"\",\"order\":\"orders\",\"sort\":\"asc\"}}";
        System.out.println(HttpClientUtils.httpPostWithJson(word));

    }

}