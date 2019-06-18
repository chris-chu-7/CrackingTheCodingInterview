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
	static class LinkedList{
		LinkedList next = null;
		char data;
		
		public LinkedList(char d) {
			data = d;
		}
		
		void appendToTail(char d) {
			LinkedList end = new LinkedList(d);
			LinkedList n = this;
			while(n.next != null) {
				n = n.next;
			}
			n.next = end;
		}
		
		boolean hasNext() {
			return (this.next != null);
		}
		
		
		
	}
	
	public static int hasValue(ArrayList<LinkedList> list, char c) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).data == c) {
				return i;
			}
			
		}
		return 2000000000; 
	}
	
	public static boolean isPalidromePermutation(String s) {
		String lower = s.toLowerCase();
		ArrayList<LinkedList> charList = new ArrayList<LinkedList>();
		for(int i = 0; i < lower.length(); i++) {
			char c = s.charAt(i);
			
			if(hasValue(charList, c) != 2000000000) {
				charList.get(i).appendToTail(c);
			} else {
				charList.add(new LinkedList(c));
			}
			
			//check to see if arrayList already has the value
		}
		
		for(int i = 0; i < charList.size(); i++) {
			if(!charList.get(i).hasNext()) {
				return false;
			}
		}
		
		return true; 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalidromePermutation("racecar"));
	}

}
