package chaptor15_exam.Exam;
import java.util.Scanner;
import org.junit.Test;
public class Exam {
	@Test
	public void  fun1() {
		int res = 0;
		for (int i = 1; i < 100; i++) {
			if(i % 2 != 0) {
				res += i;
			}
		}
		System.out.println(res);
	}
	@Test
	public void  fun2() {
		int[] arr = new int[]{5,7,3,9,2};
		int tmp = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if(arr[j] > arr[j + 1]) {
					tmp = arr[j];
					arr[j] = arr[j +1];
					arr[j + 1]= tmp;
							
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"  ");
		}
		
	}
	@Test
	public void  fun3() {
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入年份：");
		int year = scan.nextInt();
		System.out.print("请输入月份：");
		int month = scan.nextInt();
		System.out.print("请输入日期：");
		int day = scan.nextInt();
		int sum = 0; 
		switch(month) {
			case 12:
				sum += 30;
			case 11:
				sum += 31;
			case 10:
				sum += 30;
			case 9:
				sum += 31;
			case 8:
				sum += 31;
			case 7:
				sum += 30;
			case 6:
				sum += 31;
			case 5:
				sum += 30;
			case 4:
				sum += 31;
			case 3:
				if((year % 400 ==0) ||  (year % 4 == 0 && year % 100 != 0)) {
					sum += 29;
				}else {
					sum += 28;
				}
			case 2:
				sum += 31;
			case 1:
				sum += day;
		}
		System.out.println("总的天数为："+sum);
	}
		
	@Test
	public void  fun4(){
		for (int i = 5; i < 10000; i++) {
			long num = getSum(i);
			System.out.println(i+"num = "+num);
		}
	}
	public long getSum(int i) {
		long sum = 0;
		for (int j = i; j > 0; --j) {
			sum += j;
		}
		return sum;
	}
		
	@Test
	//循环实现求阶乘和
	public void  fun5(){
		int res =0;
		int tmp = 1;
		for (int i = 1; i <= 20; i++) {
			for (int j = 1; j <= i; j++) {
				tmp *= j;
			}
			res += tmp;
			tmp =1;
		}
		System.out.println("循环阶乘和是："+res);//268040729
	}
	@Test
	//递归实现求阶乘和
	public void  fun52(){
		int sum = 0;
		for (int i = 1; i <= 20; i++) {
			sum += digui(i);
		}
		System.out.println("递归阶乘和："+sum);//268040729
	}
	public long digui(int i) {
		if(i == 1) {
			return 1;
		}else {
			return i * digui(i - 1);
		}
	}
}
