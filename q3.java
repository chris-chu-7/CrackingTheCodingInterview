
//Write a method to replace all spaces in a string with '%20'. 
//Assume string has sufficient space at end of string to hold additional characters, 
//and that you're given a true length of a string.
public class q3 {
	
	public static void printNewString(String s, int length) {
		//the length of the new array  
		if(length < s.length()) {
			length = s.length();
		}
		
		char[] c = new char[length];
		int numSpaces = 0;
		
		for(int i = 0; i < c.length; i++) {
			if(i >= s.length()) {
				numSpaces++;
				c[i] = ' ';
				continue;
			}
			else {
				c[i] = s.charAt(i);
			}
				
			if(c[i] == ' ') {
				numSpaces++;
			}
		}
		
		int multiply = numSpaces * 2;
		
		char[] finalArray = new char[c.length + multiply];
		
		int finalIndex = 0;
		while(finalIndex < finalArray.length) {
			System.out.println(finalIndex);
			int offset = 0;
			while(offset < c.length) {
				if(c[offset] == ' ') {
					System.out.println(finalIndex);
					finalArray[finalIndex] = '%';
					finalArray[finalIndex + 1] = '2';
					finalArray[finalIndex + 2] = '0';
					finalIndex = finalIndex + 3;
				} else {
					System.out.println(finalIndex);
					finalArray[finalIndex] = c[offset];
					finalIndex++;
				}
				offset++;
			}
		}
	
		
		for(int b = 0; b < finalArray.length; b++) {
			System.out.print(finalArray[b]);
		}
		
		
	}

	public static void main(String[] args) {
		//Example; Mr. John Smith should generate "Mr%20John%20Smith"
		printNewString("Mr. John Smith", 13);

	}

}
