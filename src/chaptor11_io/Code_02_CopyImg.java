package chaptor11_io;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
//使用字节流，实现图片的复制
public class Code_02_CopyImg {
	public static void main(String[] args) throws IOException {
		File file1 = new File("1.jpg");
		File file2 = new File("2.jpg");
		
		FileInputStream fis = new FileInputStream(file1);
		FileOutputStream fos = new FileOutputStream(file2);
		
		byte[] buff = new byte[512];
		int len = 0;
		while((len = fis.read(buff)) != -1) {
			fos.write(buff, 0, len);
		}
		
		fos.close();
		fis.close();
	}
}
