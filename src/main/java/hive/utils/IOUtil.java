package hive.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOUtil {
    //获取txt文件内容
    public static List<String> getTxtContent(String txtFilePath,String charset) throws IOException {
        //file对象
        File filePath = new File(txtFilePath);
        FileInputStream fis = new FileInputStream(filePath);
        InputStreamReader is = new InputStreamReader(fis,charset);
        BufferedReader br = new BufferedReader(is);

        List<String> lineList = new ArrayList<>();
        String tempLine = null;
        while((tempLine = br.readLine()) != null){
            lineList.add(tempLine);
        }
        br.close();
        return  lineList;
    }

    //写集合进文件
    public static boolean writeListToFile(String txtContent,
                                          String outPutFilePath,String charset) throws IOException {
        File outputFile = new File(outPutFilePath);
        FileOutputStream fos = new FileOutputStream(outputFile);
        fos.write(txtContent.getBytes(charset));
        fos.close();
        return true;
    }
/*    public static void main(String[] args) throws IOException {
        String txtFilePath = "weibodata\\中医\\content\\1221708937.txt";
        String inputCharset = "GBK";
        String outputCharset = "utf-8";
        String outputFilePath = "newFile.txt";
        List<String> lineList = getTxtContent(txtFilePath,inputCharset);
        for (String line : lineList) {
            System.out.println(line);
        }
        writeListToFile(lineList,outputFilePath,outputCharset);
    }*/
}
