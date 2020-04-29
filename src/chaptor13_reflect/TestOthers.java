package chaptor13_reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TestOthers {
  public static void main(String[]args) {
    Class clazz=Person.class;
    
    //1获取运行时类的父类
    Class superClass=clazz.getSuperclass();
    System.out.println(superClass);
      
    //2获取运行时类的带泛型的父类
    Type superClass2=clazz.getGenericSuperclass();
    System.out.println(superClass2);
      //获取父类的泛型
      ParameterizedType param=(ParameterizedType)superClass2;
      Type[] args1=param.getActualTypeArguments();
      System.out.println(((Class)args1[0]).getName());
    
    
    //3获取运行时类实现的接口
    Class[] inters=clazz.getInterfaces();
    for(Class in:inters) {
      System.out.println(in);
    }
    
    
    //4获取运行时类所在的包
    Package pack=clazz.getPackage();
    System.out.println(pack);
    
    
    //5获取运行时类的注解
    Annotation[] ans=clazz.getAnnotations();
    for(Annotation a:ans) {
      System.out.println(a);
    }      
  }
}
