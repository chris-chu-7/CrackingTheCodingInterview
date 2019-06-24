
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
				c[i] = '\0';
				continue;
			}
			else {
				c[i] = s.charAt(i);
			}
				
			if(c[i] == ' ' && (c[i + 1] != ' ')) {
				numSpaces++;
			}
		}
		int multiply = numSpaces * 2;
		
		char[] finalArray = new char[c.length + multiply];
		
		int finalIndex = finalArray.length-1;
		//System.out.println(finalIndex);
		
		System.out.println(c[c.length - 1]);
		int originalNum = c.length - 1;
		while(finalIndex >= 0) {
			//System.out.println(finalIndex);
			
			System.out.println(originalNum);
			
			if(c[originalNum] == ' ') {
				finalArray[finalIndex] = '0';
				finalArray[finalIndex - 1] = '2';
				finalArray[finalIndex - 2] = '%';
				originalNum--;
				finalIndex -= 3;
			}
			
			else {
				finalArray[finalIndex] = c[originalNum];
				finalIndex--;
				originalNum--;
			}
				
		}
				
		for(int b = 0; b < finalArray.length; b++) {
			System.out.print(finalArray[b]);
		}
		
		
	}

	public static void main(String[] args) {
		//Example; Mr. John Smith should generate "Mr%20John%20Smith"
		printNewString("Mr. John Smith", 2012);

	}

}
