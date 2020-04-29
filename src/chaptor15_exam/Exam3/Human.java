package chaptor15_exam.Exam3;

class Annoyance extends Exception {
}

class Sneeze extends Annoyance {
}

public class Human {
    public static void main(String[] args) throws Exception {
        try {
            try {
                throw new Sneeze();
                //throw new Annoyance();
            } catch (Annoyance a) {
                System.out.println("Caught Annoyance");  //输出
                throw a;
            }
        } catch (Sneeze s) {
            System.out.println("Caught Sneeze");  //？？？
            return;
        } finally {
            System.out.println("Hello World");  //输出
        }

    }
}
