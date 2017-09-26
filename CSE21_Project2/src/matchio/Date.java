package matchio;

public class Date {
	private int month;
	private int day;
	private int year;
	private int daysinmonth;
	private int ageDays = 0;

	public Date(int month, int day, int year) {
		setMonth(month);
		setDay(day);
		setYear(year);
	}
	
	public void dayOfYear() {
		 switch (month) {
		 case 12 : daysinmonth = 31;
		 case 11 : daysinmonth = 30;
		 case 10 : daysinmonth = 31;
		 case 9	: daysinmonth = 30;
		 case 8 : daysinmonth = 31;
		 case 7 : daysinmonth = 31;
		 case 6 : daysinmonth = 30;
		 case 5 : daysinmonth = 31;
		 case 4 : daysinmonth = 30;
		 case 3 : daysinmonth = 31;
		 case 2 : daysinmonth = 28;
		 case 1 : daysinmonth = 31; 
		 }
	}

	public int dayOfYear(int month) {
		 int totalDays = 0;
		 for (int i = 0; i < month; i++){
		 switch (i) {
		 case 12 : totalDays += 31;
		 case 11 : totalDays += 30;
		 case 10 : totalDays += 31;
		 case 9	: totalDays += 30;
		 case 8 : totalDays += 31;
		 case 7 : totalDays += 31;
		 case 6 : totalDays += 30;
		 case 5 : totalDays += 31;
		 case 4 : totalDays += 30;
		 case 3 : totalDays += 31;
		 case 2 : totalDays += 28;
		 case 1 : totalDays += 31; 
		 }
		 }
		 totalDays += day;
		 return totalDays; 
	}
	
	public void setMonth(int month) {
		if (month > 0 && month < 13)
			this.month = month;
		else {
			month = 0;
		}
	}

	public int getMonth() {
		return month;
	}

	public void setDay(int day) {
		dayOfYear();
		if (day > 0 && day < daysinmonth)
			this.day = day;
		else {
			day = 0;
		}
	}

	public int getDay() {
		return day;
	}
	
	public void setYear(int year) {
		if (year > 1900 && year < 3000)
			this.year = year;
		else {
			year = 0;
		}
	}

	public int getYear() {
		return year;
	}
	
	public int calcAgeDays(){
		int ageMon = ((2017 - year) * 12);
		
		ageDays = ageMon - month;
		
		return ageDays;
	}
	
}
