//implement a method to perform basic string compression using the counts 
//of repeated characters. For example, the string aabcccccaaa would become a3b1c4a3. 
//If the compressed string is not smaller than the original string, your method should return the 
//original string. You can assume the string has onle uppercase and lowercase letters (a-z)

import java.util.ArrayList;


public class q6 {
	
	static class letter{
		char letter;
		int numOccurences;
		
		public letter(char l, int n) {
			letter = l;
			numOccurences = n;
		}
	}
	
	public static void printToConsole(String s) {
		int letterNumber = 0;
		ArrayList<letter> listOfLetters = new ArrayList<letter>();
		for(int i = 0; i < s.length(); i++) {
			if(i == 0) {
				listOfLetters.add(new letter(s.charAt(0),1));
				continue;
			}
			if(s.charAt(i) == listOfLetters.get(letterNumber).letter) {
				listOfLetters.get(letterNumber).numOccurences++;
				continue;
			} else {
				listOfLetters.add(new letter(s.charAt(i), 1));
				letterNumber++;
			}
			
		}
		
		for(int i = 0;  i < listOfLetters.size(); i++) {
			System.out.print(Character.toString(listOfLetters.get(i).letter) + listOfLetters.get(i).numOccurences);
		}
	}

	public static void main(String[] args) {
		printToConsole("aabcccccaaa");
	}

}
