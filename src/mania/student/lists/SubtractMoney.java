package mania.student.lists;

import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SubtractMoney extends Activity implements OnClickListener{
	EditText with,notes;
	MoneyDataSource m;
	Calendar cal;
	public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.subtractmoney);
	      cal=Calendar.getInstance();
	      Button deposit= (Button)findViewById(R.id.withdraw);
	      Button back=(Button)findViewById(R.id.back);
	      with=(EditText)findViewById(R.id.withdrawText);
	      notes=(EditText)findViewById(R.id.notes);
	      deposit.setOnClickListener(this);
	      back.setOnClickListener(this);
	      m=new MoneyDataSource(this);
}
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
		case R.id.back:
			//Toast.makeText(this, "Hello", Toast.LENGTH_LONG).show();
			Intent i=new Intent();
			i.setClass(this, MoneyManager.class);
			startActivity(i);
			break;
		case R.id.withdraw:
		if(with.getText().toString().equals("")){
			Toast.makeText(this, "Enter some Money", Toast.LENGTH_LONG).show();
			return;
		}
		m.open();
		Date d=new Date();
		Long sub=Long.parseLong(with.getText().toString());
		long total=m.getLastTotal();
		long day=cal.get(Calendar.DATE);
		long month=cal.get(Calendar.MONTH);
		long year=cal.get(Calendar.YEAR);
		if(total!=0)
		total=total-sub;
		Long id=0L;
		if(notes.getText().toString().length()>15||notes.getText().toString().equals(""))
			Toast.makeText(this, "Enter less than 15 characters", Toast.LENGTH_LONG);
		else{
			if(!(total<0)){
				id=m.insertMoney(month,day,year,sub, notes.getText().toString(),total,0);
		}
			else
				Toast.makeText(this, "Not have enough money", Toast.LENGTH_LONG);
		if(id!=0){
			Toast.makeText(this, "Record Added", Toast.LENGTH_LONG).show();
		}
		else{
			Toast.makeText(this, "Enter less than 15 characters", Toast.LENGTH_LONG).show();
		}
		
	}
		}
}
}
