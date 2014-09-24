package mania.student.lists;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class AttendanceDataSource{
	private SQLiteDatabase database;
	private MySQLLiteHelper dbHelper;
	private String[] allColumns = { MySQLLiteHelper.COLUMN_ID,
			MySQLLiteHelper.COLUMN_SUBJECTNAME,MySQLLiteHelper.COLUMN_STATUS};
	public AttendanceDataSource(Context context) {
		dbHelper = new MySQLLiteHelper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}
	public long insertAttendance(String subjectName,long status){
		//Toast.makeText(this, subjectName, Toast.LENGTH_LONG).show();
		ContentValues values=new ContentValues();
		values.put(MySQLLiteHelper.COLUMN_SUBJECTNAME, subjectName);
		values.put(MySQLLiteHelper.COLUMN_STATUS,status);
		return database.insert(MySQLLiteHelper.TABLE_ATTENDANCE, null, values);
		//return 1;
	}
	public List<Attendance> getAllAttendance(){
		List<Attendance> attendances=new ArrayList<Attendance>();
		Cursor cursor=database.query(MySQLLiteHelper.TABLE_ATTENDANCE, allColumns, null, null, null, null, null);
		//Toast.makeText(this, "Hello", Toast.LENGTH_LONG);
		//Cursor cursor=database.rawQuery("select * from money1", null);
		cursor.moveToFirst();
		while(!cursor.isAfterLast()){
			Attendance attend=cursorToAttendance(cursor);
			attendances.add(attend);
			cursor.moveToNext();
		}
		cursor.close();
		return attendances;
		}
	public Attendance cursorToAttendance(Cursor cursor){
		Attendance attendance=new Attendance();
		//money.setId(1);
		//money.setId(cursor.getLong(0));
		//money.setDate((Date)cursor.getString(1));
		attendance.setId(cursor.getLong(0));
		attendance.setSubjectName(cursor.getString(1));
		attendance.setStatus(cursor.getInt(2));
		return attendance;
	}
	public List<Attendance> getSpecificAttendance(String name){
		List<Attendance> attendance=new ArrayList<Attendance>();
		Cursor cursor=database.rawQuery("Select * from "+MySQLLiteHelper.TABLE_ATTENDANCE+" where "+MySQLLiteHelper.COLUMN_SUBJECTNAME+" = '"+name+"'", null);
		cursor.moveToFirst();
		while(!cursor.isAfterLast()){
			Attendance attend=cursorToAttendance(cursor);
			attendance.add(attend);
			cursor.moveToNext();
		}
		cursor.close();
		return attendance;
	}
	public void AttendDelete(long id){
		//System.out.println(id);
		//Cursor i=database.rawQuery("Delete from "+MySQLLiteHelper.TABLE_TIMETABLE+" where id="+id, null);
		database.delete(MySQLLiteHelper.TABLE_ATTENDANCE, "id=?", new String[]{id+""});
		//return i.getCount();
	}
}
