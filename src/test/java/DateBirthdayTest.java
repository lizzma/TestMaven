import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.joda.time.Days;
import org.joda.time.LocalDate;
public class DateBirthdayTest {


	@Test
	public void sumaNumeroSucessfulTest(){
		DateBirthday date = new DateBirthday();
		int y = date.sumaNumeros(6, 7);
		assertEquals(13, y);
	}

	@Test
	public void sumaNumeroSucessfulNTest(){
		DateBirthday date = new DateBirthday();
		int y = date.sumaNumeros(6, 7);
		assertNotEquals(67, y);
	}

	@Test
	public void datesHappyBirthdayOneDay(){
		LocalDate dateHappy = new LocalDate("2016-09-15");
		DateBirthday date = new DateBirthday();
		String total=date.daysToNewBirthday(dateHappy);
		assertEquals("1", total);	
	}
	@Test
	public void datesHappyBirthdaytwodays(){
		LocalDate dateHappy = new LocalDate("2016-09-16");
		DateBirthday date = new DateBirthday();
		String total=date.daysToNewBirthday(dateHappy);
		assertEquals("2", total);	
	}
	@Test
	public void datesHappyBirthday(){
		LocalDate dateHappy = new LocalDate("2016-12-08");
		DateBirthday date = new DateBirthday();
		String total=date.daysToNewBirthday(dateHappy);
		assertEquals("85", total);	
	}
	@Test
	public void datesHappyBirthdayZerodays(){
		LocalDate dateHappy = new LocalDate("2016-09-14");
		DateBirthday date = new DateBirthday();
		String total=date.daysToNewBirthday(dateHappy);
		assertEquals("0", total);	
	}

}
