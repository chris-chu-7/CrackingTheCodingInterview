//implement a function to check if a linked list is a palindrome. 
public class q15 {

	static class Node{
		Node next = null;
		char data;
	
		
		public Node(char d) {
			data = d;
		}
		
		void appendToTail(char d) {
			Node end = new Node(d);
			Node n = this;
			while(n.next != null) {
				n = n.next;
			}
			n.next = end;
		}
		
		Node deleteNode(Node head, char d) {
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
	
	public static boolean isPalindrome(Node head) {
		Node reverse = reversenode(head);
		return isEqual(head, reverse);
	}
	
	public static Node reversenode(Node node) {
		//reverse node
		Node head = null;
		while(node != null) {
			Node n = new Node(node.data);
			n.next = head;
			head = n;
			node = node.next;
		}
		
		return head;
	}
	
	public static boolean isEqual(Node a, Node b) {
		while(a != null && b != null) {
			if(a.data != b.data) {
				return false;
			}
			a = a.next;
			b = b.next;
		}
		
		return (a == null && b == null);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n = new Node('r');
		n.appendToTail('a');
		n.appendToTail('c');
		n.appendToTail('e');
		n.appendToTail('c');
		n.appendToTail('a');
		n.appendToTail('r');
		System.out.println(isPalindrome(n));
		n = new Node('r');
		n.appendToTail('r');
		n.appendToTail('c');
		n.appendToTail('e');
		n.appendToTail('c');
		n.appendToTail('a');
		n.appendToTail('r');
		System.out.println(isPalindrome(n));
		

	}


}
