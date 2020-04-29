package chaptor10_generic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
//泛型与继承的关系
public class Code_04_GennericAndExtends {
	public static void main(String[] args) {
/*		
		//-----------------1111111111-------------------
		List<Object> list1 = new ArrayList();
		List<String> list2 = new ArrayList();
		//编译错误，
		//反证法：若存在子类父类关系，则构成多态引用，list1调用add方法可以添加Integer,Object,等等
		//但是，list1当前实际指向list2，list2使用了泛型，只能添加String型对象，造成冲突，泛型失效
		//所以，list1与list2之间没有子类父类关系，他们是并列关系
		//list1 = list2;
		
		//----------------2222222222222-----------------
		Object[] arr1 = new Object[4];;
		String[] arr2 = new String[4];
		//arr1 = arr;这句话构成多态引用
		//数组arr1声明存储的是Object，但实际存储的是Sting，构成多态数组
		//但是，之后再添加元素时只能是String型的了
		arr1 = arr2;
		arr1[0] = "12";
		//arr1[1] = 12;
		//编译时看左边，是Object型，运行时看右边实际是String型
		for(Object tmp:arr1) {
			System.out.println(tmp);
		}
*/
		//--------------------333333333333333--------------
		Collection <String> coll = null;
		List<String> list = Arrays.asList("12","AA","aa"," ","65");
		coll = list;
		for(String str:coll) {
			System.out.println(str);
		}
	}
}
