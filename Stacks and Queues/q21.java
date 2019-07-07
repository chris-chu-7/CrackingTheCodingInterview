// Implement a MyQueue class which implements a Queue using two Stacks. 
public class q21 {
	
	static class MyQueue{
		Stack main = new Stack();
		Stack assistant = new Stack();
		
		public void enqueue(int data)  {
			if(main.top == null) {
				main.push(data);
				return;
			}
			while(!main.isEmpty()) {
				assistant.push(main.pop());
			}
			assistant.push(data);
			while(!assistant.isEmpty()) {
				main.push(assistant.pop());
			}
		}
		
		public int dequeue() {
			if(main.isEmpty()) {
				return 0;
			}
			while(!main.isEmpty()) {
				assistant.push(main.pop());
			}
			int num = assistant.pop();
			while(!assistant.isEmpty()) {
				main.push(assistant.pop());
			}
			return num;
		}
		
		public int peek()  {
			while(!main.isEmpty()) {
				assistant.push(main.pop());
			}
			int num = assistant.peek();
			while(!assistant.isEmpty()) {
				main.push(assistant.pop());
			}
			return num;
		}
		
	}
	
	static class Stack{
		Node top;
		private class Node{
			int data = 0; 
			Node next = null;
			
			public Node(int d) {
				this.data = d;
			}
		}
		
		Node stack;
		public int peek() {
			return top.data;
		}
		public void push(int item) {
			Node node = new Node(item);
			if(top == null) {
				top = node;
				stack = top;
				return;
			}
			stack.next = top;
			top = node;
		}
		public int pop()  {
			int data = top.data;
			top = top.next;
			return data;
		}
		public boolean isEmpty() {
			return(top == null);
		}
	}

	public static void main(String[] args)  {
		MyQueue queue = new MyQueue();
		for(int i = 1; i <= 10; i++) {
			queue.enqueue(i);
		}
		
		for(int i = 0; i < 3; i++) {
			queue.dequeue();
		}
		
		

	}

}
