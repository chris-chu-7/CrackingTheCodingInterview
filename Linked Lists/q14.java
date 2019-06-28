//You have 2 numbers represented by a linked list, where each node contains a single digit.
//are stored in reverse order, such that the 1's digit is at the head if the list.
//write a function that adds the two numbers and returns the sum as a linked list.

public class q14 {
	
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
	
	public static Node addNodes(Node a, Node b) {
		int carry = 0;
		Node sum = null;
		while(a != null && b != null) {
			if(sum == null) {
				sum = new Node((a.data + b.data) % 10 + carry);
			} else {
				sum.appendToTail((a.data + b.data) % 10 + carry);
			}
			
			carry = (a.data + b.data) / 10;
			a = a.next;
			b = b.next;
			
		}
		
		boolean aHasNext = (a != null);
		boolean bHasNext = (b != null);
		
		if(aHasNext) {
			while(a != null) {
				sum.appendToTail(a.data + carry);
				carry = 0;
				a = a.next;
			}
		}
		
		if(bHasNext) {
			while(b != null) {
				sum.appendToTail(b.data + carry);
				carry = 0;
				b = b.next;
			}
		}
		
		
		return sum;
		
	}

	public static void main(String[] args) {
		Node n = new Node(7);
		n.appendToTail(9);
		n.appendToTail(3);
		
		Node o = new Node(8);
		o.appendToTail(3);
		
		Node p = addNodes(n,o);
		p.printNode();
	}
	
}
