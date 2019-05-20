package utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @auther:panzhen
 * @Des
 * @Date:Create in 2019/5/17
 * @Modified By:
 */
public class HttpClientUtils {

    public static String httpPostWithJson(String word) {
        String url = "http://test.mingya.com.cn/SERVER/service.html?SERVERID=ZCMS-110006&APP_ID=10006";
        String isSuccess = "";

        HttpPost post = null;
        try {
            HttpClient httpClient = new DefaultHttpClient();

            // 设置超时时间
            httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 2000);
            httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 2000);

            post = new HttpPost(url);
            // 构造消息头
            post.setHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
            post.setHeader("Connection", "Close");
            // 构建消息实体
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("JSON", word));
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params, "utf-8");
            formEntity.setContentType("Content-Type:application/x-www-form-urlencoded");

            // 发送Json格式的数据请求
            post.setEntity(formEntity);

            HttpResponse response = httpClient.execute(post);

            // 检验返回码
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
            } else {
                // 返回码中包含retCode及会话Id
                StringBuffer stringBuffer = new StringBuffer();
                InputStream inputStream = response.getEntity().getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null){
                    stringBuffer.append(line);
                }
                isSuccess = stringBuffer.toString();
                return isSuccess;
            }
        } catch (Exception e) {
            e.printStackTrace();
          return "";
        } finally {
            if (post != null) {
                try {
                    post.releaseConnection();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return isSuccess;
    }
}
