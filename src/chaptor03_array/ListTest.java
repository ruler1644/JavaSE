package chaptor03_array;

public class ListTest {

	public static void main(String[] args) {
		List list = new List();
		list.insert(10); 
		list.insert(2); 
		list.insert(1); 
		list.insert(8); 
		list.insert(9);
		list.insert(4); 
		list.insert(7);
		
		System.out.println("****遍历链表******");
		list.show();
//		
//		System.out.println("****链表大小******");
//		System.out.println(list.size());
//		
//		System.out.println("****链表转数组******");
//		int[]arr = list.toArray();
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i]+"\t");
//		}System.out.println();
//		
		System.out.println("****删除元素******");
		list.remove(7);
//		list.remove(7);  
		list.show();
		
		
		System.out.println("****删除过后再次插入******");		
		list.insert(666667);
		list.show();
	}
}


class Node2{
	int value;
	Node2 next;
}

class List{
	Node2 head;
	Node2 end;
	
	//插入元素
	public void insert(int value) {
		Node2 newNode2 = new Node2();
		newNode2.value = value;
		if(null == head) {
			head = newNode2;
			end = newNode2;
		}
		end.next = newNode2;
		end = newNode2;
	}
	
	//遍历链表
	public void show() {
		Node2 temp = head;
		while(temp != null) {
			System.out.print(temp.value+"\t");
			temp = temp.next;
		}
		System.out.println();
	}
	
	//获取链表中元素个数   
	public int size() {
		int count = 0;
		Node2 temp = head;
		while(temp !=null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	//从链表删除一个元素
	public void remove(int value) {
		//找到要删除节点
		if(value == head.value) {
			head = head.next;
			return;
		}
		
		Node2 temp = head;
		while(temp !=null) {
			if(value == temp.value) {
				break;
			}
			temp = temp.next;
		}
		
		//找到要删除节点的前一个节点
		Node2 temp2 = head;
		while(temp2.next !=temp) {
			temp2 = temp2.next;
		}
		//删除节点
		temp2.next = temp.next;
		temp = temp.next;
	}
	
	//取出链表中元素,转为数组
	public int[] toArray() {
		int[] arr = new int[size()];
		int count = 0;
		Node2 temp = head;
		while(temp != null) {
			arr[count] = temp.value;
			count++;
			temp = temp.next;
		}
		return arr;
	}
}
