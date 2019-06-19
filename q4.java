//Given a string, write a function to check if it is a permutation of a palindrome.
//A palindrome is a word or phase that is the same forwards and backwards. A permutation 
//is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words. 
//You can ignore casing and non-letter characters

//Input: Tact Coa
//Output: True (permutations( 'taco cat', 'atco cta", etc.)

//I think what you do here is convert the letters into lower case, map each of the letters into a
//hash function, and check if at least word.length/2 - 1 letters have at least 2 units mapped into the hashmap.
//if it is mapped, then return true. Else return false.

import java.util.ArrayList;

public class q4 {
	
	public static int hashFunction(char c) {
		return Character.getNumericValue(Character.toLowerCase(c)) - Character.getNumericValue('a') + 1;
	}
	
	public static boolean isPalidromePermutation(String s) {
		
		int numOne = 0;
		int[] charArray = new int[(int)'z' + 1 - (int)'a'];
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ' ') {
				continue; 
			} 
			
			charArray[hashFunction(s.charAt(i))] ++;
			
		}
		
		for(int i = 0; i < charArray.length; i++) {
			if(charArray[i] % 2 == 1) {
				numOne++; 
				if(numOne > 1) {
					return false;
				}
			}
		}
		
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalidromePermutation("race    ca   r"));
	}

}
