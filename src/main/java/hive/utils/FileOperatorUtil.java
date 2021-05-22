package hive.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileOperatorUtil {

    //取得所有文件内的行
    public static List<String> getAllFileLineList(String inputDir,String charset) throws IOException {
        ArrayList<String> resultList = new ArrayList<>();
        //获取所有文件名的集合
        List<String> txtFilePathList = FileOperatorUtil.getAllSubFilePath(inputDir);
        int fileCounter = 0;
        //获取文件内容
        for (String txtFilePath : txtFilePathList) {
            List<String> singleTxtLineList = IOUtil.getTxtContent(txtFilePath, charset);
            resultList.addAll(singleTxtLineList);
            fileCounter++;
        }
        System.out.println("共执行"+fileCounter+"个文件。");
        //返回所有文本的内容
        return resultList;
    }

    //获取不带后缀的文件名
    public static String getNameWithOutSuffix(String filePath){
        File file = new File(filePath);
        return file.getName().split("\\.")[0];
    }


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
