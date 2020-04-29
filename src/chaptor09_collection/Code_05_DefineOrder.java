package chaptor09_collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
//定制排序，按生日日期的先后排序。
public class Code_05_DefineOrder {

	public static void main(String[] args) {
		Person[] arr = new Person[8];
		
		arr[0] = new Person("AA",32,new MyDate1(1999,3,1));
		arr[1] = new Person("AA",35,new MyDate1(1999,4,2));
		arr[2] = new Person("AA",35,new MyDate1(1999,3,2));
		arr[3] = new Person("AA",35,new MyDate1(1999,3,1));
		
		arr[4] = new Person("AB",32,new MyDate1(2000,1,1));
		arr[5] = new Person("AB",35,new MyDate1(2000,2,2));
		arr[6] = new Person("AB",35,new MyDate1(2000,1,2));
		arr[7] = new Person("AB",35,new MyDate1(2000,1,1));
		
		Comparator com = new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				if(o1 instanceof Person && o2 instanceof Person) {
					Person p1 = (Person)o1;
					Person p2 = (Person)o2;
					int month = p1.getBirthday().getMonth() - p2.getBirthday().getMonth();
					int day = p1.getBirthday().getDay() - p2.getBirthday().getDay();
					
					//方式一
//					if(month != 0) {
//						return month;
//					}else {
//						if(day != 0 ) {
//							return day;
//						}
//					}
					
					//方式二
					if(month != 0) {
						return month;
					}
					if(day != 0 ) {
						return day;
					}
					
					//方式三  MyDate实现comparable接口
				}
				return 0;
			}
		};
		
		Set set = new TreeSet(com);
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
class Person {
	private  String name;
	private int age;
	private MyDate1 birthday;
	
	public Person() {
		super();
	}
	public Person(String name, int age, MyDate1 birthday) {
		super();
		this.name = name;
		this.age = age;
		this.birthday = birthday;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public MyDate1 getBirthday() {
		return birthday;
	}
	public void setBirthday(MyDate1 birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", birthday=" + birthday.toString() + "]";
	}
}

class MyDate1{
	private int year;
	private int month;
	private int day;
	
	public MyDate1() {
		super();
	}
	public MyDate1(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	@Override
	public String toString() {
		return "MyDate1 [year=" + year + ", month=" + month + ", day=" + day + "]";
	}
}