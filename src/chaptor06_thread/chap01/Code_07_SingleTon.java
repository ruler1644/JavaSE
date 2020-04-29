package chaptor06_thread.chap01;
//线程安全的懒汉式单例模式
public class Code_07_SingleTon {
	public static void main(String[] args) {
		
		//11
		new Thread() {
			@Override
			public void run() {
				System.out.println(SingleTon.getInstance());
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				System.out.println(SingleTon.getInstance());
			}
		}.start();
		
		//22
		new Thread() {
			@Override
			public void run() {
				System.out.println(SingleTon2.getInstance());
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				System.out.println(SingleTon2.getInstance());
			}
		}.start();
		
		//33
		new Thread() {
			@Override
			public void run() {
				System.out.println(SingleTon3.getInstance());
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				System.out.println(SingleTon3.getInstance());
			}
		}.start();
		
		
		//44
		new Thread() {
			@Override
			public void run() {
				System.out.println(SingleTon4.getInstance());
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				System.out.println(SingleTon4.getInstance());
			}
		}.start();
		
	}
}

// 1线程不安全的懒汉式单例模式
class SingleTon{
	private static SingleTon instance;
	
	private SingleTon() {
	}
	
	public static SingleTon getInstance() {
		if(instance == null) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new SingleTon();
		}
		return instance;
	}
}
//  2线程不安全的懒汉式单例模式，同步方法解决
class SingleTon2{
	private static SingleTon2 instance;
	
	private SingleTon2() {
		
	}
	
	public static synchronized SingleTon2 getInstance() {
		if(instance == null) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new SingleTon2();
		}
		return instance;
	}
}

// 3线程不安全的懒汉式单例模式，同步代码块解决，效率不高。即使已经创建出对象，每次还需要进入同步代码块判断
class SingleTon3{
	private static SingleTon3 instance;
	
	private SingleTon3() {
		
	}
	
	public static SingleTon3 getInstance() {
		synchronized (SingleTon3.class) {
			if (instance == null) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				instance = new SingleTon3();
			}
		}
		return instance;
	}
}

//  4线程不安全的懒汉式单例模式，同步代码块解决,效率较高。不需要每次都进入同步代码块，判断对象是否已经创建
class SingleTon4{
	private static SingleTon4 instance;
	
	private SingleTon4() {
		
	}
	
	public static SingleTon4 getInstance() {
		if (instance == null) {
			synchronized (SingleTon4.class) {
				if (instance == null) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					instance = new SingleTon4();
				}
			}
		}
		return instance;
	}
}