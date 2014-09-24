package mania.student.lists;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddSubject extends Activity implements OnClickListener{
	SubjectDataSource s;
	EditText name;
	public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.addsubjects);
	      s=new SubjectDataSource(this);
	      name=(EditText)findViewById(R.id.SubjectName);
	      Button addSubject= (Button)findViewById(R.id.AddSubject);
	      Button back=(Button)findViewById(R.id.back);
	      addSubject.setOnClickListener(this);
	      back.setOnClickListener(this);
	      
	}

	public void onClick(View view) {
		// TODO Auto-generated method stub
		Intent intent=new Intent();
		switch(view.getId()){
		case R.id.AddSubject:
			if(name.getText().toString().equals("")){
				Toast.makeText(this, "Enter some text "+name.getText().toString(), Toast.LENGTH_LONG).show();
			return;
			}
			String no=name.getText().toString();
			s.open();
		    long id=s.insertSubject(no);
			if(id!=0){
				Toast.makeText(this, "Record Added", Toast.LENGTH_SHORT).show();
				intent.setClass(this, AttendanceActivity.class);
				startActivity(intent);
			}
			s.close();
			break;
		case R.id.back:
			intent.setClass(this, AttendanceActivity.class);
			startActivity(intent);
			break;
	}
}
}
