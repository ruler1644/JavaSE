package chaptor13_reflect;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;
public class Code_04_GetClassPart {
	//@Test
	public void testField() throws Exception {
		Class <Person> clazz = Person.class;
		Person p = clazz.newInstance();
		
		Field id = clazz.getDeclaredField("id");
		id.setAccessible(true);
		
		id.set(p,1001);
		System.out.println(id.get(p));
		System.out.println(p);
	}
	//@Test
	public void testStaticMethod() throws Exception {
		Class <Person> clazz = Person.class;
		Person p = clazz.newInstance();
		
		Method sayHello = clazz.getDeclaredMethod("sayHello");
		sayHello.setAccessible(true);
		
		sayHello.invoke(p);
		sayHello.invoke(Person.class);
		sayHello.invoke(null);
	}
	//@Test
	public void testMethod() throws Exception {
		Class <Person> clazz = Person.class;
		Person p = clazz.newInstance();
		
		Method show = clazz.getDeclaredMethod("show",String.class);
		show.setAccessible(true);
		
		show.invoke(p,"社会主义接班");
	}
	@Test
	public void testConstructor() throws Exception {
		Class <Person> clazz = Person.class;
		Person p = clazz.newInstance();
		
		Constructor cons = clazz.getDeclaredConstructor(String.class);
		cons.setAccessible(true);
		
		Object o = cons.newInstance("Jack Ma");
		System.out.println(o);
	}
}
