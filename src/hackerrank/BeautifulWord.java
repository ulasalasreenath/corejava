package hackerrank;

import java.util.Scanner;

public class BeautifulWord {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		String word = sc.next();
		
		if(word.length() == 1) {
			System.out.println("Yes");
		}
		
		for(int i = 0; i < word.length() - 1; i++)
		{
			char a = word.charAt(i);
			char b = word.charAt(i+1);
			
			if(a == b)
			{
				System.out.println("No");
				return;
			}
			
			else if((a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u' || a == 'y') && (b == 'a' || b == 'e' || b == 'i' || b == 'o' || b == 'u' || b == 'y'))
			{
				System.out.println("No");
				return;
			}	
			
		}
		System.out.println("Yes");
	}
}
