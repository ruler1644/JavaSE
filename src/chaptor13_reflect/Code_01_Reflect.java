package chaptor13_reflect;

//使用反射创建对象
public class Code_01_Reflect {
    public static void main(String[] args) throws Exception {
        Class<Person> clazz = Person.class;
        Person p = clazz.newInstance();
        System.out.println(p);
    }

}