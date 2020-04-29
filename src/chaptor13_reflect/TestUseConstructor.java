package chaptor13_reflect;

import java.lang.reflect.Constructor;

public class TestUseConstructor {
  public static void main(String[]args) throws Exception {
    Class clazz=Person.class;
    //获取运行时类的制定的构造器，使用它创建对象
    Constructor con=clazz.getDeclaredConstructor(String.class,int.class);
    con.setAccessible(true);
    Person p=(Person)con.newInstance("汤唯",36);
    System.out.println(p);

  }
}
