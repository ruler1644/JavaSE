package chaptor10_generic;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
//在集合HashMap中使用泛型
public class Code_02_UseInMap {
	public static void main(String[] args) {
		Map <String,Integer> hm =new HashMap<>();
			
		hm.put("Jack Ma",88);
		hm.put("Robbin Li",67);
		hm.put("Pony", 74);
		
		Set <Map.Entry<String,Integer>> entrySet = hm.entrySet();
		for(Map.Entry<String,Integer> tmp:entrySet) {
			System.out.println(tmp+"  ");
		}
		System.out.println();
		
		Iterator<Map.Entry<String,Integer>> iterator = hm.entrySet().iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next()+"  ");
		}
		System.out.println();
	}
}
