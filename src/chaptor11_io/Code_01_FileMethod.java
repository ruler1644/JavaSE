package chaptor11_io;
import java.io.File;
import java.io.IOException;
//File类用法及其常用方法
public class Code_01_FileMethod {
	public static void main(String[] args) throws IOException {
		
		//---------------------------------------------
		//File file2 = new File(parentPath,"aa.txt");
		//File file1 = new File("D:/develop/hello.txt");
/*		File file1 = new File("D:\\develop\\MyWork\\hello.txt");
		
		//1 getAbsolutePath()
		String fileAusolutePath = file1.getAbsolutePath();
		System.out.println(fileAusolutePath);
		//2 getPath()
		String filePath = file1.getPath();
		System.out.println(filePath);
		//3 getParent()
		String parentPath = file1.getParent();
		System.out.println(parentPath);
		//4 getName()
		String fileName = file1.getName();
		System.out.println(fileName);
		//5 length()
		long fileLength = file1.length();
		System.out.println(fileLength);
		//6 lastModified
		long time = file1.lastModified();
		System.out.println(time);

		//---------------------------------------------
		File f = new File("D:\\develop\\MyWork");
		String[] arr = f.list();
		for(String tmp:arr) {
			System.out.println(tmp);
		}
		System.out.println();
		File[] files = f.listFiles();
		for(File Tmp:files) {
			System.out.println(Tmp);
		}
*/	
		//------------------------------使用相对路径-----------
		File file2 = new File("hello.txt");
		//1 getParent()
		String parentPath2 = file2.getParent();
		System.out.println(parentPath2);
		//2 getAbsolutePath()
		String fileAusolutePath2 = file2.getAbsolutePath();
		System.out.println(fileAusolutePath2);
		//3getAbsoluteFile()
		File fileAusoluteFile2 = file2.getAbsoluteFile().getParentFile();
		System.out.println(fileAusoluteFile2);
		
		//4 createNewFile()
		File f = new File(fileAusoluteFile2,"aa.txt");
		if(!f.exists()) {
			f.createNewFile();
		}else {
			f.delete();
			System.out.println("文件已删除");
		}
		
		//5 renameTo()
		File f11 = new File("hello.txt");
		File f22 = new File("hello_copy.txt");
		f11.renameTo(f22);	
	}
}
