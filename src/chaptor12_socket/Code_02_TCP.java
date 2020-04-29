package chaptor12_socket;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;
//客户端发送信息给服务端  服务端将数据显示在控制台上
public class Code_02_TCP {
	@Test
	public void Clint() throws Exception {
		InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
		Socket s = new Socket(inetAddress,8899);
		
		OutputStream os = s.getOutputStream();
		os.write("我是客户端，你好吗".getBytes());
		
		os.close();
		s.close();
	}
	@Test
	public void Server() throws Exception {
		ServerSocket ss = new ServerSocket(8899);
		Socket s = ss.accept();
		
		InputStream is = s.getInputStream();
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buff = new byte[64];
		int len = 0;
		while((len = is.read(buff)) != -1) {
			baos.write(buff,0,len);
		}
		
		String str = baos.toString();
		System.out.println("我是服务端，接收到来自"+s.getInetAddress().getHostName()+"的数据，内容是："+str);
		
		is.close();
		ss.close();
	}
	
	// 客户端发送文件给服务端  服务端将文件保存在本地
	@Test
	public void Clint2() throws Exception {
		Socket s = new Socket(InetAddress.getByName("127.0.0.1"),8899);
		OutputStream os = s.getOutputStream();
		FileInputStream fis = new FileInputStream("D:\\develop\\MyWork\\1.jpg");
		
		byte[] buff = new byte[512];
		int len = 0;
		while((len = fis.read(buff)) != -1) {
			os.write(buff, 0, len);
		}
		
		fis.close();
		os.close();
		s.close();
	}
	@Test
	public void Server2() throws Exception {
		ServerSocket ss = new ServerSocket(8899);
		Socket s = ss.accept();
		
		InputStream is = s.getInputStream();
		FileOutputStream fos = new FileOutputStream("D:/develop/MyWork/1_copy.jpg");
		
		byte[] buff = new byte[512];
		int len = 0;
		
		while((len = is.read(buff)) != -1) {
			fos.write(buff,0,len);
		}
		fos.close();
		is.close();
		ss.close();
	}
	
	//从客户端发送文件给服务端  服务端保存到本地   并返回 发送成功  给客户端 并关闭相应的连接
	@Test
	public void Clint3() throws Exception {
		Socket s = new Socket("127.0.0.1",8899);
		
		FileInputStream fis = new FileInputStream("D:\\develop\\MyWork\\1.jpg");
		OutputStream os = s.getOutputStream();
		
		byte[] buff = new byte[512];
		int len = 0;
		while((len = fis.read(buff)) != -1) {
			os.write(buff, 0, len);
		}
		//关闭数据的输出
	    s.shutdownOutput();
	    
	    //读取服务器回复内容
	    InputStream is = s.getInputStream();
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buff1 = new byte[512];
		int len1;
		while((len1 = is.read(buff1)) != -1) {
			baos.write(buff1, 0, len1);
		}
		System.out.println(baos.toString());
		fis.close();
		os.close();
		s.close();
	}
	@Test
	public void Server3() throws Exception {
		ServerSocket ss = new ServerSocket(8899);
		Socket s = ss.accept();
		
		FileOutputStream fos = new FileOutputStream("1_copy.jpg");
		InputStream is = s.getInputStream();
		
		byte[] buff = new byte[512];
		int len = 0;
		
		while((len = is.read(buff)) != -1) {
			fos.write(buff,0,len);
		}
		
		OutputStream os = s.getOutputStream();
		os.write("我是服务器，你发送成功了，我已接收到你发送文件".getBytes());
		
		fos.close();
		is.close();
		ss.close();
	}
}
