package chaptor11_io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//转换流拷贝文本文件
public class Code_05_TransferFlow {
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("dbcp.txt");
		FileOutputStream fos = new FileOutputStream("dbcp_Transfer.txt");
		
		InputStreamReader isr = new InputStreamReader(fis,"utf-8");
		OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8");
		
		long start = System.currentTimeMillis();
		char[] buff =new char[1024];
		int len = 0;
		while((len = isr.read(buff))!= -1){
			osw.write(buff, 0, len);
		}
		osw.close();
		isr.close();
		
		long end = System.currentTimeMillis();
		System.out.println("复制需要时间："+(end - start));//3384
		
	
	}

}
