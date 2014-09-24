package mania.student.lists;

import java.util.Date;

public class Money {
private long id;
private long month;
private long day;
private long year;
private long money;
private String comments;
private long total;
private long status;
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

public long getMoney() {
	return money;
}

public void setMoney(long money) {
	this.money = money;
}
public String getComments() {
	return comments;
}

public void setComments(String comments) {
	this.comments = comments;
}

public long getTotal() {
	return total;
}

public void setTotal(long total) {
	this.total = total;
}

public long getStatus() {
	return status;
}

public void setStatus(long status) {
	this.status = status;
}

}
