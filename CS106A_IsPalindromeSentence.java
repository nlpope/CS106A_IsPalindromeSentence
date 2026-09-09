/**
 * File: CS106A_IsPalindromeSentence.java
 * -------------------------------
 * The CS106A_IsPalindromeSentence class detects
 * whether or not a sentence is a palindrome.
 * 
 */

import acm.program.*;
import java.util.*;

public class CS106A_IsPalindromeSentence extends ConsoleProgram
{
	private static final String SENTINEL = "ENDPROGRAM";
	private static final String 
	DELIMITERS = "!@#$%^&*()_-+={[}]:;\"'<,>.?/~`/\\ ";
	
	public void run()
	{
		introduceApp();
		askClientForInput();
	}
	
	
	private void introduceApp()
	{
		println("The CS106A_IsPalindromeSentence class detects " +
				"whether or not a sentence is a palindrome.");
		pause(1000);
		println("Play indefinitely or type '" + SENTINEL + "' to end the program.");
	}
	
	
	private void askClientForInput()
	{
		while(true){
			String clientInput = readLine("Enter a sentence: ");
			if(clientInput.equals(SENTINEL)){
				println("goodbye.");
				return;
			}
			if (isPalindromeSentence(clientInput)){ 
				println("That sentence is a palindrome."); 
			}
			else { println("That sentence is not a palindrome"); }
		}
	}
	
	
	private boolean isPalindromeSentence(String str)
	{
		String comparisonStr = "";
		StringTokenizer tokenizedStr = new StringTokenizer(str, DELIMITERS, false);
		while(tokenizedStr.hasMoreTokens()){
			String token = tokenizedStr.nextToken();
			comparisonStr += token;
		}
		
		comparisonStr = comparisonStr.toLowerCase();
		
		for(int i = 0; i < comparisonStr.length() / 2; i++){ 
			Character c = comparisonStr.charAt(i);
			if (!c.equals(comparisonStr.charAt(comparisonStr.length() - 1 - i))){ return false; }
		}
		return true;
	}
}