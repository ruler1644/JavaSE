package chaptor13_reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestUseMethod {
  public static void main(String[]args) throws Exception {
    
    Class clazz=Person.class;
    //1公共方法  返回值void 无形参
    Method show= clazz.getMethod("show");
    Person p2=(Person)clazz.newInstance();
    Object returnVal=show.invoke(p2);
    System.out.println(returnVal);
    
    //2公共方法  返回值String 无形参
    Method toString= clazz.getMethod("toString");
    Object returnVal2=toString.invoke(p2);
    System.out.println(returnVal2);
    
    //3static方法   返回值void  无形参
    Method info= clazz.getMethod("info");
    Object returnVal3=info.invoke(Person.class);
    System.out.println(returnVal3);
    
    //4所有声明的方法  返回值String 无形参
    Method disPaly= clazz.getDeclaredMethod("disPlay", String.class,Integer.class);
    disPaly.setAccessible(true);
    Object returnVal4=disPaly.invoke(p2, "香港",36);
    System.out.println(returnVal4);
  }
}
