package chaptor12_socket;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import org.junit.Test;
public class Code_04_UDP {
	//1.创建Socket
	//2.创建DatagramPacket发送数据
	//3.发送数据
	
	//1.创建Socket
	//2.创建DatagramPacket接收数据
	//3.接收操作
	@Test
	public void sender() throws Exception {
		DatagramSocket s = new DatagramSocket(); 
		byte[] buff = "发送".getBytes();
		
		InetAddress inet = InetAddress.getByName("127.0.0.1");
		DatagramPacket pack = new DatagramPacket(buff,0,buff.length,inet,8899);
		
		s.send(pack);
		
		s.close();
	}
	@Test
	public void revice() throws Exception {
		DatagramSocket s = new DatagramSocket(8899);
		
		byte[] buff = new byte[512];
		DatagramPacket packet = new DatagramPacket(buff, 0, buff.length);
		s.receive(packet);
		
		String str = new String(packet.getData(),0,packet.getLength());
		System.out.println(str);
		
		s.close();
	}
}
