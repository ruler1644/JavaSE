package chaptor12_socket;
import java.io.*;
import java.net.*;
public class TcpClient {
  public static void main(String[] args) {
    Socket socket=null;
    OutputStream os=null;
    try {
      socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
      os = socket.getOutputStream();
      os.write("我是客户端,正在给你发信息".getBytes());
    } catch (Exception e) {
      e.printStackTrace();
    }finally {
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
