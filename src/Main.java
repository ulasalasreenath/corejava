import java.util.Arrays;


public class Main {
	
	public static void main(String[] args)
	{
		String[] strs = new String[10];
		strs[0] = "abc"; strs[1] = "cde"; strs[2] ="def";
		A a = new A();
		a.setA(5);
		a.setB(6);
		a.setStrs(strs);
		
		System.out.println("Before ");
		System.out.println(Arrays.toString(a.getStrs()));
		
		A b = new A(a);
		
		b.getStrs()[3]="ghi";
		
		System.out.println("After");
		System.out.println(Arrays.toString(a.getStrs()));
		
		
	}

}
