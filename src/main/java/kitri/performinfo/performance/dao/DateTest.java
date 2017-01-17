package kitri.performinfo.performance.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTest {

	public static void main(String[] args) {
		SimpleDateFormat form = new SimpleDateFormat("yyyyMMdd"); //날짜포멧
		Calendar cal = Calendar.getInstance();
		System.out.println(form.format(cal.getTime())); //오늘
		cal.add(Calendar.MONTH, 1); //1달뒤로 설정
		System.out.println(form.format(cal.getTime())); //1달뒤
	}

}
