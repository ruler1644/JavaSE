import java.io.*;
import java.lang.reflect.Field;

public class MyClassLoader extends ClassLoader {

    //类加载器的名字
    private String name;
    //类加载器路径
    private String path = "d:";
    //后缀
    private final String suffix = ".class";


    public MyClassLoader(String name) {

        //让系统加载器，成为该加载器的父加载器
        super();
        this.name = name;
    }

    public MyClassLoader(ClassLoader parent, String name) {

        //显式指定该加载器，的父加载器
        super(parent);
        this.name = name;
    }

    //据类的名字得到类的二进制字节数组
    private byte[] loadClassData(String name) {


        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;

        this.name = this.name.replace(".", "\\");
        System.out.println("==========>" + path + name + suffix);

        try {

            //com.java.CommonClass.Trim---->com\java\CommonClass\Trim
            is = new FileInputStream(new File(path + name + suffix));
            baos = new ByteArrayOutputStream();
            int ch = 0;

            while ((ch = is.read()) != -1) {
                baos.write(ch);
            }
            data = baos.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return data;
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = this.loadClassData(name);

        //将字节数转换为class实例
        return this.defineClass(name, data, 0, data.length);
    }

    public static void main(String[] args) throws Exception {

        MyClassLoader loader1 = new MyClassLoader("loader1");
        loader1.setPath("D:\\myapp\\serverlib\\");

        //loader1是loader2的父加载器
        MyClassLoader loader2 = new MyClassLoader(loader1, "loader2");
        loader2.setPath("D:\\myapp\\clientlib\\");

        //一
//        //loader3的父加载器是null，说明它的父加载器是根加载器
//        MyClassLoader loader3 = new MyClassLoader(null, "loader3");
//        loader3.setPath("D:\\myapp\\otherlib\\");
//
//        test(loader2);
//        test(loader3);

        //二  直接强转错误，加载器不同
//        Class clazz = loader1.loadClass("Sample");
//        Object o = clazz.newInstance();
//        Sample sample = (Sample) o;
//
//        System.out.println(sample.v);


        //三
//         创建Sample类的对象
//        Class clazz = loader1.loadClass("Sample");
//        Object obj = clazz.newInstance();
//
//        Field field = clazz.getField("v1");
//        int v1 = field.getInt(obj);
//
//        System.out.println(v1);

        //四 卸载类
        Class clazz = loader1.loadClass("Sample");
        System.out.println(clazz.hashCode());
        Object obj = clazz.newInstance();

        loader1 = null;
        clazz = null;
        obj = null;

        loader1 = new MyClassLoader("loader1");
        loader1.setPath("D:\\myapp\\serverlib\\");
        clazz = loader1.loadClass("Sample");
        System.out.println(clazz.hashCode());

        //类没有被卸载，只会加载一次，不会重复加载
        Class clazz2 = loader1.loadClass("Sample");
        System.out.println(clazz == clazz2);


    }

    public static void test(ClassLoader loader) throws Exception {
        Class<?> clazz = loader.loadClass("Sample");
        Object obj = clazz.newInstance();
    }


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return this.name;
    }
}