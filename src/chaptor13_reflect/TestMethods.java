package chaptor13_reflect;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestMethods {
  public static void main(String[]args) {
    Class clazz=Person.class;
    //获取运行时类的方法
//    Method[] arr= clazz.getMethods();
//    for(Method m:arr) {
//      System.out.println(m);
//    } 
    
    Method[] arr1= clazz.getDeclaredMethods();
    for(Method m:arr1) {   
      //1注解
      Annotation[] ann=m.getAnnotations();
      for(Annotation a:ann) {
        System.out.println(a);
      }
      //2权限修饰符
      String str=Modifier.toString(m.getModifiers());
      System.out.print(str+"  ");
      //3返回值类型
      Class returntype=m.getReturnType();
      System.out.print(returntype.getName()+"  ");
      //4形参列表
      System.out.print("(");
      Class[] paras=m.getParameterTypes();
      for(int i=0;i<paras.length;++i) {
        System.out.print(paras[i].getName()+"  args"+i+" ");
      }
      System.out.print(")");
      //5方法名
      System.out.print(" "+m.getName());
      //6异常列表
      Class[] exceps=m.getExceptionTypes();
      if(exceps.length!=0) {
        System.out.print(" throws");
      }
      for(int i=0;i<exceps.length;++i) {
        System.out.print(" "+exceps[i].getName()+" ");       
      }
      System.out.println();
    }
  }
}
