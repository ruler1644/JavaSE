package chaptor13_reflect;

import java.lang.reflect.Constructor;

public class TestConstructor {
  public static void main(String[]args) {
    Class clazz=Person.class;
    //获取运行时类的构造器
    Constructor[] cons=clazz.getDeclaredConstructors();
    for(Constructor c:cons) {
      System.out.println(c);
    }
  }
}
