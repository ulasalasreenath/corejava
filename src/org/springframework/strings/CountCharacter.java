package org.springframework.strings;

import java.util.ArrayList;

public class CountCharacter {

	static int count = 0;

	public static void main(String[] args) {
		countCharacter("Sreenath", 'e', 0);
		System.out.println(count);
		
		System.out.println(Character.isDigit('B'));
		System.out.println(Character.getNumericValue('B'));
		
		ArrayList<String> aList = new ArrayList<String>();
		aList.toArray(new String[1]);
	}

	private static void countCharacter(String string, char c, int i) {

		if (i != string.length()) {
			if(string.charAt(i) == c) count++;
			countCharacter(string, c, i+1);
		}

		
		
	}

}
