package chaptor04_oriented_object;
public class InnerTest {
	public static void main(String[] args) {
		Outer outer = new Outer(10);
		//outer.outerTest();
		
		Outer.Inner inner = outer.new Inner();
		//inner.innerTest();
		
		Outer.Inner inner2 = new Outer(111).new Inner();
		inner2.innerTest();
	}
}
class Outer{
	private int id;
	public Outer(int id) {
		this.id = id;
	}
	
	class Inner{
		private int id = 100;
		public void innerTest(){
			System.out.println("id:"+id);
			System.out.println("this.id:"+this.id);
			System.out.println("outer.id:"+Outer.this.id);
		}
	}
	
	public void outerTest() {
		Inner inner = new Inner();
		inner.innerTest();
		System.out.println();
	}
}