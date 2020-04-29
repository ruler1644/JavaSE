package chaptor06_thread.chap02;

//两个人向同一个账户存钱，每次1000，交替存钱，总共六次
public class Code_08_Account02 {
    public static void main(String[] args) {
        MoneyAccount moneyAccount = new MoneyAccount();

        CustomerThread1 customerThread1 = new CustomerThread1(moneyAccount);

        Thread t1 = new Thread(customerThread1);
        t1.setName("a客户 ");
        t1.start();

        Thread t2 = new Thread(customerThread1);
        t2.setName("b客户 ");
        t2.start();
    }
}

class MoneyAccount {

    private double account = 0;

    public synchronized void add(double acc) {

        notify();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account += acc;
        System.out.println(Thread.currentThread().getName() + " 存钱成功，余额是 " + account);


        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class CustomerThread1 implements Runnable {
    private MoneyAccount account;

    public CustomerThread1(MoneyAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.add(1000);
        }
    }
}