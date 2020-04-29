package chaptor15_exam.Exam;

public class Comm {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer p = new Producer(clerk);
        Thread producer1 = new Thread(p);
        producer1.setName("生产者1");


        Consumer c = new Consumer(clerk);

        Thread consumer1 = new Thread(c);
        consumer1.setName("消费者1");

        Thread consumer2 = new Thread(c);
        consumer2.setName("消费者2");


        producer1.start();
        consumer1.start();
        //consumer2.start();
    }

}

class Clerk {
    int num = 0;
    int maxNum = 20;
    int minNum = 0;

    public synchronized void add() {
        if (num < maxNum) {
            num++;
            System.out.println(Thread.currentThread().getName() + "生产第" + num + "件产品");

            notifyAll();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void reduce() {
        if (num > minNum) {
            System.out.println(Thread.currentThread().getName() + "消费第" + num + "件产品");
            num--;

            notifyAll();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer implements Runnable {//生产者
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + "开始生产产品");
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.add();
        }
    }
}

class Consumer implements Runnable {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始消费产品");
        while (true) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.reduce();
        }
    }
}



















