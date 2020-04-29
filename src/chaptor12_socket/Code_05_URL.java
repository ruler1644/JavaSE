package chaptor12_socket;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

public class Code_05_URL {
	@Test
	public void test() throws MalformedURLException {
		URL url = new URL("http://www.sohu.com/a/289188117_100258766");
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getPort());
		System.out.println(url.getPath());
		System.out.println(url.getFile());
		System.out.println(url.getQuery());
	}
	
	//1.创建URL
	//2.获取连接对象
	//3.建立连接
	//4.获取连接中的输入流
	//5.读取输入流中的数据，并保存到本地文件中
	@Test
	public void test2() throws IOException {
		URL url = new URL("http://www.sohu.com/a/289188117_100258766");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.connect();
		
		InputStream is = connection.getInputStream();
		OutputStream os= new FileOutputStream("D:\\develop\\MyWork\\aa.doc");
		
		byte[] buff = new byte[1024];
		int len = 0;
		while((len = is.read(buff)) != -1){
			os.write(buff, 0, len);
		}
		
		System.out.println("传输完毕");
		os.close();
		is.close();
		connection.disconnect();
	}
}

