package chaptor05_exception;

public class TestFinally {
    public static void main(String[] args) {
        System.out.println(test());
    }

    public static int test() {
        int n = 10;
        try {
            return n;
        } finally {
            ++n;
            System.out.println(n);
            //return n;
        }
    }
}
