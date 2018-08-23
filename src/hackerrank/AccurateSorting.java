package hackerrank;

import java.util.Scanner;

public class AccurateSorting {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int q = sc.nextInt();
		
		for(int i = 0; i < q; i++)
		{
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int j = 0; j < n; j++)
			{
				arr[j] = sc.nextInt();
			}
			
			checkSort(arr);
		}
		
		sc.close();
	}

	private static void checkSort(int[] arr) {
		
		for(int i = 0; i < arr.length-1; i++)
		{
			if((arr[i] > arr[i+1]) && Math.abs(arr[i] - arr[i+1]) == 1 ) {
				
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
				
			} else
			{
				System.out.println("NO");
				return;
			}
		}
		
	}

}
