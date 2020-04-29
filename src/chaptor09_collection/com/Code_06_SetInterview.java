package chaptor09_collection.com;
import java.util.HashSet;
import java.util.Set;
public class Code_06_SetInterview{
	public static void main(String[] args) {
		HashSet set = new HashSet();
		Emp p1 = new Emp(1001, "AA");
		Emp p2 = new Emp(1002, "BB");

		set.add(p1);
		set.add(p2);
		System.out.println(set);
		//[Emp [id=1002, name=BB], Emp [id=1001, name=AA]]
		
		p1.name = "CC";
		System.out.println(set);
		//[Emp [id=1002, name=BB], Emp [id=1001, name=CC]]
		
		set.remove(p1);
		System.out.println(set);
		//[Emp [id=1002, name=BB], Emp [id=1001, name=CC]]
		//移除时第一步计算对象的哈希值1，第二步算出哈希值2，第三步算出对象在数组中的索引index，
		//因为p1对象当前的哈希值与原哈希值不相同，所以要移除的索引index与p1对象当前实际索引不相同，使得移除失败
		
		set.add(new Emp(1001, "CC"));
		System.out.println(set);
		//[Emp [id=1002, name=BB], Emp [id=1001, name=CC], Emp [id=1001, name=CC]]
		//新的对象与p1对象equals()相同，但是p1对象并不在它的哈希值2对应的index上，即此哈希值2对应的index位置为空，所以新对象可直接插入
		
		set.add(new Emp(1001, "AA"));
		System.out.println(set);
		//[Emp [id=1002, name=BB], Emp [id=1001, name=CC], Emp [id=1001, name=CC], Emp [id=1001, name=AA]]
		//新对象据哈希值2计算得到index，index上当前元素为p1,但新对象与对象p1哈希值2不相同1，新对象可以成功插入

	}
}

class Emp{
	int id;
	String name;
	
	public Emp() {
		super();
	}

	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}

