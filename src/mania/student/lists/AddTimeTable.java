package mania.student.lists;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class AddTimeTable extends Activity implements OnClickListener{
	TimePicker fromDate;
	TimePicker toDate;
	TextView subjectName;
	TextView toDo;
	TimeTableDataSource t;
	String day;
	Intent intent;
	public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.addtimetable);
	      fromDate=(TimePicker)findViewById(R.id.FromTime);
	      toDate=(TimePicker)findViewById(R.id.ToTime);
	      subjectName=(TextView)findViewById(R.id.SubjectName);
	      toDo=(TextView)findViewById(R.id.ToDo);
	      Button b=(Button)findViewById(R.id.AddTime);
	      b.setOnClickListener(this);
	      Bundle bundle=getIntent().getExtras();
	      day=bundle.getString("Day");
	}
	public void onClick(View v) {
		// TODO Auto-generated method stub
		t=new TimeTableDataSource(this);
		t.open();
		t.insertTimeTable(day, fromDate.getCurrentHour(), fromDate.getCurrentMinute(), toDate.getCurrentHour(), toDate.getCurrentMinute(), subjectName.getText()+"", toDo.getText()+"");
		t.close();
		intent=new Intent();
		intent.setClass(this, DayActivity.class);
		intent.putExtra("Day",day);
		startActivity(intent);
	}
}
