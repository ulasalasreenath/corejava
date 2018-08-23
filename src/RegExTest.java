import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegExTest {
	
	
	public static void main(String[] args)
	{
		Pattern p = Pattern.compile("\\d{4}");
		Matcher m = p.matcher("201");
		
		
		if(m.matches())
		{
			System.out.println("matched");
		} else
		{
			System.out.println("not matched");
		}
		
	}

}
