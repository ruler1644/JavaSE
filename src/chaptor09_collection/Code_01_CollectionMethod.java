package chaptor09_collection;

import org.junit.Test;

import java.util.*;

//测试Collection接口中声明的方法
public class Code_01_CollectionMethod {
    @Test
    public void test1() {
        Collection collection = new ArrayList();

        //1 add()
        collection.add(1);
        collection.add("AA");
        collection.add(86.5);
        collection.add(12);

        ArrayList coll = new ArrayList();
        coll.add(43);
        coll.add(111);
        //2 addAll()
        collection.addAll(coll);
        System.out.println(collection);

        //3 size()
        System.out.println(collection.size());

        //4 isEmpty()
        System.out.println(collection.isEmpty());

        //5 clear()
        collection.clear();
        System.out.println(collection.size());

        //6 contains()
        //contains(),先调用indexOf()遍历集合,通过equals()找到第一个相同的对象，就返回下标，结束方法
        System.out.println(collection.contains(12));


        Collection coll2 = Arrays.asList(43, 12);
        coll2.add(234);     //此种方式创建的集合只能读，不能再添加对象,UnsupportedOperationException

        //7 containsAll()
        System.out.println("777777" + collection.containsAll(coll2));
    }


    @Test
    public void test2() {
        Collection collection = new ArrayList();

        collection.add(43);
        collection.add("AA");
        collection.add(111);
        collection.add(86.5);
        collection.add(12);
        System.out.println(collection);


        //8 remove()
        //System.out.println(collection.remove(111));

        //9 removeAll()
        /*Collection coll3 = Arrays.asList(43, 111);
        System.out.println(collection.removeAll(coll3));*/

        //10 retain()
        /*Collection coll4 = Arrays.asList(43, 111);
        collection.retainAll(coll4);
        System.out.println(collection);*/

        //11 equals()
        /*Collection coll5 = Arrays.asList(43, 1111);
        Collection coll6 = Arrays.asList(43, 1111);
        Collection coll7 = Arrays.asList(1111, 43);
        System.out.println(coll5.equals(coll6));
        System.out.println(coll5.equals(coll7));*/


        // 12hashCode()
        //System.out.println(collection.hashCode());

        // 13toArray()
        Object[] arr = collection.toArray();
        for (Object tmp : arr) {
            System.out.print(tmp + "\t");
        }

        System.out.println("*****************");

        List list = Arrays.asList(new String[]{"43", "AAA"});
        System.out.println(list);


    }

    @Test
    public void test3() {
        Collection collection = new ArrayList();
        collection.add(43);
        collection.add("AA");
        collection.add(111);
        collection.add(86.5);
        collection.add(12);

        //iterator 与for循环比较
        for (Object tmp : collection) {
            System.out.print(tmp + "\t");
        }
        System.out.println();

        // 14 remove
        Iterator it1 = collection.iterator();
        while (it1.hasNext()) {
            Object next = it1.next();
            if ("AA".equals(next)) {
                it1.remove();
            }
        }

        //iterator()
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + "\t");
        }
    }
}
