package chaptor12_socket;
import java.io.*;
import java.net.*;

public class TestTcpClient3 {
  public static void main(String[] args) {
    Socket socket=null;
    OutputStream os=null;
    InputStream is=null;
    FileInputStream fis=null;
    try {      
      fis=new FileInputStream(new File("1.jpg"));
      byte[] buf=new byte[1024];
      int len=0;
      
      socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
      os = socket.getOutputStream();
      
      while((len=fis.read(buf))!=-1) {
        os.write(buf,0,len);
      }
      //告述服务端，我已发送完毕
      socket.shutdownOutput();
      
      
      is=socket.getInputStream();
      byte[] b=new byte[1024];
      int len1=0;
      while((len=is.read(b))!=-1) {
        String str=new String(b,0,len1);
        System.out.println(str);
      }
      
    }catch (Exception e) {
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
        if(os!=null) {
          os.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        if(socket!=null) {
          socket.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
