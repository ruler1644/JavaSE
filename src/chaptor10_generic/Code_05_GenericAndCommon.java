package chaptor10_generic;

import java.util.ArrayList;
import java.util.List;

//通配符&&有限制的通配符
public class Code_05_GenericAndCommon {
	public static void main(String[] args) {
	
/*		
		//--------------11111111--------------
		List <?> list1 = null;
		List <Object> list2 = null;
		List <String> list3 = new ArrayList<>();
		list3.add("123");
		
		list1 = list2;
		list1 = list3;
		
		//使用了通配符，list1添加数据时，除了null之外，其他值都不能添加
		list1.add(null);
		//list1.add("123");
		Object obj = list1.get(1);
		System.out.println(obj);		
	
		//---------------222222222-----------------
		List<Object> list1 = null;
		List<Person> list2 = null;
		List<Student> list3 = new ArrayList<>();
		List<? extends Person> list4 = null;
		
		// List<Object>不是List<? extends Person> 的子类
		//list4 = list1;
		list4 = list2;
		list4 = list3;
		
		list4.add(null);
//		list4.add(new Student());
//		list4.add(new Person());
		
		Person p =list4.get(0);
		System.out.println(p);
*/			
		//-------------3333333333-----------------
		List<Object> list1 = null;
		List<Person> list2 = new ArrayList<>();
		List<Student> list3 = new ArrayList<>();
		List <? super Person> list5 = null;
		
		// List<Student> list3不是List<? super Person>的子类
		list5 = list1;
		list5 = list2;
		//list5 = list3;
		
		list5.add(null);
		//list5.add(new Object());
		list5.add(new Person());
		list5.add(new Student());
		
		Object o = list5.get(0);
		System.out.println(o);
		
	}
}
class Person{
}
class Student extends Person{
}