package vo;

public class CourseVo {
	private String id;
	private String name;
	private int credit;
	private String lecturer;
	private int lecturer_insert;
	private String week;
	private int start_hour;
	private int end_hour;
	
	public int getLecturer_insert() {
		return lecturer_insert;
	}
	public void setLecturer_insert(int lecturer_insert) {
		this.lecturer_insert = lecturer_insert;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public String getLecturer() {
		return lecturer;
	}
	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public int getStart_hour() {
		return start_hour;
	}
	public void setStart_hour(int start_hour) {
		this.start_hour = start_hour;
	}
	public int getEnd_hour() {
		return end_hour;
	}
	public void setEnd_hour(int end_hour) {
		this.end_hour = end_hour;
	}
	
	
	
	
	
	
}
