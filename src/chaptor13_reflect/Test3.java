package chaptor13_reflect;
import java.lang.reflect.*;
public class Test3 
{
	public static void main(String[]args)
	{
		Gen<Bird2> gen=new Gen<Bird2>(new Bird2());
		gen.getName();
		gen.getMethodNmae();
	}
}

class Bird2
{
	public void test1()
	{
		System.out.println("hello world");
	}
	
	public int add(int a,int b)
	{
		return a+b;
	}
}

class Gen<T>
{
	private T a;
	public Gen(T o)
	{
		this.a=o;
	}
	public void getName()
	{
		String name=a.getClass().getName();
		System.out.println(name);
	}
	public void getMethodNmae()
	{
		Method[] arr=a.getClass().getDeclaredMethods();
		for(int i=0;i<arr.length;++i)
		{
			String name=arr[i].getName();
			System.out.println(name);
		}	
	}
}