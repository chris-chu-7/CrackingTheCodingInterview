
public class q1 {
	
	//Problem 1: Implement an algorithm that determines if a string has all unique characters. 
	//What if you cannot use additional data structures?
	public static boolean isUnique(String s) {
		int[]StringArray = new int[26];
		String toLower = s.toLowerCase();
		for(int i = 0; i < toLower.length(); i++) {
			char c = toLower.charAt(i);
			int hash = hashNumber(c);
			if(StringArray[hash] >= 1) {
				System.out.print(s + " has more than one of the character " + c + "   ");
				return false;
			}
			StringArray[hash]++;
		}
		System.out.print(s + " is a string with all unique characters   " );
		return true;
	}
	
	public static int hashNumber(char c) {
		return(int)c - 97;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isUnique("qwertyuiopasdfghjklzxcvbnm"));
		System.out.println(isUnique("qWeRtYuIoPaSdFgHjKlZxCvBnM"));
		System.out.println(isUnique("qWERtYuIoPaSdFgHjKlZxCvBnMe"));
	}
	

}
