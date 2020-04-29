package chaptor15_exam.Exam3;

import org.junit.Test;

import java.util.HashMap;

public class MyInteger {

    @Test
    public void test() {
        HashMap hm = new HashMap();
        for (int i = 0; i < 10; i++) {
            hm.put(new MyInteger(), 1);
        }
        hm.put(new MyInteger(), 1);

    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Test
    public void test2() {
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;

        //false
        System.out.println(s1 == s2);
        //true
        System.out.println(s1 == s5);
        //false
        System.out.println(s1 == s6);
        //true
        System.out.println(s1 == s6.intern());
        //false
        System.out.println(s2 == s6);
    }

    @Test
    public void test3() {
        String s1 = new StringBuilder("go").append("od").toString();
        System.out.println(s1.intern() == s1);
        String s2 = new StringBuilder("ja").append("va").toString();
        System.out.println(s2.intern() == s2);



    }


}
class Test22
{
    static synchronized  void sayHello3(){

    }

    synchronized void getX(){}
}