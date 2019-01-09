package com.phq.frame.util.date;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class DateTools {

	public final static Date getDate(String strDate,String dateFormat) throws Exception {
        // = new java.util.Date();
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        Date da = formatter.parse(strDate);
       
        return da;
    }
	
	public final static Timestamp string2Time(String dateString)
			throws ParseException {
		DateFormat dateFormat;
		// dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss.SSS",
		// Locale.ENGLISH);//设定格式
		dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(false);
		Date timeDate = dateFormat.parse(dateString);// util类型
		Timestamp dateTime = new Timestamp(timeDate.getTime());// Timestamp类型,timeDate.getTime()返回一个long型
		return dateTime;
	}
	
	static void fun1()
	{
		GregorianCalendar gcal = new GregorianCalendar(); // 获得当前时间
		 
		// 设定格式yyyy-mm-dd hh:mm:<a href="https://www.baidu.com/s?wd=ss&tn=44039180_cpr&fenlei=mv6quAkxTZn0IZRqIHckPjm4nH00T1d9rjnLuhnsnADLrju9njcs0AP8IA3qPjfsn1bkrjKxmLKz0ZNzUjdCIZwsrBtEXh9GuA7EQhF9pywdQhPEUiqkIyN1IA-EUBtknWnLrHfYPH63njDknWc1nHT4" target="_blank" class="baidu-highlight">ss</a>
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 
		Date date = gcal.getTime(); // 将当前时间转成日期对象
		 
		String datetime = df.format(date); // 获得符合格式的字符串，当前日期时间
		 
		int index = datetime.indexOf(" ");
		String selectday = datetime.substring(0, index); // 当前日期
		 
		// 将当前日期换成Timestamp对象
		// string的类型必须形如： yyyy-mm-dd hh:mm:<a href="https://www.baidu.com/s?wd=ss&tn=44039180_cpr&fenlei=mv6quAkxTZn0IZRqIHckPjm4nH00T1d9rjnLuhnsnADLrju9njcs0AP8IA3qPjfsn1bkrjKxmLKz0ZNzUjdCIZwsrBtEXh9GuA7EQhF9pywdQhPEUiqkIyN1IA-EUBtknWnLrHfYPH63njDknWc1nHT4" target="_blank" class="baidu-highlight">ss</a>[.f...] 这样的格式，中括号表示可选，// 否则报错！！！
		Timestamp nowdatetime = Timestamp.valueOf(datetime);
		int i=0;
	}
	
	public final static Timestamp getExpiretime() throws ParseException
	{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 3);
		Date expiretime = calendar.getTime();
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datetime = df.format(expiretime);
		Timestamp time = Timestamp.valueOf(datetime);
		Timestamp timeStamp = new Timestamp(expiretime.getTime());
		return timeStamp;
	}
	
	public final static String formatTime(String strTime) throws ParseException
	{
		Timestamp ts = null;
		
		try{
			ts = Timestamp.valueOf(strTime);
		}
		catch(Exception e)
		{
			return "";
		}
		
		Date date = ts;
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datetime = df.format(date);
		
		return datetime;
	}
	
	
	public final static String timestamp2LocalTimeString(long timestamp) {
        try{
            Calendar calendar = Calendar.getInstance();
            //TimeZone tz = TimeZone.getTimeZone("GMT");
            TimeZone tz =TimeZone.getTimeZone("Asia/Shanghai");
            TimeZone.setDefault(tz);
            calendar.setTimeInMillis(timestamp);
            //long time = calendar.getTimeInMillis();
            //int of =  tz.getOffset(calendar.getTimeInMillis());
            //calendar.add(Calendar.MILLISECOND, tz.getOffset(calendar.getTimeInMillis()));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setTimeZone(tz);
            Date currenTimeZone = (Date) calendar.getTime();
            return sdf.format(currenTimeZone);
        }catch (Exception e) {
        }
        return "";
    }
	
	public final static String AddDay(String strDate,int days,String dateFormat) throws Exception{
		
		Date da = getDate(strDate, dateFormat);
		return AddDay(da,days,dateFormat);
	}
	public final static String AddDay(Date da,int days,String dateFormat){
		Calendar c = Calendar.getInstance();   
		c.setTime(da);
        c.add(Calendar.DAY_OF_WEEK, days);
        Date date = c.getTime();
		DateFormat df = new SimpleDateFormat(dateFormat);

		String result = df.format(date) ;
		
	    return result;
	}
	public final static Date AddDay(Date da,int days) throws Exception{
		
		Calendar c = Calendar.getInstance();   
		c.setTime(da);
        c.add(Calendar.DAY_OF_WEEK, days);
        return c.getTime();
	}
	public final static String getDateString(Date da,String dateFormat) throws Exception {
        // = new java.util.Date();
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        String result = formatter.format(da);
       
        return result;
    }
	
	public final static String nowString(){
		Date currentTime = new Date();
		SimpleDateFormat formatter=null;
		try{
			formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return formatter.format(currentTime);
    }	
	
	public final static String getWeekShortString(Date da){
		 Calendar calendar = Calendar.getInstance();
		 calendar.setTime(da);
		 
	     int week = calendar.get(Calendar.DAY_OF_WEEK);
	     String result = "";
	     switch(week){
	     	case Calendar.SUNDAY:
	     		result = "日";
	     		break;
	     	case Calendar.MONDAY:
	     		result = "一";
	     		break;
	     	case Calendar.TUESDAY:
	     		result = "二";
	     		break;
	     	case Calendar.WEDNESDAY:
	     		result = "三";
	     		break;
	     	case Calendar.THURSDAY:
	     		result = "四";
	     		break;
	     	case Calendar.FRIDAY:
	     		result = "五";
	     		break;
	     	case Calendar.SATURDAY:
	     		result = "六";
	     		break;
	     }
	     return result;
	}
	
	public final static String nowDateString() throws Exception {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(currentTime);
    }
	
	
}
