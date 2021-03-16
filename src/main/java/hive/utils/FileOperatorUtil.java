package hive.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileOperatorUtil {

    //取得文件路径。
    public static List<String> getAllSubFilePath(String filePath){
        File file = new File(filePath);
        List<String> resultList = new ArrayList<>();
        //若是目录。往下一层
        if (file.isDirectory()){
            for (File tempFile : file.listFiles()) {
                resultList.addAll(getAllSubFilePath(tempFile.toString()));
            }
        }else{
            resultList.add(file.toString());
        }
        return resultList;
    }

/*    public static void main(String[] args) {
        String filePath = "weibodata";
        List<String> resultList = getAllSubFilePath(filePath);
        for (String filePath1:resultList){
            System.out.println(filePath1);
        }
    }*/
}
