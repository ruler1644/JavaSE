package chaptor11_io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//使用字符流，实现文本文件的复制
public class Code_03_CopyText {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("D:hello.txt");
		FileWriter fw = new FileWriter("D:12.txt");
		
		char[] buff =new char[5];
		int len = 0;
		
		while((len = fr.read(buff)) != -1){
			fw.write(buff, 0, len);
		}
		//System.out.println("成功复制文档");
		fw.close();
		fr.close();
	}

}
