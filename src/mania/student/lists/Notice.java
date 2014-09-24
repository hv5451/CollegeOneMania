package mania.student.lists;

public class Notice {
	private long id;
	private long month;
	private long day;
	private long year;
	private String notice;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getMonth() {
		return month;
	}

	public void setMonth(long month) {
		this.month = month;
	}

	public long getDay() {
		return day;
	}

	public void setDay(long day) {
		this.day = day;
	}

	public long getYear() {
		return year;
	}

	public void setYear(long year) {
		this.year = year;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getNotice() {
		return notice;
	}

}
