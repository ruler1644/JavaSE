package chaptor07_CommonClass;

/*

5.对字符串中字符进行自然顺序排序。"abcwerthelloyuiodef"
提示：
1）字符串变成字符数组。
2）对数组排序，选择，冒泡，Arrays.sort(str.toCharArray());
3）将排序后的数组变成字符串。
*/
public class Code_01_Trim {
    public static void main(String[] args) {
//        System.out.println(MyTrim("    "));
//        System.out.println(MyTrim("  fgng "));
//
//
//        System.out.println(reverse("abcde"));
//        System.out.println(reverse2("abcde"));

        System.out.println(reverse("abcdefg", 2, 5));
        System.out.println(reverse2("abcdefg", 2, 5));

    }


    //1.模拟trim方法，去除字符串两端的空格
    public static String MyTrim(String str) {

        //字符串为null
        if (str == null) {
            return null;
        }

        //长度为0的字符串
        if (str.length() == 0) {
            return "0";
        }

        int start = 0;
        int end = str.length() - 1;
        while (start < end && str.charAt(start) == ' ') {
            start++;
        }
        while (end > start && str.charAt(end) == ' ') {
            end--;
        }

        //都是空值，长度不为0的字符串
        if (str.charAt(start) == ' ') {
            return "";
        }

        return str.substring(start, end + 1);
    }

    //2.将一个字符串进行反转
    public static String reverse(String str) {
        char[] arr = str.toCharArray();
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return new String(arr);
    }

    public static String reverse2(String str) {
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length / 2; i++) {
            char tmp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
        }
        return new String(arr);
    }

    //3.将字符串中指定部分进行反转，比如将“abcdefg”反转为”abfedcg”
    public static String reverse(String str, int start, int end) {
        StringBuilder sb = new StringBuilder(str.substring(0, start));
        String str2 = str.substring(end + 1);

        for (int i = end; i >= start; i--) {
            sb.append(str.charAt(i));
        }
        return sb.append(str2).toString();
    }

    public static String reverse2(String str, int start, int end) {
        char[] arr = str.toCharArray();
        for (int i = start, j = end; i < j; i++, j--) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return new String(arr);
    }
}