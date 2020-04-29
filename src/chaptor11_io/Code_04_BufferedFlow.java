package chaptor11_io;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
//缓冲流复制音频文件
public class Code_04_BufferedFlow {
	public static void main(String[] args) throws Exception {
		String src= "D:\\develop\\MyWork\\11.avi";
		String dest = "D:/develop/MyWork/11_Buffered_copy.avi";
		
		String src2= "dbcp.txt";
		String dest2 = "dbcp_copy.txt";
		
		
		long start = System.currentTimeMillis();
		//copyByBufferedByte(src,dest);//355
		copyByBufferedChar(src2,dest2);
		long end = System.currentTimeMillis();
		System.out.println("复制需要时间："+(end - start));
	}
	public static void copyByBufferedByte(String src,String dest) throws Exception {
		FileInputStream fis = new FileInputStream(src);
		FileOutputStream fos = new FileOutputStream(dest);
		
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		byte[] buff = new byte[1024];
		int len = 0;
		while((len = (bis.read(buff))) != -1) {
			bos.write(buff, 0, len);
		}
		
		bis.close();
		bos.close();
	}
	public static void copyByBufferedChar(String src,String dest) throws Exception {
		FileReader fr = new FileReader(src);
		FileWriter fw = new FileWriter(dest);
		
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw= new BufferedWriter(fw);
		
		char[] buff = new char[128];
		int len = 0;
		while((len = (br.read(buff))) != -1) {
			bw.write(buff, 0, len);
		}
		
		bw.close();
		br.close();
	}
}
