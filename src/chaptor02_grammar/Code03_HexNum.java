package chaptor02_grammar;

//将一个三位的十进制数转化成十六进制形式
public class Code03_HexNum {
    public static void main(String[] args) {
        int num = 60;
        int tmp1 = num & 15;
        String str1 = (tmp1 > 9) ? ((char) (tmp1 - 10 + 'A')) + "" : (tmp1 + "");

        int tmp2 = num >>> 4 & 15;
        String str2 = (tmp2 > 9) ? ((char) (tmp2 - 10 + 'A')) + "" : (tmp2 + "");

        System.out.println(str2 + str1);
        System.out.println(Integer.toHexString(60));
    }
}
