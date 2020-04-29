package chaptor12_socket;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class TeUDPReceive {
  public static void main(String[] args) throws Exception {
    receive();
  }
  
  //接收端
  public static void receive() throws Exception {
    DatagramSocket ds=new DatagramSocket(9001);
    byte[] b=new byte[64];
    //创建一个数据报，(最大64k) 数据报记录要发送信息，及发送端地址和端口，还有接收端地址和端口
    DatagramPacket packet=new DatagramPacket(b, 0, b.length);
    ds.receive(packet);
    String str=new String(packet.getData(),0,packet.getLength());
    System.out.println(str);
    ds.close();
  }
}
