package chaptor06_thread.chap02;

//两个人向同一个账户存钱，分别存三次,每次1000，存完打印余额
public class Code_08_Account01 {
    public static void main(String[] args) {
        Account account = new Account(0);
        Customer c1 = new Customer(account);
        Customer c2 = new Customer(account);
        c1.setName("甲 ");
        c2.setName("乙 ");

        c1.start();
        c2.start();
    }
}

class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public synchronized void add(double amt) {

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        balance += amt;
        System.out.println(Thread.currentThread().getName() + "线程，存钱成功，现在余额是： " + balance);
    }
}

class Customer extends Thread {

    private Account acct;

    public Customer(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acct.add(1000);
        }
    }
}



