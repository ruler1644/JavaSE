package chaptor09_collection.com;
//读取Properties属性文件
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class Code_09_Properties {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("JDBC.properties");
		Properties p = new Properties();
		p.load(fis);
		
		String name = p.getProperty("name");
		String password = p.getProperty("password");
		
		System.out.println("name ="+name);
		System.out.println("password ="+password);
	}
}
