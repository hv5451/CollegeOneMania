package mania.student.lists;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.format.DateFormat;
import android.widget.Toast;

public class MoneyDataSource {
	String query="Select total from "+ MySQLLiteHelper.TABLE_MONEY +" order by ROWID DESC limit 1";
	private SQLiteDatabase database;
	private MySQLLiteHelper dbHelper;
	private String[] allColumns = { MySQLLiteHelper.COLUMN_ID,
			MySQLLiteHelper.COLUMN_MONTH,MySQLLiteHelper.COLUMN_DAY,MySQLLiteHelper.COLUMN_YEAR,MySQLLiteHelper.COLUMN_MONEY,MySQLLiteHelper.COLUMN_COMMENTS,
			MySQLLiteHelper.COLUMN_TOTAL,MySQLLiteHelper.COLUMN_STATUS};

	public MoneyDataSource(Context context) {
		dbHelper = new MySQLLiteHelper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}
	
	public long insertMoney(long month,long day,long year,long money,String comments,long total,long status){
		ContentValues values=new ContentValues();
		values.put(MySQLLiteHelper.COLUMN_MONTH, month);
		values.put(MySQLLiteHelper.COLUMN_DAY, day);
		values.put(MySQLLiteHelper.COLUMN_YEAR, year);
		values.put(MySQLLiteHelper.COLUMN_MONEY, money);
		values.put(MySQLLiteHelper.COLUMN_COMMENTS, comments);
		values.put(MySQLLiteHelper.COLUMN_TOTAL, total);
		values.put(MySQLLiteHelper.COLUMN_STATUS, status);
		return database.insert(MySQLLiteHelper.TABLE_MONEY, null, values);
	}
	
	public long getLastTotal(){
		Cursor c = database.rawQuery(query, null);
		if(c!=null && c.moveToFirst()){
			return c.getLong(0);
		}
		else
			return 0;
	}
	public List<Money> getAllMoney(){
	List<Money> mon=new ArrayList<Money>();
	Cursor cursor=database.query(MySQLLiteHelper.TABLE_MONEY, allColumns, null, null, null, null, null);
	//Toast.makeText(this, "Hello", Toast.LENGTH_LONG);
	//Cursor cursor=database.rawQuery("select * from money1", null);
	cursor.moveToFirst();
	while(!cursor.isAfterLast()){
		Money money=cursorToMoney(cursor);
		mon.add(money);
		cursor.moveToNext();
	}
	cursor.close();
	return mon;
	}
	public Money cursorToMoney(Cursor cursor){
		Money money=new Money();
		//money.setId(1);
		//money.setId(cursor.getLong(0));
		//money.setDate((Date)cursor.getString(1));
		money.setMoney(cursor.getLong(4));
		money.setComments(cursor.getString(5));
		money.setTotal(cursor.getLong(6));
		money.setStatus(cursor.getLong(7));
		return money;
	}
	
	public List<Money> getSpecificMoney(long month,long day,long year){
		List<Money> mon=new ArrayList<Money>();
		Cursor cursor=database.rawQuery("Select * from "+MySQLLiteHelper.TABLE_MONEY+" where "+MySQLLiteHelper.COLUMN_MONTH+" = "+
		month+" and "+ MySQLLiteHelper.COLUMN_DAY+" = "+day+" and "+MySQLLiteHelper.COLUMN_YEAR+" = "+year, null);
		cursor.moveToFirst();
		while(!cursor.isAfterLast()){
			Money money=cursorToMoney(cursor);
			mon.add(money);
			cursor.moveToNext();
		}
		cursor.close();
		return mon;
	}
}
