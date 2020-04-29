package chaptor15_exam.Exam;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import org.junit.Test;
public class Exam4 {
	//@Test
	public void fun17() throws Exception {
		FileInputStream fis = new FileInputStream("D:\\develop\\MyWork\\gbk.txt");
		InputStreamReader isr = new InputStreamReader(fis,"gbk");
		
		FileOutputStream fos = new FileOutputStream("D:\\develop\\MyWork\\utf.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8");
		
		char[] buff = new char[512];
		int len = 0;
		while((len =isr.read(buff))!= -1) {
			osw.write(buff,0,len);
		}
		
		osw.close();
		isr.close();
	}
	@Test
	public void fun18() {
		NumThread numThread = new NumThread();
		Thread thread = new Thread(numThread);
		thread.start();
	}
}

class NumThread implements Runnable{
	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			System.out.println(i);
		}
	}
}
