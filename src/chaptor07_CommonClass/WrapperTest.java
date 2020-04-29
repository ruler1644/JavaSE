package chaptor07_CommonClass;
import java.text.SimpleDateFormat;
import org.junit.Test;

public class WrapperTest {
	//@Test
	public void test1() {
		String s1 = "2";
		String s2 = "4";
		
		int num1 = Integer.parseInt(s1);
		
		//装箱
		Integer a = num1;
		Integer b = new Integer(s2);
//		Integer b = Integer.valueOf(s2);
		//拆箱
		int m = a.intValue();
		int n = b.intValue();
		System.out.println(m + n);
		int mutli = a * b;
		System.out.println(mutli);
	}
	
	//@Test
	public void test2() {
		Integer x = 128;
		Integer y = 128;
		System.out.println(x);
		System.out.println(y);
		System.out.println(x == y);
	}
	
	//@Test
	public void test3() {
		String str ="abcdefg";
		int count = 0;
		char[] arr = new char[str.length()];
		for(int i = str.length()-1;i >= 0; --i) {
			arr[count++] = str.charAt(i);
		}
		System.out.println(arr);
	}
	
	//@Test
	public void test4() {
		String str ="abcdefg";
		String s = "";
		for(int i = str.length()-1;i >= 0; --i) {
			s += str.charAt(i);
		}
		System.out.println(s);
		
	}
	
	//@Test
	public void test5() {
		String str ="abcdabdsdabngefgab";
		String s = "ab";
		int  count = 0;
		while(true) {
			int index = str.indexOf(s);
			if(index== -1) {
				break;
			}
			count++;
			str = str.substring(index + s.length());
		}
		System.out.println("次数count:"+count);
	}
	
	//@Test
	public void test6() {
		String str ="abcdabdsdabngefgab";
		String s = "ab";
		int count = 0;
		int start = 0;
		while(true) {
			int index = str.indexOf(s,start);
			if(index== -1) {
				break;
			}
			count++;
			start = index + s.length();
		}
		System.out.println(count);
	}
	
	//@Test
	public void test7() {
		String str ="abcdefg";
		System.out.println(str);
		int start = 2;
		int end = 6;
		String s1 = str.substring(0,start);
		String s2= str.substring(start, end);
		String s3 = str.substring(end);
		String newStr = "";
		for(int i = s2.length() - 1;i >= 0;--i) {
			newStr += s2.charAt(i);
		}
		
		System.out.println(s1 + newStr + s3);
	}
	//@Test
	public void test8() {
		String s1 = "abc";
		String s2 = "123";
		String s3 = "def";
		
		StringBuilder sb= new StringBuilder(s1);
		System.out.println(sb.append(s2).insert(0, s3));
	}
	
	//@Test
	public void test9() throws InterruptedException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		while(true) {
			long longTime = System.currentTimeMillis(); 
			System.out.println(sdf.format(longTime));
			Thread.sleep(1000);
		}
	}
	@Test
	public void test10() {
		int x = 4,y = 4;
		if(x > 2){
		   if(y > 2)
		        System.out.println(x + y);
		        System.out.println("atguigu");              
		}else
		   System.out.println(x); 
	}
}
