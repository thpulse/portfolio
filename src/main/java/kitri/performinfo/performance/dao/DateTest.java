package kitri.performinfo.performance.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTest {

	public static void main(String[] args) {
		SimpleDateFormat form = new SimpleDateFormat("yyyyMMdd"); //³¯Â¥Æ÷¸ä
		Calendar cal = Calendar.getInstance();
		System.out.println(form.format(cal.getTime())); //¿À´Ã
		cal.add(cal.DATE, +30);
		System.out.println(form.format(cal.getTime())); //1´ÞµÚ
		
/*		for(int y=0; y<5; y++){
			int stmon = -60+y*12;
			SimpleDateFormat form = new SimpleDateFormat("yyyyMMdd"); //³¯Â¥Æ÷¸ä
			Calendar cal = Calendar.getInstance();
			cal.add(cal.MONTH, stmon);
			cal.add(cal.DATE, -17);
			String startM = form.format(cal.getTime()); //¿À´Ã
			System.out.println(startM);
			cal.add(cal.MONTH, +12); //1´ÞµÚ·Î ¼³Á¤
			cal.add(cal.DATE, -1);
			String endM = form.format(cal.getTime()); //1´ÞµÚ
			System.out.println(endM);
		}*/
	}

}
