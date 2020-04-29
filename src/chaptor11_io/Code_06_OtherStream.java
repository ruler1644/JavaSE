package chaptor11_io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;


public class Code_06_OtherStream {
	public static void main(String[] args) throws IOException {
/*		
		//----------------------打印流
		FileOutputStream fos = new FileOutputStream("print.txt");
		//// 创建打印输出流,设置为自动刷新模式(写入换行符或字节 '\n'时都会刷新输出缓冲区)
		PrintStream ps = new PrintStream(fos,true);
		System.setOut(ps);
		System.out.println("abcde");
*/	
		//----------------------数据流
		FileOutputStream fos2 = new FileOutputStream("data.txt");
		DataOutputStream dos = new DataOutputStream(fos2);
		dos.writeInt(121);
		dos.writeUTF("我是数据流");
		
		FileInputStream fis = new FileInputStream("data.txt");
		DataInputStream dis = new DataInputStream(fis); 
		int val = dis.readInt();
		String str = dis.readUTF();
		System.out.println(val);
		System.out.println(str);
		
		//关闭资源
	}

}
