//given an image represented by an NxN matrix, where each pixel in the image is 
//represented by an integer, write a method to rotate the image by 90 degrees.
//Can you do this in place? 

//write the algorithm to be O(N^2), since it will take at least N^2
//operations to rotate N^2 elements. 

public class q7 {
	
	public static void rotateMatrix(int[][] matrix) {
		if (matrix.length == 0 || matrix.length == 1) {
			return;
		}
		
		for(int level = 0; level < matrix.length/2; level++) {
			int first = level;
			int last = matrix.length - 1 - level;
			for(int index = first; index < last; index++) {
				int temporary = matrix[first][index];
				matrix[first][index] = matrix[last + first - index][first];
				matrix[last+first-index][first] = matrix[last][last + first - index];
				matrix[last][last + first - index] = matrix[index][last];
				matrix[index][last] = temporary;
			}
			
		}
	}

	public static void main(String[] args) {
		
		int[][] matrix = new int[4][4];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				matrix[i][j] = i + j;
			}
		}
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		rotateMatrix(matrix);
		System.out.println();
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

}
