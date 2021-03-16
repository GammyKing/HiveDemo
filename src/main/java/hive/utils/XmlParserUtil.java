package hive.utils;
import hive.entity.ContentInfo;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;


public class XmlParserUtil {
//    private static ArrayList<ContentInfo> contentInfoArrayList = new ArrayList<>();

    public static String getXMLByString(String xmlstr){
        if(xmlstr == ""||xmlstr == null){
            return null;
        }
        xmlstr = xmlstr.replace("&nbsp;", " ").replace("&", "&amp;")
                .replace("<<", "《").replace(">>", "》").replace("<--", "《--")
                .replace(">_<", "-_-");

        return xmlstr;
    }


    //获取根节点
    public static Element getXmlRootElement(String xmlContent) throws IOException {
        //1.创建Reader对象
        SAXReader reader = new SAXReader();
       //对文本内容进行改正。
        String xmlContent_right = null;
        try {
            xmlContent_right = XmlParserUtil.getXMLByString(xmlContent);
        } catch (Exception e) {
            // 日志信息收集
            // 1. 收集出错的行数
            // 2. 这一行内容
            Constants.errorCount ++;
            IOUtil.writeListToFile(xmlContent, "error.txt", "utf-8");
        }
        //2.加载xml

        try {
            StringReader stringReader = new StringReader(xmlContent_right);
            Document document = reader.read(stringReader);
//            Document document = XmlParserUtil.getXMLByString(xmlContent);
            //3.获取根节点
            Element rootElement = document.getRootElement();
            return rootElement;
        } catch (DocumentException e) {
//            e.printStackTrace();
            //出错的数据不予理睬
        }
        return null;
    }


}

