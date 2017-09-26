package matchio;

public class Preference {
	private int quietTime;
	private int music;
	private int reading;
	private int chatting;
	
	public Preference(int quietTime, int music, int reading, int chatting){
		this.quietTime = quietTime;
		this.music = music;
		this.reading = reading;
		this.chatting = chatting;
	}
	
	public int getquietTime(){
		return quietTime;
	}
	
	public int getMusic(){
		return music;
	}
	
	public int getReading(){
		return reading;
	}
	
	public int getChatting(){
		return chatting;
	}
	
	public int compare(Student st1){
		int similarity = Math.abs(quietTime - st1.pref.getquietTime());
		similarity += Math.abs(music - st1.pref.getMusic());
		similarity += Math.abs(reading - st1.pref.getReading());
		similarity += Math.abs(chatting - st1.pref.getChatting());
		return similarity;
	}
	
	
}
