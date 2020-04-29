package chaptor15_exam.Exam2;
import org.junit.Test;
public class Exam1 {
	
	@Test
	public void test1() {
		boolean flag = true;
		int count = 0;
		for (int i = 101; i < 200; i++) {
			for (int j = 2; j * j <=i; j++) {
				if(i % j == 0) {
					flag = false;
					break;
				}
			}
			if(flag) {
				count++;
				System.out.print(i+" ");
			}
			flag = true;
		}
		System.out.println();
		System.out.println(count);
	}
	
	@Test
	public void test1_2() {
		int count = 0;
		for (int i = 101; i < 200; i++) {
			boolean flag = isPrime(i);
			if(flag) {
				count++;
				System.out.print(i+" ");
			}
		}
		System.out.println();
		System.out.println(count);
	}
	
	private boolean isPrime(int i) {
		for (int j = 2; j * j <= i; j++) {
			if(i % j == 0) {
				return false;
			}
		}
		return true;
	}
	
	@Test
	//第一次路程100 第二次是50 * 2
	public void test2() {
		double sum = 100;
		double high = sum / 2;
		for (int i = 2; i <= 10; i++) {
			sum += high *2;
			high /= 2;
		}
		System.out.println(sum);
		System.out.println(high);
		//299.609375
		//0.09765625
	}

	@Test
	//System.out.println(2 * 0.5 == 1);?????????????????????/
	public void test3() {
		int count = 0;
		for (int i = 0; i < (100 / 3); i++) {
			for (int j = 0; j < (100 / 2); j++) {
				for (int k = 0; k < (int)(100 / 0.5); k++) {
					if((i * 3+ j * 2 + k * 0.5 == 100) && (i + j + k == 100)) {
						count++;
						System.out.println(i+" "+j+"  "+k);
					}
				}
			}
		}
		System.out.println(count);
	}
	@Test
	public void test4() {
		for (int i = 5; i < 10000; i++) {
			System.out.println(getSum(i));
		}
	}
	
	private long getSum(int i) {
		if(i == 1) {
			return 1;
		}else {
			return i + getSum(i - 1);
		}
	}
	
	@Test
	public void test5() {
		int sum = 0;
		for (int i = 1; i <= 20; i++) {
			int res = getFaci(i);
			sum += res;
		}
		System.out.println(sum);
	}
	private int getFaci(int i) {
		if(i == 1) {
			return 1;
		}else {
			return i * getFaci(i - 1);
		}
	}
	
	//第一个人10，第2个比第1个人大2岁，
	//以此类推，请用递归方式计算出第8个人多大
	@Test
	public void test6() {
		int age = getAge(8);
		System.out.println(age);
	}
	private int getAge(int i) {
		if(i == 1) {
			return 10;
		}else {
			return getAge(i - 1) + 2;
		}
	}
	
	//有n步台阶，一次只能上1步或2步，共有多少种走法
	@Test
	public void test7() {
		System.out.println(getNum(5));
	}
	private int getNum(int i) {
		if(i == 1) {
			return 1;
		}else if(i == 2) {
			return 2;
		}else {
			return getNum(i - 1) + getNum(i - 2);
		}
	}
}
