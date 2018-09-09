package org.speakingcs.corejava.polymorphism;

public class PermutationsBySreenath {

	public static void main(String[] args) {
		printPermutations("sreenath");
	}

	private static void printPermutations(String input) {
		printPermutations(input, 0, input.length() - 1);
	}

	private static void printPermutations(String input, int left, int right) {

		if (left == right) {
			System.out.println(input);
		} else {

			for (int i = left; i <= right; i++) {
				String str = swap(input, left, i);
				printPermutations(str, left + 1, right);
			}
		}

	}

	private static String swap(String str, int left, int right) {

		char[] strArr = str.toCharArray();

		char temp = strArr[left];
		strArr[left] = strArr[right];
		strArr[right] = temp;

		return String.valueOf(strArr);
	}

}
