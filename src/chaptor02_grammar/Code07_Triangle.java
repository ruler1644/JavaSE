package chaptor02_grammar;

//打印空心三角形
public class Code07_Triangle {
    public static void main(String[] args) {
        int layer = 5;
        for (int i = 1; i <= layer; i++) {
            for (int j = 1; j <= layer - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * (i - 1) + 1; k++) {
                if (i == 1 || i == layer) {
                    System.out.print("*");
                } else {
                    if (k == 1 || k == 2 * (i - 1) + 1) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
}
