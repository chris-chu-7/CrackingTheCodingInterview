//given an image represented by an NxN matrix, where each pixel in the image is 
//represented by an integer, write a method to rotate the image by 90 degrees.
//Can you do this in place? 

//write the algorithm to be O(N^2), since it will take at least N^2
//operations to rotate N^2 elements. 

public class q7 {
	
	public static void rotateMatrix(int[][] matrix) {
		if(matrix.length == 0) {
			return;
		}
		for(int i = 0; i < matrix.length/2; i++) {
			int top = i;
			int bottom = matrix.length-1-i;
			for(int j = top; j < bottom; j++) {
				int temp = matrix[top][j];
				matrix[top][j] = matrix[j][matrix.length-1-j];
				matrix[j][matrix.length-1-j] = matrix[bottom][j];
				matrix[bottom][j] = matrix[j][matrix.length-1-bottom];
				matrix[j][matrix.length-1-bottom] = temp;
			}
		}
		
	}

	public static void main(String[] args) {

	}

}
