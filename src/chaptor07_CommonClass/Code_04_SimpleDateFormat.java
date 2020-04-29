package chaptor07_CommonClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Code_04_SimpleDateFormat {
    public static void main(String[] args) {

        Date date = new Date();
        System.out.println("默认时间：" + date);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化  日期---->字符串
        String dateStr = sdf.format(date);
        System.out.println("格式化时间：" + dateStr);

        //解析   字符串---->日期
        String string = new String("2019-11-08 15:03:22");
        try {
            Date parseDate = sdf.parse(string);
            System.out.println("解析时间：" + parseDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
