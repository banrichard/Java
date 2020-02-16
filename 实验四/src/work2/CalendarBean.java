package work2;

import java.util.Calendar;

public class CalendarBean {
	int year = 0;
	int month = 0;
	public void setYear(int year) {
		this.year = year;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public String[] getCalendar() {
		String[] a = new String[42];
		Calendar b = Calendar.getInstance();
    	b.set(year,month - 1,1);
    	int weekday = b.get(Calendar.DAY_OF_WEEK) - 1;
    	int day = 0;
    	
    	if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
    		day = 31;
    	if(month == 4 || month == 6 || month == 9 || month == 11)
    		day = 30;
    	if(month == 2) {
    		if((year%4 == 0 && year%100 != 0) || (year%400 == 0))
    			day = 28;
    		else
    			day = 29;
    	}
    	for(int i = 0;i < weekday;i++) {
    		a[i] = " ";
    	}
    	for(int i = weekday,n =1;i < weekday + day ;i++) {
    		a[i] = String.valueOf(n);
    		n++;
    	}
    	for(int i =weekday + day;i < 42;i++) {
    		a[i] = " ";
    	}
    	return a;
	}
}
