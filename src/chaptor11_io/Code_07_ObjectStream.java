package chaptor11_io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//对象流及序列化机制
public class Code_07_ObjectStream {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		//序列化
		FileOutputStream fos = new FileOutputStream("object.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(new Person());
		oos.writeObject("AAA");

		//反序列化
		FileInputStream fis = new FileInputStream("object.txt");
		ObjectInputStream ois = new ObjectInputStream(fis); 
		//当初写出数据的顺序就是现在读取数据的顺序
		Object val = ois.readObject();
		Object str = ois.readObject();
		System.out.println(val);
		System.out.println(str);
		
		//关闭资源---
	}

}
class Person implements Serializable{
	
}