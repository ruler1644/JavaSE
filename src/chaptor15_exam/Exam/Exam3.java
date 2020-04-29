package chaptor15_exam.Exam;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.Test;

/*
14、把如下信息添加到Map中，并遍历显示，请正确指定泛型*/
public class Exam3 {
	@Test
	public void fun13() {
		List<String> al = new ArrayList<String>();
		al.add("hadoop");
		al.add("spark");
		al.add("java");
		al.add("python");
		al.add("c++");
		
		for (int i = 0; i < al.size(); i++) {
			if("java".equals(al.get(i))) {
				al.remove(i);
			}
		}
		System.out.println(al);
	}
	
	@Test
	public void fun14() {
		Map<String,String[]> map = new HashMap<>();
		
		String[] arrStr1 = new String[] {"绍兴市","温州市","湖州市","嘉兴市","台州市","金华市","舟山市","衢州市","丽水市"};
		map.put("浙江省", arrStr1);
		
		String[] arrStr2 = new String[] {"海口市","三亚市"};
		map.put("海南省", arrStr2);
		
		String[] arrStr3 = new String[] {"北京市"};
		map.put("北京市", arrStr3);
		
		/*//遍历key
		Set <String> keySet = map.keySet();
		for(String  tmp:keySet) {
			System.out.print(tmp+"   ");
		}
		System.out.println();
		
		//遍历values
		Collection<String[]> coll = map.values();
		for(String[] tmp:coll) {
			for (int i = 0; i < tmp.length; i++) {
				System.out.println(tmp[i]+"   ");
			}
			System.out.println();
		}*/
		
		//遍历Entry
		Iterator <Map.Entry<String,String[]>> it = map.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<String,String[]> entry =it.next();
			System.out.println(entry.getKey());
			String[] value = entry.getValue();
			for (int i = 0; i < value.length; i++) {
				System.out.println("\t"+value[i]);
			}		
		}	
	}
	@Test
	public void fun15() {
		
	}
	@Test
	public void fun16() throws IOException {
		Properties pros = new Properties();
		FileInputStream fis = new FileInputStream("properties.txt");
		pros.load(fis);
		String userName = pros.getProperty("username");
		System.out.println(userName);
	}
}
