//given a directed graph and two nodes s and e, design an algorithm to find out whether
//there is a route from S to E. 

//Bonus: print the route

public class q24 {	
	static class DirectedGraph{
		
		int[][] graph;
		int numNodes;
		boolean[] marked = new boolean[numNodes];
		public DirectedGraph(int numNodes) {
			graph = new int[numNodes][numNodes];
			this.numNodes = numNodes;
		}
		
		public void addDirectNeighbor(int from, int to) {
			graph[from][to] = 1;
		}
		
		public boolean BFS(int from, int to) {
			Queue queue = new Queue();
			queue.enqueue(from);
			while(!queue.isEmpty()) {
				Node r = queue.dequeue();
				if(r.data == to) {
					return true;
				}
				int data = r.data;
				for(int i = 0; i < numNodes; i++) {
					if(graph[data][i] == 1) {
						if(marked[i] == false) {
							marked[i] = true;
							queue.enqueue(i);
						}
					}
				}
			}
			return false;
			
		}
		
	
		
		
	}
	
	static class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
		}
	}
	
	static class Queue{
		
		
		
		
		Node first = null;
		Node last = null;
		
		public void enqueue(int i) {
			Node t = new Node(i);
			if(last != null) {
				last.next = t;
			}
			last = t;
			if(first == null) {
				first = last;
			}
		}
		
		public Node dequeue() {
			Node n = first;
			first = first.next;
			if(first == null) {
				last = null;
			}
			return n;
		}
		
		public int peek() {
			return first.data;
		}
		
		public boolean isEmpty() {
			return (first == null);
		}
	}
	
	public static void main(String[] args) {
		
		DirectedGraph graphy = new DirectedGraph(5);
		graphy.addDirectNeighbor(3, 0);
		graphy.addDirectNeighbor(0, 1);
		graphy.addDirectNeighbor(3, 2);
		graphy.addDirectNeighbor(2, 1);
		graphy.addDirectNeighbor(1, 4);
		graphy.addDirectNeighbor(3, 4);
		
		for(int i = 1; i <= graphy.graph.length; i++) {
			for(int j = 1; j <= graphy.graph.length; j++) {
				graphy.marked = new boolean[graphy.numNodes];
				System.out.println( i  +  " " + j  +  ": " + graphy.BFS(i-1, j-1) + " BFS");
			}
		}
		
	}
}
