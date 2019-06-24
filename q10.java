import java.util.HashSet;
import java.util.Random;

//write code to remove duplicates from an unsorted linked list

public class q10 {
	
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
	
	public static void removeDuplicate(Node n) {
		Node dup = n;
		HashSet<Integer> h = new HashSet<Integer>();
		h.add(dup.data);
		while(dup.next != null) {
			if(h.contains(dup.next.data)) {
				dup.next = dup.next.next;
			} else {
				h.add(dup.next.data);
				dup = dup.next;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random newRand = new Random();
		Node n = new Node(newRand.nextInt(20));
		for(int i = 0; i < 100000; i++) {
			n.appendToTail(newRand.nextInt(20));
		}
		
		//n.printNode();
		
		removeDuplicate(n);
		
		n.printNode();
		}
	
	
	}


