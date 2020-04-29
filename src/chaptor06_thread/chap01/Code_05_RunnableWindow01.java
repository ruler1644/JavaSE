package chaptor06_thread.chap01;

//实现Runnable接口的方式，模拟卖票。同步代码块，解决线程安全问题
public class Code_05_RunnableWindow01 {
    public static void main(String[] args) {
        Window01 w1 = new Window01();

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window01 implements Runnable {

    //由于只创建一个对象，所以这个对象的ticket资源，在启动多个线程时天然共享
    private int ticket = 100;
    public int count = 0;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "正在卖出 " + ticket + " 号票");
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}