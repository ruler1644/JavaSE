package chaptor09_collection.com;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//测试List接口中声明的方法
public class Code_02_ListMethod {
	public static void main(String[] args) {
		List arrayList = new ArrayList();
		
		//1 add()
		arrayList.add(45);
		arrayList.add("FF");
		arrayList.add(5);
		
		//2 add(int index, Object obj)
		arrayList.add(0, "AAA");
		System.out.println(arrayList);
		
		//3 addAll(Collection c)
		List list = Arrays.asList(3,5,7);
		arrayList.add(list);
		//arrayList.addAll(list);
		
		//4 addAll(int index,Collection c)
		arrayList.addAll(0,list);
		System.out.println(arrayList);
		
/*		//5 get()
		System.out.println(arrayList.get(3));
		
		//6 indexOf()
		System.out.println(arrayList.indexOf(5));
		
		//6 lastIndexOf()
		System.out.println(arrayList.lastIndexOf(5));

		//7 remove()
		System.out.println(arrayList.remove(4));
		System.out.println(arrayList);
*/		
		//8 set()
		System.out.println(arrayList.set(4, "DDDDDDDD"));
		System.out.println(arrayList);
		
		
		
		
		
	}
}
