package chaptor12_socket;
import java.io.*;
import java.net.*;
public class TcpServer {
  public static void main(String[] args){
    ServerSocket ss=null;
    Socket s=null;
    InputStream is=null;
    
    try {
      ss=new ServerSocket(9090);
      System.out.println("我是服务端，正在9090端口等待连接");
      s=ss.accept();
      
      is=s.getInputStream();
      byte[] buf=new byte[128];
      int len=0;
      while((len=is.read(buf))!=-1) {
        String str=new String(buf,0,len);
        System.out.println(str);
      }
      System.out.println("我是服务端：收到来自"+s.getInetAddress().getHostName()+"的信息");
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
