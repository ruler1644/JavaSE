package chaptor06_thread.chap01;

//继承Thread类的方式创建线程
public class Code_01_Thread {
    public static void main(String[] args) {
        NumberThread n = new NumberThread();
        n.start();

    }
}
class NumberThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            if(i % 2 == 0 ) {
                System.out.println("偶数 :"+i);
            }
        }
    }
}