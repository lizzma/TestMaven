import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;

public class DateBirthday {

	public int sumaNumeros(int i,int j) {
		int ret = i+ j;
		return ret;
	}

	public String daysToNewBirthday(LocalDate fromDate) {
		String testdate="";
		DateTime current = new DateTime();
		String days="";
		int currentMonth = current.getMonthOfYear();
		int birthdayMonth = fromDate.getMonthOfYear();
		int currentday = current.getDayOfMonth();
		int birthdayday= fromDate.getDayOfMonth();

		if(birthdayMonth < currentMonth){
			int nextYear=current.getYear()+1;
			testdate = nextYear+"-"+fromDate.getMonthOfYear()+"-"+fromDate.getDayOfMonth();
		}if((currentday == birthdayday)&&(birthdayMonth == currentMonth)){
			days="0";
			return days;
		}else {
			testdate = current.getYear()+"-"+fromDate.getMonthOfYear()+"-"+fromDate.getDayOfMonth();
		}	
		LocalDate birthday = new LocalDate(testdate);
		LocalDate dat = new LocalDate(current);
		days=""+(Days.daysBetween(birthday, dat));
		days=StringUtils.substring(days, 2, days.length()-1);
		return days;
	}

	public void information() throws IOException{
		DateBirthday db = new DateBirthday();
		String birthday="";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please, Enter your birthday (YYYY-MM-DD)");
		birthday= br.readLine();
		while(StringUtils.isEmpty(birthday)){
			System.out.println("ERROR: Null Birthday date");
			System.out.println("Please, Enter your birthday (YYYY-MM-DD)");
			System.out.println();
			birthday= br.readLine();
		}
		LocalDate myDate = new LocalDate(birthday);
		String days=db.daysToNewBirthday(myDate);
		if(days.equals("0")){
			System.out.println("Missing "+ days +" days for your birthday");
			System.out.println("Congratulations, Happy Birthday!!!");

		}else{
			System.out.println("Missing "+ days +" days for your birthday");
		}
	}


}
