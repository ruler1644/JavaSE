package chaptor02_grammar;

//求两个数字的最大公约数和最小公倍数
public class Code05_MathNum {
    public static void main(String[] args) {
        int a = 15;
        int b = 6;

        int max = (a > b) ? a : b;
        int min = (a < b) ? a : b;

        int i = 0;
        for (i = min; i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                break;
            }
        }
        System.out.println("最大公约数是：" + i);


        int j = 0;
        for (j = max; j < a * b; j++) {
            if (j % a == 0 && j % b == 0) {
                break;
            }
        }
        System.out.println("最小公倍数是" + j);
    }
}
