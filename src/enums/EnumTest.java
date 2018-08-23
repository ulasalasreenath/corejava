package enums;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class EnumTest {

	public enum Day {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY}
	
	Day day;
	
	public EnumTest(Day day)
	{
		this.day = day;
	}
	
	public void tellItLikeItis()
	{
		switch(day){
			
		case MONDAY: System.out.println("Monday");
					break;
		case FRIDAY: System.out.println("Friday"); break;
		case SATURDAY: 
		case SUNDAY: System.out.println("Weekends are best.");break;
		default: System.out.println("Midweek days are so-so.");break;
		
		}
		
	}
	
	public static void main(String[] args)
	{
		EnumTest firstDay = new EnumTest(Day.MONDAY);
		firstDay.tellItLikeItis();
		EnumTest thirdDay = new EnumTest(Day.WEDNESDAY);
		thirdDay.tellItLikeItis();
		EnumTest sixthDay = new EnumTest(Day.SATURDAY);
		sixthDay.tellItLikeItis();
		EnumTest seventhDay = new EnumTest(Day.SUNDAY);
		seventhDay.tellItLikeItis();
		
	}
}
