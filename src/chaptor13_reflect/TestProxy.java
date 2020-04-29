//package chaptor13_reflect;
//public class TestProxy{
//  public static void main(String[] args) {
//    NikeFactory nike=new NikeFactory();
//    ProxyFactory proxy=new ProxyFactory(nike);
//    proxy.product();
//  }
//}
////静态代理模式
//interface ClothFactory{
//  void product();
//}
//
////被代理类
//class NikeFactory implements ClothFactory {
//  @Override
//  public void product() {
//    System.out.println("Nike生产服装");
//  }
//}
//
////代理类
//class ProxyFactory implements ClothFactory{
//  ClothFactory cf=null;
//
//  //创建代理类时，实际上传入的是被代理类对象
//  public ProxyFactory(ClothFactory cf){
//    this.cf=cf;
//  }
//  @Override
//  public void product() {
//    System.out.println("代理类开始执行");
//    cf.product();
//  }
//}
