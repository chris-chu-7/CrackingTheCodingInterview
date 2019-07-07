//Imagine a literal stack of plates. If the stack gets too high, it might topple
//several stacks and adds a new stack once the stack reaches full capacity
//write a class to implement these plates

import java.util.ArrayList;


public class q20 {
	
	static class Stacks{
		ArrayList<Stack> plateList = new ArrayList<Stack>();
		
		public void push(int i) {
			if(plateList.size() == 0) {
				Stack stack = new Stack();
				stack.push(i);
				plateList.add(stack);
			}
		else if(plateList.get(plateList.size() - 1).indexTrack==5) {
				//make a new stack 
				Stack addStack = new Stack();
				addStack.push(i);
				plateList.add(addStack);
			} else {
				plateList.get(plateList.size() - 1).push(i);
			}
		}
		
		public void pop() {
			if(plateList.get(plateList.size() - 1).indexTrack == 0) {
				plateList.remove(plateList.size()-1);
			} else {
				plateList.get(plateList.size() - 1).pop();
			}
		}
		
		public int peek() {
			return plateList.get(plateList.size() - 1).peek();
		}
		
		public void printList() {
			for(int i = 0; i < plateList.size(); i++) {
				for(int j = 0; j < plateList.get(i).stackArray.length; j++) {
					if(plateList.get(i).stackArray[j] == 0) {
						System.out.print("");
					} else {
						System.out.print("o");
					}
				}
				System.out.println();
			}
		}
		
		
	}
	
	static class Stack{
		int indexTrack = 0;
		int[] stackArray = new int[5];
		public int pop() {
			int num = stackArray[indexTrack - 1];
			stackArray[indexTrack - 1] = 0;
			indexTrack--;
			return num;
		}
		public boolean push(int item) {
			if(this.isFull()) {
				return false;
			}
			stackArray[indexTrack] = item;
			indexTrack++;
			return true;
			}
		
		public int peek(){
			return stackArray[indexTrack];
		}
		
		public boolean isFull(){
			return (indexTrack == 5);
		}
	}
	
	public static void main(String[] args) {
		
		Stacks stackList = new Stacks();
		for(int i = 1; i <= 20; i++) {
			stackList.push(i);
		}
		
		stackList.printList();
		
		for(int i = 0; i <= 7; i++) {
			stackList.pop();
		}
		
		System.out.println();
		System.out.println();
		
		stackList.printList();
		
		
	}
	
	
}
