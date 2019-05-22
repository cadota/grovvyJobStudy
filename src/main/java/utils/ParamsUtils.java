package utils;

import org.apache.commons.lang.StringUtils;

/**
 * @auther:panzhen
 * @Des
 * @Date:Create in 2019/5/20
 * @Modified By:
 */
public class ParamsUtils {
    //获取创建文件参数
    public static String getFileParams(String fileName,String fileId,String parentId,String area){
        String baseModel = "{\n" +
                "\t\"app\": \"rwLibService\",\n" +
                "\t\"methodName\": \"createLibs\",\n" +
                "\t\"data\": {\n" +
                "\t\t\"agent_code\": \"BJOO3702\",\n" +
                "\t\t\"createUser\": \"BJOO3702\",\n" +
                "\t\t\"createUserName\": \"BJOO3702\",\n" +
                "\t\t\"operateType\": \"rw\",\n" +
                "\t\t\"extension\": \"json\",\n" +
                "\t\t\"fileId\": \"1e5b2adf88554dcc90ac4963a879841b\",\n" +
                "\t\t\"libsName\": \".v8flags.6.8.275.32-node.51.2ad0123a6dc2bb7d85f7d84bcade18ce.json\",\n" +
                "\t\t\"fileSize\": 4397,\n" +
                "\t\t\"type\": \"file\",\n" +
                "\t\t\"ispublish\": true,\n" +
                "\t\t\"level\": 2,\n" +
                "\t\t\"parentId\": \"159721679721140224\",\n" +
                "\t\t\"isLimitShare\": false,\n" +
                "\t\t\"isLimitDownload\": false,\n" +
                "\t\t\"orgCodes\": \"areatihuanzifuchuan\"\n" +
                "\t}\n" +
                "}";
        baseModel = baseModel.replace("1e5b2adf88554dcc90ac4963a879841b",fileId);
        baseModel = baseModel.replace("159721679721140224",parentId);
        if(fileName.contains("[")){
            fileName = fileName.substring(0,fileName.indexOf("["));
        }
        baseModel = baseModel.replace(".v8flags.6.8.275.32-node.51.2ad0123a6dc2bb7d85f7d84bcade18ce.json",fileName);
        area = area.replace("\"","");
        baseModel = baseModel.replace("areatihuanzifuchuan",area);
        System.out.println(baseModel);
        return baseModel;
    }
    //获取创建文件夹参数
    public static String getFolderParams(String folderName,String parentId,String level,String area){
        String baseModel = "{\n" +
                "\t\"app\": \"rwLibService\",\n" +
                "\t\"methodName\": \"createLibs\",\n" +
                "\t\"data\": {\n" +
                "\t\t\"createUser\": \"BJOO3702\",\n" +
                "\t\t\"createUserName\": \"BJOO3702\",\n" +
                "\t\t\"libsName\": \".v8flags.6.8.275.32-node.51.2ad0123a6dc2bb7d85f7d84bcade18ce.json\",\n" +
                "\t\t\"operateType\": \"rw\",\n" +
                "\t\t\"type\": \"folder\",\n" +
                "\t\t\"ispublish\": true,\n" +
                "\t\t\"level\": level1,\n" +
                "\t\t\"parentId\": \"159721679721140224\",\n" +
                "\t\t\"isLimitHandler\": false,\n" +
                "\t\t\"orgCodes\": \"areatihuanzifuchuan\",\n" +
                "\t\t\"agent_code\": \"\"\n" +
                "\t}\n" +
                "}";
        baseModel = baseModel.replace("level1",level);
        baseModel = baseModel.replace("159721679721140224",parentId);
        if(folderName.contains("[")){
            folderName = folderName.substring(0,folderName.indexOf("["));
        }
        baseModel = baseModel.replace(".v8flags.6.8.275.32-node.51.2ad0123a6dc2bb7d85f7d84bcade18ce.json",folderName);
        area = area.replace("\"","");
        System.out.println(area);
        baseModel = baseModel.replace("areatihuanzifuchuan",area);
        System.out.println(baseModel);
        return baseModel;
    }
    //根据名称获取到指定管域代码，如果为空，返回全部
    public static String getAreaCode(String name){
        String result = "";
        if(name==null){
            return result;
        }
        if(!name.contains("[")){
            result = "\"G|总部,A|北京分公司,C|江苏分公司,B|上海分公司,D|陕西分公司,E|广东分公司,H|深圳分公司,K|河北分公司,X|广西分公司,M|内蒙古分公司,I|重庆分公司,h|四川分公司,L|新疆分公司,f|山东分公司,S|天津分公司,c|吉林分公司,J|青岛分公司,R|浙江分公司,a|湖北分公司,Z|河南分公司\"";
            return result;
        }else {
            name = name.substring(name.indexOf("["));

        }

        if(name.contains("北京")){
            result = result+ "A|北京分公司,";
        }
        if(name.contains("上海")){
            result = result+ "B|上海分公司,";
        }
        if(name.contains("江苏")){
            result = result+ "C|江苏分公司,";
        }
        if(name.contains("陕西")){
            result = result+ "D|陕西分公司,";
        }
        if(name.contains("广东")){
            result = result+ "E|广东分公司,";
        }
        if(name.contains("总部")){
            result = result+ "G|总部,";
        }
        if(name.contains("深圳")){
            result = result+ "H|深圳分公司,";
        }
        if(name.contains("重庆")){
            result = result+ "I|重庆分公司,";
        }
        if(name.contains("青岛")){
            result = result+ "J|青岛分公司,";
        }
        if(name.contains("河北")){
            result = result+ "K|河北分公司,";
        }
        if(name.contains("新疆")){
            result = result+ "L|新疆分公司,";
        }
        if(name.contains("内蒙")){
            result = result+ "M|内蒙古分公司,";
        }
        if(name.contains("浙江")){
            result = result+ "R|浙江分公司,";
        }
        if(name.contains("天津")){
            result = result+ "S|天津分公司,";
        }
        if(name.contains("广西")){
            result = result+ "X|广西分公司,";
        }
        if(name.contains("河南")){
            result = result+ "Z|河南分公司,";
        }
        if(name.contains("湖北")){
            result = result+ "a|湖北分公司,";
        }
        if(name.contains("吉林")){
            result = result+ "c|吉林分公司,";
        }
        if(name.contains("山东")){
            result = result+ "f|山东分公司,";
        }
        if(name.contains("四川")){
            result = result+ "h|四川分公司";
        }
        return result;
    }
}
