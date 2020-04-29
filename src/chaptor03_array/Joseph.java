package chaptor03_array;
/**
 * @description 单向链表解决约瑟夫环问题
 * @author wu
 * @date 2019年4月25日下午11:54:43
 */
public class Joseph {
	public static void main(String[] args) {
		Link link =new Link();
		link.setLen(5);
		link.createLink();
		
		link.setK(2);
		link.setM(2);
		
		link.show();
		link.play();
		
	}
}

class Node{
	int value;
	Node next;
	
	public Node(int value) {
		this.value = value;
	}
	
}
class Link{
	Node head;
	Node end;
	
	int len;
	int k;
	int m;
	
	public void setLen(int len) {
		this.len = len;
	}
	public void setK(int k) {
		this.k = k;
	}
	public void setM(int m) {
		this.m = m;
	}
	
	public void play() {
		Node temp = head;
		//找到第k个节点
		for (int i = 0; i < k; i++) {
			temp = temp.next;
		}
		while(len != 1) {
			//数m下
			for (int i = 0; i < m; i++) {
				temp = temp.next;
			}
			//找到要删除的节点的前一个节点
			Node temp2 = head;
			while(temp2.next != temp) {
				temp2 = temp2.next;
			}
			
			//删除数到m的节点
			temp2.next = temp.next;
			temp = temp.next;///////////????????????
			len--;
		}
		System.out.println("最后的节点是："+temp.value);
	}
	
	public void createLink() {
		for (int i = 1; i <= len; i++) {
			if(1 == i) {
				Node node = new Node(i);
				head = node;
				end = node;
			}
			else {
				if(i == len) {
					Node node = new Node(i);
					end.next = node;
					end = node;
					end.next = head;
				}else {
					Node node = new Node(i);
					end.next = node;
					end = node;
				}
			}
		}
	}
	
	public void show() {
		Node node = head;
		do{
			System.out.print(node.value+"\t");
			node = node.next;
		}while(node != head); 
	}
}