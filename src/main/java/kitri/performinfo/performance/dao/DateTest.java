package kitri.performinfo.performance.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTest {

	public static void main(String[] args) {
		SimpleDateFormat form = new SimpleDateFormat("yyyyMMdd"); //��¥����
		Calendar cal = Calendar.getInstance();
		System.out.println(form.format(cal.getTime())); //����
		cal.add(cal.MONTH, 1); //1�޵ڷ� ����
		System.out.println(form.format(cal.getTime())); //1�޵�
	}

}
