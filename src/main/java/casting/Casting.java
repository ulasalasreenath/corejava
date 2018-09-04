package casting;

import java.util.List;

public class Casting {
	
	public static void main(String[] args)
	{
		
		Object a = 1; // ""
		
		Integer i = (Integer) a;
		
		
		System.out.println(i);

        // test for null while iterating a null list
        List<String> aList = null;
        for(String str : aList) {
            System.out.println(str);
        }

		// null to String casting
		Object test = null;
		String testStr = (String) test;
		System.out.println((String) test);

		// null to auto unboxing
        Integer i1 = null;
        int i2 = i1; // Throws Null Pointer Exception


	}

}
