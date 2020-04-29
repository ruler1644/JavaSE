package chaptor13_reflect;
@MyAnnotation(value="atguigu")
public class Person extends Creature<String> implements Comparable,MyInterface {
  public String name;
  private int age;
  int id;
  public Person() {
    super();
    System.out.println("空参构造器");
  }
  private Person(String name, int age) {
    super();
    this.name = name;
    this.age = age;
  }
  
  @MyAnnotation(value="show方法")
  public void show() {
    System.out.println("show方法被调用：对不起，我是警察");
  }
  private Integer disPlay(String nation,Integer i) throws Exception {
    System.out.println("我的国籍是："+nation);
    return i;
  }
  
  class Bird{
    
  }
  
  public Person(String name) {
    super();
    this.name = name;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  @Override
  public String toString() {
    return "Person [name=" + name + ", age=" + age + "]";
  }
  @Override
  public int compareTo(Object arg0) {
    // TODO Auto-generated method stub
    return 0;
  }
  public static void info() {
    System.out.println("static方法：中国人");
  }

}
