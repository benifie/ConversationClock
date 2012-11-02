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
		String timeIs = "the time is";
		if (minute == 0)
		{
            switch (hour)
            {
                case 0:
                    return String.format("%s %s", timeIs, "12 midnight");
                case 12:
                    return String.format("%s %s", timeIs, "12 noon");
            }
        }
		String amOrPm = hour >= 12 ? "(PM)" : "(AM)";
		return String.format("%s %s %s %s", timeIs, minuteString(), hourString(), amOrPm);
	}
	
	public String minuteString()
	{
		switch(minute)
		{
			case 0:
				return "";
			case 15:
				return "quarter past";
			case 30:
				return "half past";
			case 45:
				return "quarter to";
		}
		
		//from here on, minute should be a value between 1 and 59 excluding 15, 30 and 45
		String singularOrPlural = minute == 1? "minute" : "minutes";
		String toOrPast = minute < 30 ? "past" : "to";		
		
		return String.format("%s %s %s", timeValuesMappedToString.MinuteMap.get(minute), singularOrPlural, toOrPast);
	}
	
	public String hourString()
	{
		return minute > 30 ? timeValuesMappedToString.HourMap.get((hour + 1)) : timeValuesMappedToString.HourMap.get(hour);
	}
	

}


