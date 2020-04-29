package chaptor07_CommonClass;

import java.util.Arrays;
import java.util.Comparator;

public class Code_08_Comparable {
    public static void main(String[] args) {
        String[] arr = new String[]{"AA", "FF", "DD", "BB"};
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String str1 = (String) o1;
                    String str2 = (String) o2;
                    return -str1.compareTo(str2);
                }
                throw new RuntimeException("数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));


        String str = new String("abc");
        System.out.println("abc".equals(str));

    }
}
