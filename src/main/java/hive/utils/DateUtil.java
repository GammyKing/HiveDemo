package hive.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static Date getDate(String dataString) throws ParseException {
        return dateFormat.parse(dataString);
    }
}
