package chaptor02_grammar;

//100以内的素数
public class Code06_PrimeNumber {
    public static void main(String[] args) {

        for (int i = 2; i < 100; ++i) {
            boolean flag = true;
            for (int j = 2; j <= (int) Math.sqrt(i); ++j) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("素数是：" + i);
            }
        }
    }
}
