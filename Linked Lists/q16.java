//Given 2 singly linked lists, determine if the two lists intersect. 
//Note that the intersection is determined based on reference, not value. 

public class q16 {
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
	
	public static Node intersection(Node a, Node b) {
		int aSize = a.size();
		int bSize = b.size();
		int difference = Math.abs(aSize - bSize);
		Node greater = null;
		Node lesser = null;
		if(aSize > bSize) {
			greater = a;
			lesser = b;
		} else {
			greater = b;
			lesser = a;
		}
		
		while(difference != 0) {
			greater = greater.next;
			difference --;
		}
		
		while(greater != null && lesser != null) {
			if(greater == lesser) {return new Node(greater.data);}
			greater = greater.next;
			lesser = lesser.next;
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		Node a = new Node(6);
		a.appendToTail(7);
		a.appendToTail(8);
		a.appendToTail(9);
		a.appendToTail(10);
		
		Node b = new Node(1);
		b.appendToTail(2);
		b.appendToTail(3);
		b.appendToTail(4);
		b.appendToTail(5);
		b.next = a;
		
		if(intersection(a,b) != null) {
			System.out.println("The intersection of nodes a and b is at address " + intersection(a,b) + " at point " + intersection(a,b).data + ".");
		} else {
			System.out.println("There is no intersection between nodes a and b.");
		}
		
		
		a = new Node(6);
		a.appendToTail(7);
		a.appendToTail(8);
		a.appendToTail(9);
		a.appendToTail(10);
		
		b = new Node(1);
		b.appendToTail(2);
		b.appendToTail(3);
		b.appendToTail(4);
		b.appendToTail(5);
		b.appendToTail(6);
		b.appendToTail(7);
		b.appendToTail(8);
		b.appendToTail(9);
		b.appendToTail(10);
		

		if(intersection(a,b) != null) {
			System.out.println("The intersection of nodes a and b is at address " + intersection(a,b) + " at point " + intersection(a,b).data + ".");
		} else {
			System.out.println("There is no intersection between nodes a and b.");
		}
	
	}
}
