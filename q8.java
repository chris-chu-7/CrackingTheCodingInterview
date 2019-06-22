//write an algorithm such that if an element in an m x n matrix is 0, its entire row and column are set to 0.

import java.util.Random;

public class q8 {
	
	static Random random = new Random();
	
	public static void setToRandom(int[][] matrix) {
		boolean[][] truthMatrix = new boolean[matrix.length][matrix[0].length];
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] == 0 && truthMatrix[i][j] == false) {
					setRow(matrix, truthMatrix, i, j);
					setColumn(matrix, truthMatrix, i, j);
				}
				
			}
		}
		
		return;
	}
	
	public static void setRow(int[][] matrix, boolean[][] truthMatrix, int i, int j) {
		for(int k = 0; k < matrix[i].length; k++) {
			matrix[i][k] = 0;
			truthMatrix[i][k] = true;
		}
	}
	
	public static void setColumn(int[][] matrix, boolean[][] truthMatrix, int i, int j) {
		for(int k = 0; k < matrix.length; k++) {
			matrix[k][j] = 0;
			truthMatrix[k][j] = true;
		}
	}

	
	public static void main(String[] args) {
		int[][] matrix = new int[5][5];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = random.nextInt(5);
			}
		}
		setToRandom(matrix);
	}

}
