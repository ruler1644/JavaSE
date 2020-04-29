package chaptor06_thread.chap01;

//继承Thread类的方式，模拟卖票。同步代码块，解决线程安全问题
public class Code_04_ThreadWindow01 {
    public static void main(String[] args) {
        TicketWindow01 w1 = new TicketWindow01();
        TicketWindow01 w2 = new TicketWindow01();
        TicketWindow01 w3 = new TicketWindow01();

        w1.start();
        w2.start();
        w3.start();
    }
}

class TicketWindow01 extends Thread {

    //创建三个线程类对象,要实现多个对象共享ticket资源,必须将ticket声明为静态的
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {

            //同步代码块不能包多，包多了一个线程将票卖完;包少了达不到同步的目的
            //同步监视器任何一个对象都可以充当，但需要多个线程共享同一把锁，所以继承Thread类的的方式，可由类.class或static对象充当对象锁
            synchronized (TicketWindow02.class) {
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