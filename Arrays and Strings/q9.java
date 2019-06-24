//assume you have a method isSubstring which checks if one word is a substring of another. 
//given 2 strings s1 and s2, write code to check if s2 is a rotation of s1 using only one call to
//isSubstring.

public class q9 {
	
	//example acbdefg and efgabcd 
	//Clever solution: observe that appending the second character twice would result in
	//efgabcdefgabcd. this contains the first string. So simply make a new string appending the
	//first string twice and then call the method is substring with this new string and the first string.
	//if true, we have found a substring. If false, we have not. 

}
