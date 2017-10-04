package randomStaff;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTesting {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
//		LocalDateTime localDate = LocalDateTime.now();
//		String currentDateString = localDate.toString();
//		System.out.println(localDate); //2016/11/16
		
//		LocalDateTime localDateTime = LocalDateTime.now();
//		java.util.Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(localDateTime);
//		java.sql.Timestamp timestamp = localDateTime;
//		System.out.println(timestamp);
//		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Calendar cal = Calendar.getInstance();  
		System.out.println(dateFormat.format(cal.getTime()));
		System.out.println( dateFormat.format(cal.getTime()).getClass());
		
		
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Calendar cal = Calendar.getInstance();
//		System.out.println(dateFormat.format(cal)); //2016/11/16 12:08:43
//
//		 
//		
//		java.util.Date date = new Date();
//		Object param = new java.sql.Timestamp(date.getTime());
//		
	}

}
