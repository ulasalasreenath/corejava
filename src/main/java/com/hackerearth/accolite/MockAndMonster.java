package com.hackerearth.accolite;

public class MockAndMonster {

	public static void main(String[] args) {

		String str1 = "aaaaa";
		String str1Prefix = "aa";
		int[] str1Cost = { 1, 6, 3, 10, 2 };

		String str2 = "qwer";
		String str2Prefix = "asd";
		int[] str2Cost = {1,2,3,4};

		String str3 = "oksirok";
		String str3Prefix = "ok";
		int[] str3Cost = {4,2,5,11,12,4,6};
		

		// int amount = getAmountToPay(str1, str1Prefix, str1Cost, 0);

		int max_amount = 0;
		
		//int[] costAtEachIndex = new int[str3.length()];

		for (int i = 0; i < str1.length(); i++) {
			int amount = getAmountToPay(str1, str1Prefix, str1Cost, i);
			if (amount > max_amount) {
				max_amount = amount;
			}
		}
		System.out.println(max_amount);
		
		max_amount = 0;
		for (int i = 0; i < str3.length(); i++) {
			int amount = getAmountToPay(str3, str3Prefix, str3Cost, i);
			if (amount > max_amount) {
				max_amount = amount;
			}
		}
		
		System.out.println(max_amount);
	}

	private static int getAmountToPay(String str1, String prefix, int[] cost, int index) {
		int amount = 0;
		for (int i = index; i < str1.length();) {
			String subStr = str1.substring(i);
			if(!subStr.contains(prefix)) {
				break;
			}
			if (subStr.startsWith(prefix)) {
				amount += cost[i];
				i += prefix.length();
			} else {
				i++;
			}
		}
		return amount;
	}
	

}
