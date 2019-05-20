package moudle.job;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import utils.HttpClientUtils;
import utils.ParamsUtils;
import utils.UploadUtils;

import java.io.File;
import java.util.List;

public class GroovyJob implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String id = context.getJobDetail().getKey().getName();
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        String strData = dataMap.getString("params");
        System.out.println(id+strData);


    }
    public static void doIt(){
        getFile("G:\\cehi","","1");
    }

    public static void getFile(String pathname,String parentId,String level) {
        //先将指定路径下的所有文件实例化
        File file = new File(pathname);
        //判断实例化的对象file是否存在，即指定路径是否存在
        if (!file.exists()) {
            //若file不存在，则抛出异常
            throw new IllegalArgumentException("目录" + pathname + "不存在");
        }
        //若文件存在，则将所有文件的实例化对象转化为数组形式
        File[] files = file.listFiles();
        //遍历文件数组
        for (File file2 : files) {
            System.out.println(file2.getPath());
            if (file2.isDirectory()) {
                //调用创建文件夹接口
                String param = ParamsUtils.getFolderParams(file2.getName(),parentId,level);
                String result = HttpClientUtils.httpPostWithJson(param);
                JSONObject jsonObject = JSON.parseObject(result);
                JSONObject data = jsonObject.getJSONObject("data");
                //调用自己时候传入的参数为上一句判断出来的文件夹路径
                JSONObject o = JSON.parseObject(data.toString());
                Boolean flag = o.getBoolean("FLAG");
                if(flag){
                    long DATA = o.getLong("DATA");
                    String tempParentId = String.valueOf(DATA);
                    if(tempParentId!=null&&!tempParentId.equals("")){
                        getFile(file2.getAbsolutePath(),tempParentId,level+1);
                    }else {
                        System.out.println("服务端创建失败："+tempParentId);
                        System.exit(1);
                    }
                    System.out.println("创建文件夹："+tempParentId);
                }else {
                    System.out.println("创建文件夹失败");
                    System.exit(1);
                }

            }else {
                //调用创建文件接口
                //上传
                try {
                String result = UploadUtils.uploadFile(file2.getPath());
                JSONObject jsonObject = JSON.parseObject(result);
                JSONArray DATA = jsonObject.getJSONArray("DATA");
                List<String> list = DATA.toJavaObject(List.class);
                if(list!=null&&list.size()==1){
                    String param = ParamsUtils.getFileParams(file2.getName(),list.get(0),parentId);
                    String result1 = HttpClientUtils.httpPostWithJson(param);
                    System.out.println("创建文件："+result1);
                }
                }catch (Exception e){
                    System.out.println(file2.getPath()+e.getMessage());
                }
            }

        }
    }


}