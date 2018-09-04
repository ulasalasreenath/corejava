package org.speakingcs.dp;

public class TotalNumberOfWaysToReachEnd {

	public static void main(String[] args) {

		int n = 10;
		int[] auxArr = new int[n+1];

		for (int i = 0; i < auxArr.length; i++) {
			auxArr[i] = -1;
		}

		System.out.println(getMinSteps(n, auxArr));

	}

	private static int getMinSteps(int n, int[] auxArr) {

		if (n <= 0) {
			return 0;
		}

		if (auxArr[n] > 0) {
			return auxArr[n];
		}

		auxArr[n] = 1 + getMinSteps(n - 1, auxArr) + getMinSteps(n - 2, auxArr) + getMinSteps(n - 3, auxArr);

		return auxArr[n];

	}

}
