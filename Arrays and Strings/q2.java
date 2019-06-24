//Check Permutation: Given 2 Strings, write a method to decide if one is a permutation of the other.

public class q2 {
	
	public static boolean isPermutation(String a, String b) {
		int[] aStringArray = new int[52];
		int[] bStringArray = new int[52];
		if(a.length() != b.length()) {
			return false;
		}
		for(int i = 0; i < a.length(); i++) {
			char aC = a.charAt(i);
			char bC = b.charAt(i);
			aStringArray[hashFunction(aC)]++;
			bStringArray[hashFunction(bC)]++;
			
		}
		
		return areEqual(aStringArray, bStringArray);
		
		
	}
	
	public static int hashFunction(char c) {
		//if the character is upperCase
		if((int)c <  91) {
			return c - 65 + 26;
		}
		
		return c - 97;
	}
	
	public static boolean areEqual(int[] a, int[] b) {
		if(a.length != b.length) {
			return false;
		}
		
		for(int i = 0; i < a.length; i++) {
			if(a[i] != b[i]) {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPermutation("Qwertyuiopasdfghjklzxcvbnm", "mnbvcxzlkjhgfdsapoiuytrewQ"));
		System.out.println(isPermutation("Qwertyuiopasdfghjklzxcvbnm", "mnbvcxzlkjhgfdsapoiuytrewq"));
		System.out.println(isPermutation("Qwertyuiopasdfghjklzxcvbnm", "mnbvcxzlkjhgfdsapoiuytreww"));
		System.out.println(isPermutation("Qwertyuiopasdfghjklzxcvbnm", "mnbvcxzlkjhgQfsapoiudytrew"));
	}

}
