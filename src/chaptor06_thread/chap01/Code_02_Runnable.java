package chaptor06_thread.chap01;
//实现Runnable接口的方式创建线程
public class Code_02_Runnable {
	public static void main(String[] args) {
		NumberThread2 n2 = new NumberThread2();
		Thread t = new Thread(n2);
		t.start();
	}
}
class NumberThread2 implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			if(i % 2 == 0 ) {
				System.out.println("偶数 :"+i);
			}
		}
	}
}



