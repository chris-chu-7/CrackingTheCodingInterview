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
		private static class StackNode{
			private int data;
			private StackNode next;
			
			public StackNode(int data) {
				this.data = data;
			}
			
			
		}
		
		public StackNode top;
		
		public int pop() {
			int item = top.data;
			top = top.next;
			return item;
		}
		
		public int peek(){
			return top.data;
		}
		
		public boolean isEmpty() {
			return top == null;
		}
		
		public void push(int item) {
			StackNode t = new StackNode(item);
			t.next = top;
			top = t;
		}
		
	}

	public static void main(String[] args)  {
		MyQueue queue = new MyQueue();
		for(int i = 1; i <= 4; i++) {
			queue.enqueue(i);
		}
		
		for(int i = 0; i < 3; i++) {
			queue.dequeue();
		}
		
		System.out.println(queue.peek());
		

	}

}
