package hive.utils;

import java.util.List;

public class StringUtil {
    public static String join(List<Object> objects,String delimiter){
        int lineCounter = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for(Object obj : objects){
            if (lineCounter>0){
                stringBuilder.append(delimiter);
            }
            stringBuilder.append(obj.toString());
            lineCounter++;
        }
        return stringBuilder.toString();
    }
}
