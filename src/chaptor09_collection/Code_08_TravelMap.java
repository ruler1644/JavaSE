package chaptor09_collection;

import java.util.*;

//遍历HashMap的Key  value  Entry
public class Code_08_TravelMap {
    public static void main(String[] args) {
        HashMap hm1 = new HashMap();
        LinkedHashMap hm = new LinkedHashMap();
        hm.put("张三", 86);
        hm.put("李斯", 66);
        hm.put("AA", 34);
        hm.put("BA", 96);
        hm.put("AAA", 84);

        System.out.println("-------增强for循环遍历Key-------");
        Set keySet = hm.keySet();
        for (Object tmp : keySet) {
            System.out.println(tmp + "---->" + hm.get(tmp));
        }

        System.out.println("-------迭代器遍历Key-------------");
//		Set set = hm.keySet();
//		Iterator it = set.iterator();
        Iterator keyIterator = hm.keySet().iterator();
        while (keyIterator.hasNext()) {
            Object key = keyIterator.next();
            System.out.println(key + "---->" + hm.get(key));
        }

        System.out.println("--------增强for循环遍历Value--------");
        Collection collection = hm.values();
        for (Object tmp : collection) {
            System.out.print(tmp + "  ");
        }
        System.out.println();

        System.out.println("--------迭代器遍历Value-------------");
        Iterator valueIterator = collection.iterator();
        while (valueIterator.hasNext()) {
            System.out.print(valueIterator.next() + "  ");
        }
        System.out.println();

        System.out.println("-------增强for循环遍历Entry----------");
        Set entrySet = hm.entrySet();
        for (Object tmp : entrySet) {
            Map.Entry entry = (Map.Entry) tmp;
            System.out.println(entry.getKey() + "---->" + entry.getValue());
        }

        System.out.println("-------增强for循环遍历Entry------------");
//		Set entrySet = hm.entrySet();
//		Iterator Iterator = entrySet.iterator();
        Iterator entryIterator = hm.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry entry = (Map.Entry) entryIterator.next();
            System.out.println(entry.getKey() + "---->" + entry.getValue());
        }


    }

}
