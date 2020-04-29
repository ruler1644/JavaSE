package chaptor02_grammar;

//打印空心菱形
public class Code08_Rhombus {
    public static void main(String[] args) {
        int layer = 5;
        for (int i = 1; i <= layer; i++) {
            for (int j = 1; j <= layer - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * (i - 1) + 1; k++) {
                if (k == 1 || k == 2 * (i - 1) + 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        int layer2 = 4;
        for (int i = 1; i <= layer2; ++i) {
            for (int j = 1; j <= i; ++j) {
                System.out.print(" ");
            }
            for (int k = 2 * (layer2 + 1 - i) - 1; k > 0; k--) {
                if (k == 1 || k == 2 * (layer2 + 1 - i) - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
