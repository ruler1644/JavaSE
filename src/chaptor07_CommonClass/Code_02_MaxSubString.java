package chaptor07_CommonClass;

import java.util.ArrayList;
import java.util.List;

public class Code_02_MaxSubString {
    public static void main(String[] args) {
        System.out.println(totalCount("abkkcadkabkebfkabkskab", "ab"));
        System.out.println(maxString("helloreygredfhhworld", "thellojgsertythtgrfdworld"));
    }

    //3.获取一个字符串在另一个字符串中出现的次数
    public static int totalCount(String main, String sub) {
        int max = main.length();
        int min = sub.length();
        int count = 0;
        int index = 0;

        /*if (max >= min) {
            while ((index = main.indexOf(sub)) != -1) {
                count++;
                main = main.substring(index + min);
            }
        }*/
        if (max >= min) {
            while ((index = main.indexOf(sub, index)) != -1) {
                count++;
                index += min;
            }
        }
        return count;
    }

    // 4.获取两个字符串中最大相同子串，若有多个只找第一个
    public static List maxString(String str1, String str2) {
        String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
        String minStr = (str1.length() < str2.length()) ? str1 : str2;
        int length = minStr.length();
        List list = new ArrayList();

        for (int i = 0; i < length; i++) {
            for (int x = 0, y = length - i; y <= length; x++, y++) {
                String subStr = minStr.substring(x, y);
                if (maxStr.contains(subStr)) {
                    list.add(subStr);
                }
            }
            if(list.size()>0){
                return list;
            }
        }
        throw new RuntimeException("没有最大子串");
    }
}