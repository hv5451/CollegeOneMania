package mania.student.lists;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class AttendanceActivity extends Activity implements OnClickListener{
	public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.attendance);
	      Button addSubjects= (Button)findViewById(R.id.AddSubjects);
	      Button markAttend=(Button)findViewById(R.id.MarkAttend);
	      Button viewAttendance=(Button)findViewById(R.id.ViewAttendance);
	      Button back=(Button)findViewById(R.id.BA);
	      addSubjects.setOnClickListener(this);
	      markAttend.setOnClickListener(this);
	      viewAttendance.setOnClickListener(this);
	      back.setOnClickListener(this);
	}

	public void onClick(View view) {
		// TODO Auto-generated method stub
		//Toast.makeText(this, "Done", Toast.LENGTH_LONG).show();
		Intent intent=new Intent();
		switch(view.getId()){
		case R.id.AddSubjects:
			//Toast.makeText(this, "Done", Toast.LENGTH_LONG).show();
			intent.setClass(this, AddSubject.class);
			startActivity(intent);
			break;
		case R.id.MarkAttend:
			intent.setClass(this, MarkAttendance.class);
			startActivity(intent);
			break;
		case R.id.ViewAttendance:
			intent.setClass(this, ViewAttendance.class);
			startActivity(intent);
			break;
		case R.id.BA:
			intent.setClass(this, ManiaActivity.class);
			startActivity(intent);
	}
	}
}
