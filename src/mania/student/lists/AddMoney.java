package mania.student.lists;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.*;

public class AddMoney extends Activity implements OnClickListener{
	EditText dep,notes;
	MoneyDataSource m;
	Calendar cal;
	public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.addmoney);
	      cal=Calendar.getInstance();
	      Button deposit= (Button)findViewById(R.id.deposit);
	      Button back=(Button)findViewById(R.id.back);
	      dep=(EditText)findViewById(R.id.depositText);
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
		case R.id.deposit:
		if(dep.getText().toString().equals("")){
			Toast.makeText(this, "Enter some Money "+dep.getText().toString(), Toast.LENGTH_LONG).show();
		return;
		}
		Long add=Long.parseLong(dep.getText().toString());
		m.open();
		long total=m.getLastTotal();
		total=total+add;
		long day=cal.get(Calendar.DATE);
		long month=cal.get(Calendar.MONTH);
		long year=cal.get(Calendar.YEAR);
		Long id=0L;
		if(notes.getText().toString().length()>15 || notes.getText().toString().equals("")){
			Toast.makeText(this, "Enter less than 15 characters but not null", Toast.LENGTH_LONG).show();
		return;
		}
		else{
		id=m.insertMoney(month,day,year,add, notes.getText().toString(),total,1);
		}
		if(id!=0){
			Toast.makeText(this, "Record Added", Toast.LENGTH_LONG).show();
		}
		else{
			Toast.makeText(this, "Enter less than 15 characters", Toast.LENGTH_LONG).show();
		}
		m.close();
		}
	}
		}
