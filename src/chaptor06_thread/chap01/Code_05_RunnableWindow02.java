package chaptor06_thread.chap01;

//实现Runnable接口的方式，模拟卖票。同步方法，解决线程安全问题
public class Code_05_RunnableWindow02 {
    public static void main(String[] args) {
        Window02 w1 = new Window02();

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window02 implements Runnable {

    //由于只创建一个对象，所以这个对象的ticket资源，在启动多个线程时天然共享
    private int ticket = 100;

    @Override

    //非静态的同步方法默认的锁为this，即当前对象，所以实现接口的方式可以使用非静态的同步方法
    //synchronized修饰方法还是对run方法的重写，所以可以直接将run方法声明成同步的，但是此时包多了，成单线程了
//    public synchronized void run() {
//        while (true) {
//            if (ticket > 0) {
//                System.out.println(Thread.currentThread().getName() + "正在卖出" + ticket + "号票");
//                ticket--;
//            } else {
//                break;
//            }
//        }
//    }

    //将需要同步的代码抽取出来，声明成单独的同步方法
    //同步代码执行完毕，while循环不会退出，所以虚拟机不会销毁
    public void run() {
        while (true) {
            sale();
        }
    }

    private synchronized void sale() {
        if (ticket > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "正在卖出" + ticket + "号票");
            ticket--;
        }
    }
}