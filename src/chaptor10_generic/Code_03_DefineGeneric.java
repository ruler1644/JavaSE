package chaptor10_generic;
import java.util.ArrayList;
import java.util.List;
//自定义泛型类  泛型接口  泛型方法
public class Code_03_DefineGeneric {
	public static void main(String[] args) {
		Order <String> order = new Order<String>();
		order.e = "AAA";
		System.out.println(order.e);
		System.out.println(order.getE());
		
		Integer[] array = new Integer[] {1,3,4,2,7,3};
		List <Integer> list = Order.copyFromArrayToList(array);
		for(Integer tmp:list) {
			System.out.print(tmp+"  ");
		}
	}
}

//E是类的泛型参数
class Order <E> extends Object{
	String name;
	int id;
	E e;
	
	//使用泛型的类   构造器不需要带泛型
	public Order (String name,int id,E e) {
		super();
		this.name = name;
		this.id = id;
		this.e = e;
	}
	
	//不能创建泛型数组 只能通过强转的方式获取泛型数组
	public Order() {
		//E[] arr = new E[6];
		E[] arr =(E[])new Object[6];
	}
	
	//不能在静态方法中使用类的泛型参数， 因为对象创建时，才指明泛型参数的具体类型
	//而静态结构的加载早于对象的创建
	/*public static E getE() {
		return e;
	}*/
	
	//此方法只是用到了类的泛型参数，不是泛型方法
	public E getE() {
		return e;
	}
	
	//泛型方法    泛型类型声明在方法返回值前
	public static <T> List<T> copyFromArrayToList(T[]arr) {
		List<T> list = new ArrayList<T>();
		for(T tmp:arr) {
			list.add(tmp);
		}
		return list;
	}
}