package chaptor13_reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class TestField {
  public static void main(String[]args) {
    Class clazz=Person.class;
    //获取运行时类的属性
    Field[] fields= clazz.getFields();
    for(int i=0;i<fields.length;i++) {
      System.out.println(fields[i]);
    }
    
    System.out.println();
    Field[] fields2= clazz.getDeclaredFields();
    for(Field f:fields2) {
      //1属性修饰符
      int i=f.getModifiers();
      String str=Modifier.toString(i);
      System.out.print(str+"  ");
      
      //2变量类型
      Class type=f.getType();
      System.out.print(type.getName()+"  ");
      
      //3属性名    
      System.out.println(f.getName());
    }
    
    
    
  }

}
