package chaptor06_thread.chap01;

//继承Thread类的方式，模拟卖票。同步方法，解决线程安全问题
public class Code_04_ThreadWindow02 {
    public static void main(String[] args) {
        TicketWindow02 w1 = new TicketWindow02();
        TicketWindow02 w2 = new TicketWindow02();
        TicketWindow02 w3 = new TicketWindow02();

        w1.start();
        w2.start();
        w3.start();
    }
}

class TicketWindow02 extends Thread {

    //创建三个线程类对象,要实现多个对象共享ticket资源,必须将ticket声明为静态的
    private static int ticket = 100;

    @Override

    //同步方法有默认的对象锁，非静态方法的对象锁为this即当前对象。但是继承Thread类的方式， 创建了多个对象,致使对象锁不唯一,达不到同步部目的
    //public synchronized void run() {

    //静态方法的对象锁为当前类本身，保证了锁的唯一性。但是static的run方法不是对Thread类中run方法的重写,不是多线程
    //public static synchronized void run() {

    //只能将需要同步的代码抽取出来，在run方法中调用抽取出的方法
    //由于死循环不会退出，所以最后车票卖完，虚拟机也不会销毁
    public void run() {
        while (true) {
            sale();
        }
    }

    //使用static保证锁的唯一性，也可以访问静态变量ticket
    private static synchronized void sale() {
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