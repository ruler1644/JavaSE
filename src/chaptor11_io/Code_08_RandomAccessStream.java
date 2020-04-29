package chaptor11_io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

//使用随机存取文件流，在hello与world之间插入xyz
public class Code_08_RandomAccessStream {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf1 = new RandomAccessFile("random.txt", "r");
		RandomAccessFile raf2 = new RandomAccessFile("ramdom_copy.txt","rw");
		
//		byte[] buff = new byte[512];
//		int len = 0;
//		while((len = raf1.read(buff))!= -1) {
//			/*String str = new String(buff,0,len);
//			System.out.println(str);*/
//			raf2.write(buff,0,len);
//		}
		raf2.seek(5);
		
		byte[] buff =new byte[5];
		int len = 0;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		while((len = raf2.read(buff)) != -1){
			baos.write(buff, 0, len);
		}
		
		raf2.seek(5);
		raf2.write("xyz".getBytes());
		//raf2.write(strbu.toString().getBytes());
		raf2.write(baos.toByteArray());
		raf2.close();
		
	}
}
