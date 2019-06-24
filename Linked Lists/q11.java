public class q11 {

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
		
		void deleteNode(Node head, int d) {
			if(head == null) return;
			Node n = head;
			if(n.data == d) {
				head = head.next;
			}
			
			while(n.next != null) {
				if(n.next.data == d) {
					n = n.next.next;
					return;
				}
				n = n.next;
			}
			
		}
		
		int size () {
			int length = 0;
			Node n = this;
			if(n == null) {
				return 0;
			} 
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
	
	public static void findKthLastNode(Node n, int k) {
		int size = n.size();
		if(k > size) {
			System.out.println("Invalid Input. Please try again");
			return;
		}
		int node = size - k;
		Node o = n;
		int tracker = 0;
		while(tracker != node) {
			o = o.next;
			tracker++;
		}
		System.out.println("The node at " + k + " positions from the end is " + o.data);
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n = new Node(0);
		for(int i = 1; i <= 10; i++) {
			n.appendToTail(i);
		}
		
		n.printNode();
		
		for(int i = 1; i <= n.size(); i++) {
			findKthLastNode(n, i);
		}

	}

	
}
