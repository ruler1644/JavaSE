package chaptor04_oriented_object;

public class FatoryTest {
	public static void main(String[] args) {
		Worker w1 = Factory.getInstance1();
		w1.work();
		
		Worker w2 = Factory.getInstance2();
		w2.work();
	}
}
interface Worker{
	void work();
}

class Teacher implements Worker{

	@Override
	public void work() {
		System.out.println("老师讲课");
	}
}

class Student implements Worker{

	@Override
	public void work() {
		System.out.println("学生听课");
	}
}

class Factory {
	public static Worker getInstance1() {
		return new Teacher();
	}
	public static Worker getInstance2() {
		return new Student();
	}
}