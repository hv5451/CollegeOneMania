package mania.student.lists;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class TimeTableDataSource {
	private SQLiteDatabase database;
	private MySQLLiteHelper dbHelper;
	private String[] allColumns = { MySQLLiteHelper.COLUMN_ID,
			MySQLLiteHelper.COLUMN_DAY,MySQLLiteHelper.COLUMN_FROMTIME,MySQLLiteHelper.COLUMN_FROMTIMEMIN
			,MySQLLiteHelper.COLUMN_TOTIME,MySQLLiteHelper.COLUMN_TOTIMEMIN,MySQLLiteHelper.COLUMN_SUBJECTNAME,MySQLLiteHelper.COLUMN_TODO};
	public TimeTableDataSource(Context context) {
		dbHelper = new MySQLLiteHelper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}
	public long insertTimeTable(String day,int fromTime,int fromTimeMin,int toTime,int toTimeMin,String subjectName,String todo){
		//Toast.makeText(this, subjectName, Toast.LENGTH_LONG).show();
		ContentValues values=new ContentValues();
		values.put(MySQLLiteHelper.COLUMN_SUBJECTNAME, subjectName);
		values.put(MySQLLiteHelper.COLUMN_FROMTIME,fromTime);
		values.put(MySQLLiteHelper.COLUMN_TOTIME,toTime);
		values.put(MySQLLiteHelper.COLUMN_FROMTIMEMIN,fromTimeMin);
		values.put(MySQLLiteHelper.COLUMN_TOTIMEMIN,toTimeMin);
		values.put(MySQLLiteHelper.COLUMN_DAY,day);
		values.put(MySQLLiteHelper.COLUMN_TODO,todo);
		return database.insert(MySQLLiteHelper.TABLE_TIMETABLE, null, values);
		//return 1;
	}
	public List<TimeTable> getAllTimeTable(){
		List<TimeTable> timetables=new ArrayList<TimeTable>();
		Cursor cursor=database.query(MySQLLiteHelper.TABLE_TIMETABLE, allColumns, null, null, null, null, MySQLLiteHelper.COLUMN_FROMTIME);
		//Toast.makeText(this, "Hello", Toast.LENGTH_LONG);
		//Cursor cursor=database.rawQuery("select * from money1", null);
		cursor.moveToFirst();
		while(!cursor.isAfterLast()){
			TimeTable time=cursorToTimeTable(cursor);
			timetables.add(time);
			cursor.moveToNext();
		}
		cursor.close();
		return timetables;
		}
	public TimeTable cursorToTimeTable(Cursor cursor){
		TimeTable timetable=new TimeTable();
		//money.setId(1);
		//money.setId(cursor.getLong(0));
		//money.setDate((Date)cursor.getString(1));
		timetable.setId(cursor.getLong(0));
		timetable.setDay(cursor.getString(1));
		timetable.setFromdate(cursor.getLong(2));
		timetable.setFromdatemin(cursor.getLong(3));
		timetable.setTodate(cursor.getLong(4));
		timetable.setTodatemin(cursor.getLong(5));
		timetable.setSubjectName(cursor.getString(6));
		timetable.setTodo(cursor.getString(7));
		return timetable;
	}
	public List<TimeTable> getSpecificTimeTable(String day){
		List<TimeTable> timetable=new ArrayList<TimeTable>();
		Cursor cursor=database.rawQuery("Select * from "+MySQLLiteHelper.TABLE_TIMETABLE+" where "+MySQLLiteHelper.COLUMN_DAY+" = '"+day+"' order by "+MySQLLiteHelper.COLUMN_FROMTIME, null);
		cursor.moveToFirst();
		while(!cursor.isAfterLast()){
			TimeTable time=cursorToTimeTable(cursor);
			timetable.add(time);
			cursor.moveToNext();
		}
		cursor.close();
		return timetable;
	}
	public void TimeDelete(long id){
		System.out.println(id);
		//Cursor i=database.rawQuery("Delete from "+MySQLLiteHelper.TABLE_TIMETABLE+" where id="+id, null);
		database.delete(MySQLLiteHelper.TABLE_TIMETABLE, "id=?", new String[]{id+""});
		//return i.getCount();
	}
}
