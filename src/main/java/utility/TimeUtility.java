package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtility {
	

	  public static String getYear(Date date){
		  SimpleDateFormat simpleDateformat = new SimpleDateFormat("Y"); // the day of the week abbreviated
		     return simpleDateformat.format(date);
	  }
	  
	  
	  public static String getMonth(Date date){
		  SimpleDateFormat simpleDateformat = new SimpleDateFormat("MMM"); // the day of the week abbreviated
		     return simpleDateformat.format(date);
	  }
	  
	  public static String getMonthInNumber(Date date){
		  SimpleDateFormat simpleDateformat = new SimpleDateFormat("MM"); // the day of the week abbreviated
		     return simpleDateformat.format(date);
	  }
	  
	  public static String getDate(Date date){
		  SimpleDateFormat simpleDateformat = new SimpleDateFormat("dd"); // the day of the week abbreviated
		     return simpleDateformat.format(date);
	  }
	  
	  public static String getTimeStamp(Date date){
		  SimpleDateFormat simpleDateformat = new SimpleDateFormat("hh:mm:ss"); // the day of the week abbreviated
		     return simpleDateformat.format(date);
	  }
	  public static String getTimeStamp(Date date,String format){
		  SimpleDateFormat simpleDateformat = new SimpleDateFormat(format); // the day of the week abbreviated
		     return simpleDateformat.format(date);
	  }
	 
	  public static String getTimeZone(Date date){
		  SimpleDateFormat simpleDateformat = new SimpleDateFormat("z"); // the day of the week abbreviated
		     return simpleDateformat.format(date);
	  }
	  
	  public static String getNameOfDay(Date date){
		   SimpleDateFormat simpleDateformat = new SimpleDateFormat("E"); // the day of the week abbreviated
		     return simpleDateformat.format(date);
	   }

	  public static String getTimewithTimeStamp(String text){
		  Date now = new Date();
		  if(text==null){
			  return getNameOfDay(now)+" "+getMonth(now)+" "+getDate(now)+" "+getYear(now)+" "+getTimeStamp(now)+" "+getTimeZone(now);
		  }
	       return text+" "+getNameOfDay(now)+" "+getMonth(now)+" "+getDate(now)+" "+getYear(now)+" "+getTimeStamp(now)+" "+getTimeZone(now);
	  }
	  
	  public static String getTimewithTimeStamp1(String text){
		  Date now = new Date();
		  if(text==null){
			  return getYear(now)+""+getMonthInNumber(now)+""+getDate(now)+""+getTimeStamp(now,"hh:mm");
		  }
	       return text+" "+getYear(now)+""+getMonthInNumber(now)+""+getDate(now)+"-"+getTimeStamp(now,"hh:mm");
	  }
	  
	
}
