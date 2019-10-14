package coding.questions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class ISODateTest {

	public static void main(String[] args) {
		Date d=new Date();
		String out=toISO8601UTC(d);
		System.out.println("out:"+out);
		Date d1=fromISO8601UTC("2019-08-18T18:34:18.492Z");
		System.out.println("D1:"+d1);

	}
	
	public static String toISO8601UTC(Date date) {
		  TimeZone tz = TimeZone.getTimeZone("UTC");
		  DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
		  df.setTimeZone(tz);
		  return df.format(date);
		}

		public static Date fromISO8601UTC(String dateStr) {
		  TimeZone tz = TimeZone.getTimeZone("UTC");
		  DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
		  df.setTimeZone(tz);
		  
		  try {
		    return df.parse(dateStr);
		  } catch (ParseException e) {
		    e.printStackTrace();
		  }
		  
		  return null;
		}
		
		/*public static void main(String args[]) throws InvalidJsonException, ParseException, InvalidTimeStampException {
		TransactionService ts=new TransactionService();
		//{"amount":"127.96","timestamp":"2019-08-18T17:27:57.293Z"}
		Map<String,String> input=new HashMap<>();
		input.put("amount", "127.96");
		input.put("timestamp", "2019-08-18T17:27:57.293Z");
		
		ts.addTransaction(input);
	}*/

}
