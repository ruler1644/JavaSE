package chaptor12_socket;
import java.io.*;
import java.net.*;

public class TeTcpClient2 {
  public static void main(String[] args) {
    Socket socket=null;
    OutputStream os=null;
    InputStream is=null;
    try {
      socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
      os = socket.getOutputStream();
      os.write("我是客户端,正在发送消息".getBytes());
      //告诉服务端，我已发送完毕
      socket.shutdownOutput();
      
      byte[] buf=new byte[128];
      int len=0;
      is=socket.getInputStream();
      while((len=is.read(buf))!=-1) {
        String str=new String(buf,0,len);
        System.out.print(str);
      }
      
    } catch (UnknownHostException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }finally {
      try {
        if(is!=null) {
          is.close();
        }
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      try {
        if(os!=null) {
          os.close();
        }
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      try {
        if(socket!=null) {
          socket.close();
        }
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}
