package TestDate;

import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class DateTest {
	
	
	@Test
	public void test(){
		Calendar c = Calendar.getInstance();
		System.out.println(c.get(c.MONTH));
		System.out.println(c.get(c.DATE));

		
		System.out.println("3.27 - 30 days");
		
		c.set(c.DATE, c.get(c.DATE - 10));
//		System.out.println(c.get(c.MONTH));
		System.out.println(c.get(c.DATE));
	}

}
