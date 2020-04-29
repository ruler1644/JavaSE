package chaptor07_CommonClass;

public class Code_07_String {
    public static void main(String[] args) {
        String str1 = new String();
        String str2 = new String("abc");


        StringBuffer sb0 = new StringBuffer();
        StringBuffer sb1 = new StringBuffer(50);

        StringBuffer sb2 = new StringBuffer("abc");
        sb2.append("123");
        System.out.println(sb2);
        System.out.println(sb2.delete(2, 4));
        System.out.println(sb2);

        System.out.println(sb2.replace(1, 2, "hahaha"));

    }
}
