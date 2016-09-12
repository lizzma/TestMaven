import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;

public class DateBirthday {

	public Days daysToNewYear(LocalDate fromDate) {
		String testdate="";
		DateTime current = new DateTime();
		int currentMonth = current.getMonthOfYear();
		int birthdayMonth = fromDate.getMonthOfYear();
		//System.out.println(currentMonth+"  --  "+birthdayMonth);
	
	   if(birthdayMonth < currentMonth){
			int nextYear=current.getYear()+1;
			testdate = nextYear+"-"+fromDate.getMonthOfYear()+"-"+fromDate.getDayOfMonth();
		}else {
			testdate = current.getYear()+"-"+fromDate.getMonthOfYear()+"-"+fromDate.getDayOfMonth();
		}	
		LocalDate birthday = new LocalDate(testdate);
		LocalDate dat = new LocalDate(current);
		return Days.daysBetween(birthday, dat);

	}
	
	public void information() throws IOException{
		DateBirthday db = new DateBirthday();
		String birthday="";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//yyyy-mm-ddTHH:MM:SS.SSS
		System.out.println("Please, Enter your birthday (YYYY-MM-DD)");
		birthday= br.readLine();
		while(StringUtils.isEmpty(birthday)){
			System.out.println("ERROR: Null Birthday date");
			System.out.println("Please, Enter your birthday (YYYY-MM-DD)");
			System.out.println();
			birthday= br.readLine();
		}
		LocalDate myDate = new LocalDate(birthday);
		Days total= db.daysToNewYear(myDate);
	
		String days=""+total;
		StringUtils.isNumeric(days);
		StringUtils.splitByCharacterType(days);
	
//		StringUtils.substring(days, 2, days.length()-1);
		System.out.println("Missing "+ StringUtils.substring(days, 2, days.length()-1) +" days for your birthday");
		
//		System.out.println("dias "+StringUtils.substring(days, 2, days.length()-1));
	}


}
