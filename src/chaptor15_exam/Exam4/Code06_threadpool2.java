package chaptor15_exam.Exam4;

import java.util.Random;
import java.util.concurrent.*;

public class Code06_threadpool2 {
    public static void main(String[] args) {

        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(5);
        ScheduledFuture<Integer> futureTask = null;


        try {
            for (int i = 1; i <= 20; i++) {

                Callable callable = new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        System.out.print(Thread.currentThread().getName() + "线程");
                        return new Random().nextInt(10);
                    }
                };

                futureTask = threadPool.schedule(callable, 3, TimeUnit.SECONDS);
                System.out.println("--------" + futureTask.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}

