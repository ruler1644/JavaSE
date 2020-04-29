package chaptor09_collection.com;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
//实现 Comparable 接口，并按 name升序，age降序,自然排序
public class Code_04_NatureOrder {

	public static void main(String[] args) {
		Employee[] arr = new Employee[9];
		
		arr[0] = new Employee("AA",32,new MyDate(1991,7,15));
		arr[1] = new Employee("AA",32,new MyDate(1991,7,15));
		arr[2] = new Employee("AA",31,new MyDate(1991,7,15));
		
		arr[3] = new Employee("AB",32,new MyDate(1991,7,15));
		arr[4] = new Employee("AB",32,new MyDate(1991,7,15));
		arr[5] = new Employee("AB",30,new MyDate(1991,7,15));
		
		arr[6] = new Employee("AC",42,new MyDate(1991,7,15));
		arr[7] = new Employee("AC",32,new MyDate(1991,7,15));
		arr[8] = new Employee("AC",32,new MyDate(1991,7,15));
		
		Set set = new TreeSet();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}
}
class Employee implements Comparable{
	private  String name;
	private int age;
	private MyDate birthday;
	
	public Employee() {
		super();
	}
	public Employee(String name, int age, MyDate birthday) {
		super();
		this.name = name;
		this.age = age;
		this.birthday = birthday;
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Employee) {
			Employee p1 = (Employee)o;
			int nameNum = this.name.compareTo(p1.name);
			if(nameNum != 0) {
				return nameNum;
			}else {
				int ageNum = this.age - p1.age;
				if(ageNum != 0) {
					return -ageNum;
				}
			}
		}
		return 0;
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
	public MyDate getBirthday() {
		return birthday;
	}
	public void setBirthday(MyDate birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", birthday=" + birthday + "]";
	}
}

class MyDate{
	private int year;
	private int month;
	private int day;
	
	public MyDate() {
		super();
	}
	public MyDate(int year, int month, int day) {
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
		return "MyDate [year=" + year + ", month=" + month + ", day=" + day + "]";
	}
}