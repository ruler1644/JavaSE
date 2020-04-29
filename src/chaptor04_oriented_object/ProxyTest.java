package chaptor04_oriented_object;
public class ProxyTest {
	public static void main(String[] args) {
		HouseRent hr = new Broker();
		hr.rent();
	}
}

interface HouseRent {
	void rent();
}

class Host implements HouseRent {

	@Override
	public void rent() {
		System.out.println("我是房东,我有房子要出租");
	}

}

class Broker implements  HouseRent {
	HouseRent hr = new Host();
	@Override
	public void rent() {
		System.out.println("我是中介,我有房源信息,你要租吗？");
		hr.rent();
		System.out.println("我是中介,确定要租，请先缴纳中介费");
	}

}
