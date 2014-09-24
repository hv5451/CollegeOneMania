package mania.student.lists;

public class TimeTable {
	private long id;
	private long todate,fromdate,fromdatemin,todatemin;
	private String day;
	private String todo;
	private String subjectName;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getTodate() {
		return todate;
	}
	public void setTodate(long todate) {
		this.todate = todate;
	}
	public long getFromdate() {
		return fromdate;
	}
	public void setFromdate(long l) {
		this.fromdate = l;
	}
	public long getFromdatemin() {
		return fromdatemin;
	}
	public void setFromdatemin(long fromdatemin) {
		this.fromdatemin = fromdatemin;
	}
	public long getTodatemin() {
		return todatemin;
	}
	public void setTodatemin(long todatemin) {
		this.todatemin = todatemin;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getTodo() {
		return todo;
	}
	public void setTodo(String todo) {
		this.todo = todo;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
}
