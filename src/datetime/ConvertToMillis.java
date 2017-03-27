package datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ConvertToMillis {

	public static void main(String[] args) throws ParseException
	{
		
		Date d = new Date(1480332102618L);
		
		System.out.println(d.toString());
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse("2016-11-28 03:21:43");
		
		System.out.println(date.getTime());	
	}
	
	
}
