package chaptor15_exam.Exam2;
//两个线程交替打印1~100之间的数字
public class Test {
	public static  void main (String []args){
		PrintNum printNum =new PrintNum();
		
		Thread t1 =new Thread(printNum);
		Thread t2 =new Thread(printNum);
		
		t1.setName("线程1");
		t2.setName("线程2");
		
		t1.start();
		t2.start();
		
	}  
}
class PrintNum implements Runnable{
	Object obj = new Object();
	int num = 1;
	@Override
	public void run() {
		while(true) {
			synchronized (obj) {
				
				obj.notify();
				
				if (num <= 50) {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "--->" + num++);
				}else {
					break;
				}
				try {
					
					obj.wait();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}