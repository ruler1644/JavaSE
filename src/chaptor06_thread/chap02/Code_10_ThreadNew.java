package chaptor06_thread.chap02;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

//JDK1.5中新增的创建线程的方式，实现Callable接口方式
public class Code_10_ThreadNew {
    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        FutureTask futureTask = new FutureTask(myThread);

        Thread thread = new Thread(futureTask);
        thread.start();

        try {

            Object sum = futureTask.get();
            System.out.println(sum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyThread implements Callable {
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}