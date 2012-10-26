package talk.clock;

import java.util.Calendar;

public class ConverseClock {
	
	private Calendar now;	
	private int hour;	
	private int minute;
	private TimeValuesMappedToString timeValuesMappedToString;
	
	
	ConverseClock()
	{
		now = Calendar.getInstance();
		hour = now.get(Calendar.HOUR_OF_DAY);
		minute =  now.get(Calendar.MINUTE);	
		timeValuesMappedToString = new TimeValuesMappedToString();
	}
	
	ConverseClock(int a, int b)
	{
		now = Calendar.getInstance();
		hour = a;
		minute =  b;	
		timeValuesMappedToString = new TimeValuesMappedToString();
	}
	
	public String theTimeIs()
	{
		String theTimeIs = "the time is";
		if (hour == 0 && minute == 0)
		{
			return theTimeIs + " 12 midnight";
		}
		if (hour == 12 && minute == 0)
		{
			return theTimeIs + " 12 noon";
		}
		String amOrPm = hour >= 12 ? "(PM)" : "(AM)";
		return String.format("%s %s %s %s", theTimeIs, minuteString(), hourString(), amOrPm);
	}
	
	

	public String minuteString()
	{
		String singularOrPlural = minute == 1? "minute" : "minutes";
		if (minute <= 30 && minute != 0)
		{	if(minute == 15)
			{
				return "quarter past";
			}
			if(minute == 30)
			{
				return "half past";
			}
			return String.format("%s %s past", timeValuesMappedToString.MinuteMap.get(minute), singularOrPlural);
		}
		if (minute > 30)
		{
			if(minute == 45)
			{
				return String.format("quarter to");
			}
			return String.format("%s %s to", timeValuesMappedToString.MinuteMap.get(minute), singularOrPlural);
		}	
		return "";		
	}
	
	public String hourString()
	{
		if(minute > 30)
		{
			int x = hour + 1;
			return timeValuesMappedToString.HourMap.get(x);
		}
		return timeValuesMappedToString.HourMap.get(hour);					
	}
	

}


