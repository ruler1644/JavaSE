package chaptor10_generic;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//在集合ArrayList中使用泛型
public class Code_01_UseInList {
	public static void main(String[] args) {
			List<Integer> al =new ArrayList<>();

			al.add(1);
			al.add(2);
			al.add(3);
			al.add(4);
			al.add(5);
			al.add(6);
			al.add(7);
			al.add(0,8);
			
			for(Integer tmp:al) {
				System.out.print(tmp+"  ");
			}
			System.out.println();
			
			Iterator<Integer> iterator = al.iterator();
			while(iterator.hasNext()) {
				System.out.print(iterator.next()+"  ");
			}
			System.out.println();
	}
}
