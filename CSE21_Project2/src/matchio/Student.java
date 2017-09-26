package matchio;

public class Student {
	private String name;
	private char sex;
	Date birthDay;
	Preference pref;
	private boolean matched;
	
	
	public Student(String name, char sex) {
		
		this.name = name;
		this.sex = sex;
		Preference preference = new Preference(sex, sex, sex, sex);
		this.pref = preference;
	}
	
	public void setbday(int month, int day, int year){
		Date birthDate = new Date(month, day, year);
		this.birthDay = birthDate;
	}
	
	public void setpref(int quietTime, int music, int reading, int chatting){
		Preference pref = new Preference(quietTime, music, reading, chatting);
		this.pref = pref;
	}

	public String getName() {
		return name;
	}

	public int getSex() {
		return sex;
	}
	
	public Date getBday() {
		return birthDay;
	}
	
	public Preference getPref() {
		return pref;
	}
	
	public void setMatched(boolean matched){
		this.matched = matched; 
	}
	
	public boolean getMatched() {
		return matched;
	}
	
	public int compare(Student st1, Student st2){
		int match = 0;	
		int ageDiff;
		
		ageDiff = Math.abs(st1.birthDay.calcAgeDays() - st2.birthDay.calcAgeDays());
		if(ageDiff > 60)
			ageDiff = 60;
		
		
		
		match = (40 - pref.compare(st2)) + (60 - ageDiff);
		
		
		if (st1.getSex() != st2.getSex())
			return 0;
		if(st1.getName() == st2.getName() && st1.getBday() == st2.getBday())
			return 0;
		else 
			return match;
	}
}
