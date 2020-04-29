package chaptor15_exam.Exam2;
import java.util.Arrays;
import java.util.Scanner;
import org.junit.Test;
public class Exam2 {
	@Test
	public void test8() {
		System.out.print("请输入一个整数：");
		Scanner scan = new Scanner(System.in); 
		String strNum= scan.nextLine();
		char[] cArr = strNum.toCharArray();
		Arrays.sort(cArr);
		System.out.println(new String(cArr));
	}
	
	
	@Test
	public void test9() {
		String str = "中中国55kkFFf";
		int numCount = 0;
		int charCount = 0;
		int otherCount = 0;
		char[] arr =str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] >= '0' && arr[i] <= '9') {
				numCount++;
			}else if((arr[i] >= 'a' && arr[i] <= 'z') || (arr[i] >= 'A' && arr[i] <= 'Z')) {
				charCount++;
			}else{
				otherCount++;
			}
			
		}
		System.out.println(numCount+" "+charCount +" "+otherCount);
	}
	@Test
	public void test92() {
		String res= "";
	    String num = "";
	    int count = 0;
	    
		String string = "中中国55kkfff";
		char arr[] = string.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if(0 == i) {
				count = 1;
				res = String.valueOf(arr[i]);
			}else if(arr[i] == arr[i - 1]) {
				count++;
				if(i == arr.length -1) {
					res = res +":"+count;
				}
			}else {
				res = res +":"+ count +"\n" + String.valueOf(arr[i]);
				count = 1;
				if(i == arr.length -1) {
					res = res +":"+ count;
				}
				
			}
		}
	    System.out.println(res);
	}
	
	@Test
	//斐波那契数列递归实现
	public void test10() {
		System.out.println(fai(10));
	}
	private int fai(int i) {
		if(i == 1 || i == 2) {
			return 1;
		}else {
			return fai(i - 1)+ fai(i - 2);
		}
	}
	@Test
	//斐波那契数列非递归实现
	public void test102() {
		int f1 = 1;
		int f2 = 1;
		int f3 = 0;
		for (int i = 3; i <= 10; i++) {
			f3 = f1 + f2;
			f1 = f2;
			f2 = f3;
		}
		System.out.println(f3);
	}
}
