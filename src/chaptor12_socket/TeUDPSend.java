package chaptor12_socket;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TeUDPSend {
  public static void main(String[] args) throws Exception {
    send();
  }
  
  //发送端
  public static void send() throws Exception {
    DatagramSocket ds=new DatagramSocket();
    byte[] b="我是要发送的数据".getBytes();
    //创建一个数据报，(最大64k) 数据报记录要发送信息，及发送端地址和端口，还有接收端地址和端口
    DatagramPacket packet=new DatagramPacket(b, 0, b.length,
                  InetAddress.getByName("127.0.0.1"),9001);
    ds.send(packet);
    ds.close();
  }
}
