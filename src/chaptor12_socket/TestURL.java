package chaptor12_socket;
import java.io.*;
import java.net.*;
public class TestURL {
  public static void main(String[] args) throws Exception {
    String str="https://www.bilibili.com/video/av33773219?t=49";
    URL url=new URL(str);
    InputStream is=url.openStream();
    byte[] buf=new byte[1024];
    int len;
    
    FileOutputStream fos=new FileOutputStream(new File("1.mp4"));
    
    while((len=is.read(buf))!=-1) {
//      String s=new String(buf,0,len);
//      System.out.println(s);
      fos.write(buf, 0, len);
    }
  }
  
}
