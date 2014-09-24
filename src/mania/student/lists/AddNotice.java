package mania.student.lists;

import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNotice extends Activity implements OnClickListener{
	EditText note;
	NoticeDataSource n;
	Calendar cal;
	public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.addnotice);
	      note=(EditText)findViewById(R.id.notice);
	      Button add=(Button)findViewById(R.id.button1);
	      Button back=(Button)findViewById(R.id.backnotice);
	      n=new NoticeDataSource(this);
	      add.setOnClickListener(this);
	      back.setOnClickListener(this);
	      cal=Calendar.getInstance();
	}
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Long id=0L;
		switch (v.getId()){
		case R.id.backnotice:
			//Toast.makeText(this, "Hello", Toast.LENGTH_LONG).show();
			Intent i=new Intent();
			i.setClass(this, NoticeActivity.class);
			startActivity(i);
			break;
		case R.id.button1:
		if(note.getText().toString().equals("")){
			Toast.makeText(this, "Enter some text "+note.getText().toString(), Toast.LENGTH_LONG).show();
		return;
		}
		String no=note.getText().toString();
		n.open();
		long day=cal.get(Calendar.DATE);
		long month=cal.get(Calendar.MONTH);
		long year=cal.get(Calendar.YEAR);
			id=n.insertNotice(month,day,year,note.getText().toString());
		if(id!=0){
			Toast.makeText(this, "Record Added", Toast.LENGTH_LONG).show();
		}
		n.close();
		Intent it=new Intent();
		it.setClass(this, NoticeActivity.class);
		startActivity(it);
	}
	}
}
