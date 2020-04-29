package chaptor12_socket;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestTcpServer3 {

  public static void main(String[] args){
    ServerSocket ss=null;
    Socket s=null;
    InputStream is=null;
    OutputStream os=null;
    FileOutputStream fos=null;
    try {
      ss=new ServerSocket(9090);
      System.out.println("我在9090端口等待来连接");
      s=ss.accept();
      is=s.getInputStream();
      byte[] buf=new byte[1024];
      int len=0;
      
      fos=new FileOutputStream(new File("2222222.jpg")); 
      
      while((len=is.read(buf))!=-1) {
        fos.write(buf,0,len);
      }
      
      os=s.getOutputStream();
      os.write("我是服务端，已收到你发送的文件".getBytes());
      s.shutdownOutput();
    } catch (Exception e) {
      e.printStackTrace();
    }finally {
      try {
        if(is!=null) {
          is.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        if(is!=null) {
          s.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
