package chaptor15_exam.Exam;
import java.util.Arrays;

import org.junit.Test;
public class Exam2 {
	//@Test
	public void fun6() {
		printStar(5);
	}
	public void printStar(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= 2 * i -1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	//@Test
	public void fun7() {
		String str = "hello1234";
		String newStr = "";
		for (int i =  str.length() - 1 ; i >= 0; --i) {
			newStr += str.charAt(i);
		}
		System.out.println(newStr);
	}
	@Test
	public void fun8() {
		String str = "http://127.0.0.1:8080/examples/a.txt?username=Tom&&pasword=123";
		
		int index = str.lastIndexOf('.');
		int index2 = str.indexOf("?");
		
		String subStr = str.substring(index + 1,index2);
		System.out.println(subStr);
	}
	
	@Test
	/*有一个字符串String abc = “342567891”，请写程序将字符串abc进行升序，
	可以使用JDK API中的现有的功能方法*/
	public void fun9() {
		String abc = "342567891";
		char[] arr = abc.toCharArray();
		Arrays.sort(arr);
		String newStr = new String(arr);
		System.out.println("newStr ="+newStr);
	}
	
	@Test
	public void fun10() {
		SingleTon instance1 = SingleTon.getInstance();
		SingleTon instance2 = SingleTon.getInstance();
		System.out.println(instance1);
		System.out.println(instance2);
	}
	@Test
	public void fun11() {
		SingleTonTon instance1 = SingleTonTon.getInstance();
		SingleTonTon instance2 = SingleTonTon.getInstance();
		System.out.println(instance1);
		System.out.println(instance2);
	}
}

class SingleTon{
	private static SingleTon instance = new SingleTon();
	private SingleTon() {
	}
	public static SingleTon getInstance() {
		return instance;
	}
}

class SingleTonTon{
	private static SingleTonTon instance = null;
	private SingleTonTon() {
	}
	public static SingleTonTon getInstance() {
		if(instance == null) {
			synchronized (SingleTonTon.class) {
				if (instance == null) {
					instance = new SingleTonTon();
				}
			}
		}
		return instance;
	}
}