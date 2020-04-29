package chaptor13_reflect;

import java.lang.reflect.Field;

public class TestUseField {
  public static void main(String[]args) throws NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException {
    Class clazz=Person.class;
    //1获取属性
    Field name= clazz.getField("name");
    //2创建运行时类的对象
    Person per=(Person)clazz.newInstance();
    System.out.println(per);
    //3为运行时类指定的属性赋值
    name.set(per, "汤唯");
    System.out.println(per);
    
    
    //Field age= clazz.getField("age");
    Field age= clazz.getDeclaredField("age");
    age.setAccessible(true);
    age.set(per, 36);
    System.out.println(per);
    
    

  }
}
