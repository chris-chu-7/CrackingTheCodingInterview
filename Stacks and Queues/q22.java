//write a program to sort a stack such that the smallest items are on top. You can use
//an additional temporary stack, but you may not copy the elements into any other
//data structure (such as an array) push pop peek and isEmpty

import java.util.Random;

public class q22 {
	
	
	
	static class MinStack{
		Stack stack = new Stack();
		
		private static class Node{
			private int data;
			private Node next;
			
			private Node (int data){
				this.data = data;
			}
		}
		
		
		public Node top;
		
		public int peek() {
			return stack.top.data;
		}
		
		public Node pop() {
			return stack.pop();
		}
		
		public void push(int t) {
			Stack tempStack = new Stack();
			Node node = new Node(t);
			int value = t;
			
			while(stack.top != null && value > stack.peek()) {
				tempStack.push(stack.pop().data);
			}
			
			tempStack.push(value);
			//System.out.println(tempStack.peek());
			
			while(!tempStack.isEmpty()) {
				int datas = tempStack.peek();
				stack.push(datas);
				tempStack.pop();
			}	
			
		}
		
		public boolean isEmpty(){
			return top == null;
		}
		
		private static class Stack{
			public Node top;
			
			public int peek() {
				return top.data;
			}
			
			public Node pop() {
				Node n = top;
				top = top.next;
				return n;
			}
			
			public void push(int t) {
				Node newNode = new Node(t);
				newNode.next = top;
				top = newNode;
			}
			
			public boolean isEmpty() {
				return top == null;
			}
			
			
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack testStack = new MinStack();
		Random rand = new Random();
		
		for(int i = 0; i <= 20; i++) {
			testStack.push(rand.nextInt(1000));
		}
		
		for(int i = 0; i <= 20; i++) {
			System.out.println(testStack.pop().data);
		}
		
	}

}
