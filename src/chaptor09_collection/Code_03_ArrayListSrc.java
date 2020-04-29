package chaptor09_collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

//ArrayList源码分析
public class Code_03_ArrayListSrc {
    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList();
        LinkedList<Object> objects = new LinkedList<>();
        objects.add(79);

        Vector<Object> vector = new Vector<>();
        vector.add(23);
    }
}
