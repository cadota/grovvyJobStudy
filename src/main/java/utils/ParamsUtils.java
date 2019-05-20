package utils;

/**
 * @auther:panzhen
 * @Des
 * @Date:Create in 2019/5/20
 * @Modified By:
 */
public class ParamsUtils {
    public static String getFileParams(String fileName,String fileId,String parentId){
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
                "\t\t\"orgCodes\": \"\"\n" +
                "\t}\n" +
                "}";
        baseModel = baseModel.replace("1e5b2adf88554dcc90ac4963a879841b",fileId);
        baseModel = baseModel.replace("159721679721140224",parentId);
        baseModel = baseModel.replace(".v8flags.6.8.275.32-node.51.2ad0123a6dc2bb7d85f7d84bcade18ce.json",fileName);
        return baseModel;
    }
    public static String getFolderParams(String folderName,String parentId){
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
                "\t\t\"level\": 1,\n" +
                "\t\t\"parentId\": \"159721679721140224\",\n" +
                "\t\t\"isLimitHandler\": false,\n" +
                "\t\t\"orgCodes\": \"G|总部\",\n" +
                "\t\t\"agent_code\": \"BJOO3702\"\n" +
                "\t}\n" +
                "}";
        baseModel = baseModel.replace("159721679721140224",parentId);
        baseModel = baseModel.replace(".v8flags.6.8.275.32-node.51.2ad0123a6dc2bb7d85f7d84bcade18ce.json",folderName);
        return baseModel;
    }
}
