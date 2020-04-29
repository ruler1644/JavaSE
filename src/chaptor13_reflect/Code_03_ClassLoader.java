package chaptor13_reflect;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

public class Code_03_ClassLoader {
	@Test
	public void test() throws IOException {
		Properties pros = new Properties(); 
		InputStream is = Code_03_ClassLoader.class.getClassLoader().getResourceAsStream("JDBC2.properties");
		
		pros.load(is);
		System.out.println(pros.getProperty("username"));
	}
}
