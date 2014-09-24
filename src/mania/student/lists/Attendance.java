package mania.student.lists;

public class Attendance {
private long id;
private String SubjectName;
private long status;

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}
public String getSubjectName(){
	return SubjectName;
}
public void setSubjectName(String SubjectName){
	this.SubjectName=SubjectName;
}
public long getStatus(){
	return status;
}
public void setStatus(long status){
	this.status=status;
}
}
