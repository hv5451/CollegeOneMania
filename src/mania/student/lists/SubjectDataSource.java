package mania.student.lists;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class SubjectDataSource {
	private SQLiteDatabase database;
	private MySQLLiteHelper dbHelper;
	private String[] allColumns = { MySQLLiteHelper.COLUMN_ID,
			MySQLLiteHelper.COLUMN_SUBJECTNAME};
	
	public SubjectDataSource(Context context) {
		dbHelper = new MySQLLiteHelper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}
	
	public long insertSubject(String subject){
		ContentValues values=new ContentValues();
		values.put(MySQLLiteHelper.COLUMN_SUBJECTNAME, subject);
		return database.insert(MySQLLiteHelper.TABLE_SUBJECT, null, values);
	}
	
	public List<Subject> getAllSubject(){
		List<Subject> sub=new ArrayList<Subject>();
		Cursor cursor=database.query(MySQLLiteHelper.TABLE_SUBJECT, allColumns, null, null, null, null, null);
		//Toast.makeText(this, "Hello", Toast.LENGTH_LONG);
		//Cursor cursor=database.rawQuery("select * from money1", null);
		cursor.moveToFirst();
		while(!cursor.isAfterLast()){
			Subject subject=cursorToSubject(cursor);
			sub.add(subject);
			cursor.moveToNext();
		}
		cursor.close();
		return sub;
		}
		public Subject cursorToSubject(Cursor cursor){
			Subject subject=new Subject();
			subject.setId(cursor.getLong(0));
			subject.setName(cursor.getString(1));
			return subject;
		}
		public int getCount(){
			Cursor cursor=database.rawQuery("Select * from subject", null);
			return cursor.getCount();
		}
		public void SubjectDelete(long id){
			System.out.println(id);
			//Cursor i=database.rawQuery("Delete from "+MySQLLiteHelper.TABLE_TIMETABLE+" where id="+id, null);
			database.delete(MySQLLiteHelper.TABLE_SUBJECT, "id=?", new String[]{id+""});
			//return i.getCount();
		}
		
}
