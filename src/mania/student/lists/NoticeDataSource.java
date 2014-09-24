package mania.student.lists;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class NoticeDataSource {
	private SQLiteDatabase database;
	private MySQLLiteHelper dbHelper;
	private String[] allColumns = { MySQLLiteHelper.COLUMN_ID,
			MySQLLiteHelper.COLUMN_MONTH,MySQLLiteHelper.COLUMN_DAY,
			MySQLLiteHelper.COLUMN_YEAR,MySQLLiteHelper.COLUMN_NOTICE};
	public NoticeDataSource(Context context) {
		dbHelper = new MySQLLiteHelper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}
	public long insertNotice(long day,long month,long year,String notice){
		ContentValues values=new ContentValues();
		values.put(MySQLLiteHelper.COLUMN_MONTH,month);
		values.put(MySQLLiteHelper.COLUMN_DAY,day);
		values.put(MySQLLiteHelper.COLUMN_YEAR,year);
		values.put(MySQLLiteHelper.COLUMN_NOTICE,notice);
		return database.insert(MySQLLiteHelper.TABLE_NOTICE, null, values);
	}
	
	public List<Notice> getAllNotice(){
		List<Notice> note=new ArrayList<Notice>();
		Cursor cursor=database.query(MySQLLiteHelper.TABLE_NOTICE, allColumns, null, null, null, null, null);
		//Toast.makeText(this, "Hello", Toast.LENGTH_LONG);
		//Cursor cursor=database.rawQuery("select * from money1", null);
		cursor.moveToFirst();
		while(!cursor.isAfterLast()){
			Notice notice=cursorToNotice(cursor);
			note.add(notice);
			cursor.moveToNext();
		}
		cursor.close();
		return note;
		}
		public Notice cursorToNotice(Cursor cursor){
			Notice notice=new Notice();
			//money.setId(1);
			//money.setId(cursor.getLong(0));
			//money.setDate((Date)cursor.getString(1));
			notice.setMonth(cursor.getLong(1));
			notice.setDay(cursor.getLong(2));
			notice.setYear(cursor.getLong(3));
			notice.setNotice(cursor.getString(4));
			return notice;
		}
		public void deleteFirst(){
			//database.rawQuery("delete from notice where rowid< (Select rowid from notice limit 2,1) ", null);
			Cursor id=database.rawQuery("Select min(id) from notice",null);
			System.out.println(id.getLong(0));
			database.rawQuery("delete from notice where id=(Select min(id) from notice)",null);
		}
		public int getCount(){
			Cursor cursor=database.rawQuery("Select * from notice", null);
			return cursor.getCount();
		}
}
