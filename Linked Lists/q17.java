//Given a linked list which might contain a loop, implement an algorithm that returns the node at 
//the beginning of the loop 
public class q17 {
	
	static class Node{
		Node next = null;
		int data;
	
		
		public Node(int d) {
			data = d;
		}
		
		void appendToTail(int d) {
			Node end = new Node(d);
			Node n = this;
			while(n.next != null) {
				n = n.next;
			}
			n.next = end;
		}
		
		Node deleteNode(Node head, int d) {
			if(head == null) return null;
			Node n = head;
			if(n.data == d) {
				head = head.next;
				return head;
			}
			
			while(n.next != null) {
				if(n.next.data == d) {
					n.next = n.next.next;
					return head;
				}
				n = n.next;
			}
			return head;
			
		}
		
		int size () {
			int length = 0;
			Node n = this;
			if(n == null)
				return 0; 
			length = 1;
			while(n.next != null) {
				n = n.next;
				length++;
			}
			return length;
		}
		
		void printNode() {
			Node d = this;
			while(d != null) {
				if(d.next != null) {
					System.out.print(d.data + " --> ");
				} else {
					System.out.println(d.data + " ");
				}		
				d = d.next;
			}
		}
	}
	
	public static Node cycle(Node n) {
		Node a = n;
		Node b = n;
		
		while(b != null && b.next != null) {
			a = a.next;
			b = b.next.next;
			if(a == b) {
				break;
			}
		}
		
		if(a == null || b == null) {
			return null;
		} 
		
		b = n;
		while(b != a) {
			a = a.next;
			b = b.next;
		}
		
		return b;
	
	} 
	
	
	public static void main(String[] args) {
		Node a = new Node(1);
		for(int i = 2; i <= 11; i++) {
			a.appendToTail(i);
		}
		
		Node b = a;
		
		while(b.next != null) {
			b = b.next;
		}
		
		
		b.next = a.next.next.next;
		
		if(cycle(a) != null) {
			System.out.println("A's data: " + cycle(a).data);
		} else {
			System.out.println("There is no cycle for a");
		}
		
		Node c = new Node(1);
		for(int i = 2; i <= 100; i++) {
			c.appendToTail(i);
		}
		
		if(cycle(c) != null) {
			System.out.println("C's data: " + cycle(c).data);
		} else {
			System.out.println("There is no cycle for c");
		}
		
		
		

	}

}
