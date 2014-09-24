package mania.student.lists;

	import android.content.Context;
	import android.database.sqlite.SQLiteDatabase;
	import android.database.sqlite.SQLiteOpenHelper;
	import android.util.Log;

	public class MySQLLiteHelper extends SQLiteOpenHelper {

		public static final String TABLE_MONEY = "money1";
		public static final String TABLE_NOTICE="notice";
		public static final String TABLE_ATTENDANCE="attendance";
		public static final String TABLE_SUBJECT="subject";
		public static final String TABLE_TIMETABLE="timetable";
		public static final String COLUMN_ID = "id";
		public static final String COLUMN_MONTH = "month";
		public static final String COLUMN_DAY = "day";
		public static final String COLUMN_YEAR = "year";
		public static final String COLUMN_COMMENTS = "Comments";
		public static final String COLUMN_TOTAL = "Total";
		public static final String COLUMN_MONEY="money";
		public static final String COLUMN_STATUS="status";
		public static final String COLUMN_NOTICE="notice";
		public static final String COLUMN_SUBJECTNAME="SubjectName";
		public static final String COLUMN_FROMTIME="fromtime";
		public static final String COLUMN_FROMTIMEMIN="fromminutes";
		public static final String COLUMN_TOTIMEMIN="tominutes";
		public static final String COLUMN_TOTIME="totime";
		public static final String COLUMN_TODO="todo";
		private static final String DATABASE_NAME = "moneyManager4.db";
		private static final int DATABASE_VERSION = 1;

		// Database creation sql statement
		private static final String DATABASE_CREATE = "create table "
				+ TABLE_MONEY + "( " + COLUMN_ID
				+ " integer primary key autoincrement, " + COLUMN_MONTH
				+ " integer not null, "+ COLUMN_DAY
				+ " integer not null, "+ COLUMN_YEAR
				+ " integer not null, "+ COLUMN_MONEY +" integer not null, "+ COLUMN_COMMENTS +" text not null, "
				+ COLUMN_TOTAL +" integer not null, "+ COLUMN_STATUS
				+ " integer not null "+");";
		private static final String NOTICE="create table "+ TABLE_NOTICE +"( "+COLUMN_ID+" integer primary key autoincrement, "
				+ COLUMN_MONTH+" integer not null, "+COLUMN_DAY+" integer not null, "+COLUMN_YEAR+" integer not null, "+
				COLUMN_NOTICE+" text not null);";
		private static final String ATTENDANCE="create table "+ TABLE_ATTENDANCE+"( "+COLUMN_ID+" integer primary key autoincrement, "
				+ COLUMN_SUBJECTNAME+" text not null, "+ COLUMN_STATUS+" integer not null);";
		private static final String SUBJECT="create table "+ TABLE_SUBJECT+"( "+COLUMN_ID+" integer primary key autoincrement, "
				+ COLUMN_SUBJECTNAME+" text not null);";
		private static final String TIMETABLE = "create table "
				+ TABLE_TIMETABLE + "( " + COLUMN_ID
				+ " integer primary key autoincrement, " + COLUMN_DAY
				+ " text not null, "+ COLUMN_FROMTIME
				+ " integer not null, "+ COLUMN_FROMTIMEMIN
				+ " integer not null, "+ COLUMN_TOTIME
				+ " integer not null, "+ COLUMN_TOTIMEMIN
				+ " integer not null, "+ COLUMN_SUBJECTNAME 
				+ " text not null, "+ COLUMN_TODO
				+ " text not null "+");";
		public MySQLLiteHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase database) {
			database.execSQL(DATABASE_CREATE);
			database.execSQL(NOTICE);
			database.execSQL(ATTENDANCE);
			database.execSQL(SUBJECT);
			database.execSQL(TIMETABLE);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			Log.w(MySQLLiteHelper.class.getName(),
					"Upgrading database from version " + oldVersion + " to "
							+ newVersion + ", which will destroy all old data");
			db.execSQL("DROP TABLE IF EXISTS" + TABLE_MONEY);
			onCreate(db);
		}

	}
