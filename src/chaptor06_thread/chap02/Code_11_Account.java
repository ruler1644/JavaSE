package chaptor06_thread.chap02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

//JDK1.5中新增的创建线程的方式，使用线程池
public class Code_11_Account {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //设置线程池属性
        //System.out.println(executorService.getClass());//ThreadPoolExecutor
        ThreadPoolExecutor service = (ThreadPoolExecutor) executorService;
        service.setCorePoolSize(15);
        //service.setKeepAliveTime(100);


        NumberThread numberThread = new NumberThread();

        //适合实现Runnable接口
        service.execute(numberThread);

        //适合实现Callable接口
        //executorService.submit();

        //关闭线程池
        service.shutdown();

    }
}

class NumberThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "线程，偶数是： " + i);
            }
        }
    }
}