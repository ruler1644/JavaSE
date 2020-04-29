package chaptor15_exam.Exam3;

public class OuterTest {
    class Inner {
    }

    public static void foo() {
        new OuterTest().new Inner();
    }

    public void bar() {
        new Inner();
    }

    public static void main(String[] args) {
        new OuterTest().new Inner();

    }
}
