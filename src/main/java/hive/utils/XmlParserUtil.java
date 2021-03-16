package hive.utils;
import hive.entity.ContentInfo;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.io.StringReader;
import java.util.ArrayList;


public class XmlParserUtil {
    private static ArrayList<ContentInfo> contentInfoArrayList = new ArrayList<>();

    public static void printXML(String xmlPath) throws DocumentException {

    }

    //获取根节点
    public static Element getXmlRootElement(String xmlContent) {
        //1.创建Reader对象
        SAXReader reader = new SAXReader();
        //2.加载xml

        try {
            StringReader stringReader = new StringReader(xmlContent);
            Document document = reader.read(stringReader);
            //3.获取根节点
            Element rootElement = document.getRootElement();
            return rootElement;
        } catch (DocumentException e) {
//            e.printStackTrace();
            //出错的数据不予理睬
        }
        return null;
    }

/*
    public static void main(String[] args) throws DocumentException {
        String xmlPath = "aa.xml";
        Element rootElement = getXmlRootElement(xmlPath);
        System.out.println(rootElement.elementText("content"));
    }
*/


}

