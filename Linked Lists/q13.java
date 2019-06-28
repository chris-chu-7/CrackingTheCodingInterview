//Write code to partition a linked list around a value x, such that all nodes less than x 
//come before all nodes greater than or equal to x. 

import java.util.Random;

public class q13 {
	
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
	
	public static Node partition(Node n, int i) {
		Node node = n;	
		Node lesser = null;
		Node greater = null;
		node = n;
		while(node != null) {
			if(node.data >= i) {
				if(greater == null) {
					greater = new Node(node.data);
				} else {
					greater.appendToTail(node.data);
				}
			} else {
				if(lesser == null) {
					lesser = new Node(node.data);
				} else {
					lesser.appendToTail(node.data);
				}
			}
			node = node.next;
		}
		Node less = lesser;
		while(less.next != null) {
			less = less.next;
		}
		less.next = greater;
		return lesser;
	}
	
	public static void main(String[] args) {
		Random rand = new Random();
		Node test = new Node(rand.nextInt(1000));
		for(int i = 1; i <= 20; i++) {
			test.appendToTail(rand.nextInt(1000));
		}
		test.printNode();
		test = partition(test, 500);
		test.printNode();
	}

}
