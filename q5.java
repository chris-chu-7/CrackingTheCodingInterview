//There are three types of edits that can be performed on strings: insert a character,
//remove a character, or replace a character. Given two strings,
//write a function to check if they are one edit(or zero edits away.

import java.util.Scanner;


public class q5 {
	
	public static int min(int x, int y, int z) {
		if(x <= y && x <= z) {
			return x;
		}
		if(y <= z) {
			return y;
		}
		return z;
	}
	
	public static int editDistance(String a, String b, int uno, int dos) {
		if(uno == 0) {
			return dos;
		}
		
		if(dos == 0) {
			return uno;
		}
		
		if(a.charAt(uno - 1) == b.charAt(dos - 1)) {
			return editDistance(a, b, uno-1, dos-1);
		}
		
		return 1 + min(editDistance(a, b, uno-1, dos-1), editDistance(a, b, uno, dos-1), editDistance(a, b, uno-1, dos));
		
	}
	
	public static boolean isOneEditAway(String a, String b) {
		return (editDistance(a, b, a.length(), b.length()) <= 1); 
	}

	public static void main(String[] args) {
		boolean end = false;
		Scanner stringScan = new Scanner(System.in);
		
	
		
		try {
			while(!end) {
				System.out.println("Enter two strings to see if they are one edit away: ");
				String a = stringScan.next();
				String b = stringScan.next();
				System.out.println("Edit distance between a and b is " + editDistance(a, b, a.length(), b.length()));
				System.out.println(isOneEditAway(a, b));
				System.out.println("Do you want to stop testing now?");
				String response = stringScan.next();
				end = (response.toLowerCase().equals("yes"));
				
			}
		} catch(Exception e) {
			System.out.println("Invalid statement. Please try again.");
		} finally {
			System.out.println("Thank you for testing this program. Have a nice day :o)");
		}
		

	}

}
