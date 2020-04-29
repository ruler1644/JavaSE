package chaptor06_thread.chap01;

/*Thread类的常用方法
 * 1.run():将分线程要执行的操作声明在run()
 * 2.start():①启动线程 ②调用线程的run()
 * 3.currentThread():静态方法，获取当前的执行操作的线程
 * 4.getName():获取当前线程的名字
 * 5.setName():设置当前线程的名字
 * 6.yield():一旦执行此方法，当前线程就释放锁cpu的执行权
 * 7.join():如果在线程a中调用了线程b的join(),此时线程a进入阻塞状态，直到线程b执行结束以后，线程a才结束阻塞。
 * 8.sleep(long millis):静态方法，让当前线程“睡眠”指定的毫秒数。当毫秒数到以后，结束阻塞状态。
 * 9.isAlive():判断当前线程是否存活
 */
public class Code_03_ThreadMethod {
    public static void main(String[] args) {
        NumberThread3 n3 = new NumberThread3();
        Thread t = new Thread(n3);
        t.setName("支线程1");
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();
//		try {
//			Thread.currentThread().sleep(10);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

        for (int i = 0; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "偶数 :" + i);
            }
            if (i == 4) {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(t.isAlive());

    }
}

class NumberThread3 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "偶数 :" + i);
            }
        }
    }

}



