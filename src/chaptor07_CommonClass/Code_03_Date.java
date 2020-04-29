package chaptor07_CommonClass;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public class Code_03_Date {
    public static void main(String[] args) throws Exception {

        //将字符串型的时间转成Sql类型date
        String bithday = "2019-10-16";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parseDate = sdf.parse(bithday);
        java.sql.Date dateSql = new java.sql.Date(parseDate.getTime());
        System.out.println("sql型日期是： " + dateSql);


        //三天打鱼，两天晒网
        String str1 = "2018-04-08";
        String str2 = "2018-10-16";

        Date date1 = sdf.parse(str1);
        Date date2 = sdf.parse(str2);
        int count = (int) ((date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24) + 1);
        System.out.println("天数之差： " + count);
        if (count % 5 == 4 || count % 5 == 0) {
            System.out.println("晒网");
        } else {
            System.out.println("打渔");
        }


        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        LocalDateTime ofTime = LocalDateTime.of(2019, 10, 16, 5, 45, 26);
        System.out.println(ofTime);


        System.out.println(ofTime.getDayOfMonth());
        LocalDateTime localDateTime1 = ofTime.withDayOfMonth(25);
        System.out.println(localDateTime1);
        LocalDateTime localDateTime2 = ofTime.minusDays(6);
        LocalDateTime localDateTime3 = ofTime.plusDays(6);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

        //格式化   时间---->字符串
        String strDate = dtf.format(LocalDateTime.now());
        System.out.println(strDate);

        //解析     字符串---->时间
        TemporalAccessor parseDateTime = dtf.parse(strDate);
        System.out.println(parseDateTime);

    }
}