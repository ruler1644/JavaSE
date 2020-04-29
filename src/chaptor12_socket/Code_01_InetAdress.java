package chaptor12_socket;
import java.net.InetAddress;
public class Code_01_InetAdress {
	public static void main(String[] args) throws Exception {
		InetAddress inetAddress1 = InetAddress.getByName("10.1.3.38");
		System.out.println(inetAddress1);
		
		InetAddress inetAddress2 = InetAddress.getLocalHost();
		System.out.println(inetAddress2);
		
		String hostName = inetAddress2.getHostName();
		String hostAddress = inetAddress2.getHostAddress();
		System.out.println(hostName+"\n"+hostAddress);
		
	}

}
