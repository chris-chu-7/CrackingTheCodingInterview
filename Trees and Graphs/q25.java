

//Given a sorted(increasing order) array with unique integer element, write an algorithm
//to create a binary search tree with maximum height. 

public class q25 {

	
	static class btNode{
		Integer data;
		btNode[] children = new btNode[2];
		
		public btNode(int data) {
			this.data = data;
		}
		
		void addNode(int n) {
			btNode node = new btNode(n);
			if(n > data) {
				children[1] = node;
			} else {
				children[0] = node;
			}
		}
		
		public void printTree() {
			btNode node = this;
			System.out.println(node.data);
			
			if(node.children[0] != null) {
				System.out.println("Left with predecessor " + node.data);
				node.children[0].printTree();
			}
			
			if(node.children[1] != null) {
				System.out.println("Right with predecessor " + node.data);
				node.children[1].printTree();
			}
			
			
		}
	
	}
	
	
	
	public static btNode makeMinTree(int[] numbers) {

		if(numbers.length == 0) {
			return null;
		}
		
		if(numbers.length == 1) {
			return new btNode(numbers[0]);
		}
		
		int length = numbers.length;
		int mid = 0;
		
		if(numbers.length % 2 == 1) {
			mid = length / 2 + 1;
		} else {
			mid = length / 2;
		}
		
		int[] lesser = new int[mid - 1];
		int[] greater = new int[numbers.length - lesser.length - 1];
		
		for(int i = 0; i < mid-1; i++) {
			lesser[i] = numbers[i];
		}
		
		for(int i = 0; i < numbers.length - lesser.length - 1; i++) {
			greater[i] = numbers[i+mid];
		}
		
		btNode node = new btNode(numbers[mid - 1]);
		node.children[0] = makeMinTree(lesser);
		node.children[1] = makeMinTree(greater);
		return node;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		makeMinTree(arr).printTree();
	}
}
