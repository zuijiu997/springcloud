package zuijiu997.outh2.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by fp295 on 2018/6/27.
 */
public class DateUtil {

    public static String date(long timestamp) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date(timestamp));
    }
}
