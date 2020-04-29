//package chaptor13_reflect;
//
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//
//public class TestAop {
//  public static void main(String[]args) {
//    //1创建被代理类对象
//    SuperMan  man=new SuperMan();
//    //2返回一个代理类对象
//    Object obj=MyProxy.getProxyInstance(man);
//    Human hm=(Human)obj;
//    hm.info();
//    System.out.println();
//    hm.fly();
//  }
//}
//
//
//interface Human{
//  void info();
//  void fly();
//}
//
////被代理类
//class SuperMan implements Human{
//  @Override
//  public void info() {
//   System.out.println("我是超人");
//  }
//  @Override
//  public void fly() {
//    System.out.println("我会飞");
//  }
//
//}
//
//class HumanUtil{
//  public void method1() {
//    System.out.println("method1");
//  }
//  public void method2() {
//    System.out.println("method2");
//  }
//}
//
////代理类
//class MyInvocationHandler1 implements InvocationHandler{
//  Object obj;
//  public void setObject(Object obj) {
//    this.obj=obj;
//  }
//  @Override
//  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//    HumanUtil hu=new HumanUtil();
//    hu.method1();
//    Object returnVal=method.invoke(obj);
//    hu.method2();
//    return returnVal;
//  }
//}
//
////动态的创建一个代理类对象
//class MyProxy{
//  public static Object getProxyInstance(Object obj) {
//    MyInvocationHandler1 handler=new MyInvocationHandler1();
//    handler.setObject(obj);
//    return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
//        obj.getClass().getInterfaces(),handler);
//
//  }
//}
