//package chaptor13_reflect;
////动态代理(反射是动态语言的关键)
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//
//public class TestProxy2{
//  public static void main(String[] args) {
//    //1创建被代理对象
//    RealSubject real=new RealSubject();
//
//    //2创建实现Invocation接口的实例对象
//    MyInvocationHandler handler=new MyInvocationHandler();
//
//    //3调用blind()方法,动态返回一个实现了，被代理对象real所在类实现的接口，的代理类的对象
//    Object obj=handler.blind(real);
//    Subject sub=(Subject)obj;    //sub就是代理对象
//
//    //Object returnVal=subject.action();
//    //转为Invocation接口实现类重写的invoke()方法的调用
//    sub.action();
//
//
//
//    NikeFactory Nike1=new NikeFactory();
//    ClothFactory proxy1=(ClothFactory)handler.blind(Nike1);
//    proxy1.product();
//
//
//  }
//}
//
////动态代理
//interface Subject{
//  void action();
//}
//
//
//class RealSubject implements Subject{
//  @Override
//  public void action() {
//    System.out.println("我是被代理类,我开始执行");
//  }
//}
//
//class MyInvocationHandler implements InvocationHandler{
//  //实现了接口的，被代理类的声明
//  Object obj=null;
//  //实例化被代理类对象
//  //返回一个代理类的的对象
//  public Object blind(Object obj) {
//    this.obj=obj;
//    return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
//        obj.getClass().getInterfaces(),this);
//  }
//
//  //当通过代理类的对象，发起对被重写的方法的调用时，会转化为对invoke()方法的调用
//  @Override
//  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//    Object returnval=method.invoke(obj, args);
//    return returnval;
//  }
//
//}