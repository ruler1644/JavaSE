package chaptor02_grammar;

//将一个三位数各个位上的数字分解
public class Code01_SplitNum {
    public static void main(String[] args) {
        int num = 153;
        int bai = num / 100;
        int shi = num / 10 % 10;
        int shi2 = num % 100 / 10;
        int ge = num % 10;
        System.out.println(bai);
        System.out.println(shi);
        System.out.println(shi2);
        System.out.println(ge);
    }

}
