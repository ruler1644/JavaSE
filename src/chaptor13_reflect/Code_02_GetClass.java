package chaptor13_reflect;

import org.junit.Test;

//获取Class实例的四种方式
public class Code_02_GetClass {
    @Test
    public void test() throws InstantiationException, IllegalAccessException, ClassNotFoundException {

        //1
        Class clazz1 = Person.class;
        //Object p = clazz1.newInstance();

        //2
        Person p2 = new Person();
        Class clazz2 = p2.getClass();

        //3
        String path = "domain.Person";
        Class clazz3 = Class.forName(path);

        //4
        ClassLoader loader = Code_02_GetClass.class.getClassLoader();
        Class clazz4 = loader.loadClass(path);

        System.out.println(clazz1);
        System.out.println(clazz2);
        System.out.println(clazz3);
        System.out.println(clazz4);

        int[] arr1 = new int[10];
        int[] arr2 = new int[15];
        Class clazzArr1 = arr1.getClass();
        Class clazzArr2 = arr2.getClass();

        System.out.println(clazzArr1);
        System.out.println(clazzArr2);

        int[][] arr3 = new int[15][];
        Class clazzArr3 = arr3.getClass();
        System.out.println(clazzArr3);


    }
}
