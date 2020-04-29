package chaptor15_exam.Exam4;

import java.util.Random;
import java.util.concurrent.*;

public class Code06_threadpool {
    public static void main(String[] args) {

        //ExecutorService threadPool = Executors.newFixedThreadPool(5);
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();
        ExecutorService threadPool = Executors.newCachedThreadPool();
        Future<Integer> futureTask = null;

        try {
            for (int i = 0; i < 20; i++) {

                futureTask = threadPool.submit(new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        Thread.sleep(50);
                        System.out.print(Thread.currentThread().getName() + "线程");
                        return new Random().nextInt(10);
                    }
                });
                System.out.println("--------" + futureTask.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}

