package mania.student.lists;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MoneyManager extends Activity implements OnClickListener {
	MoneyDataSource m;
	public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.moneymanager);
	      Button add= (Button)findViewById(R.id.Add);
	      Button subtract=(Button)findViewById(R.id.Subtract);
	      Button reports=(Button)findViewById(R.id.viewReports);
	      TextView t=(TextView)findViewById(R.id.Balance);
	      add.setOnClickListener(this);
	      subtract.setOnClickListener(this);
	      reports.setOnClickListener(this);
	      m=new MoneyDataSource(this);
	      m.open();
	      t.setText(m.getLastTotal()+"");
	      m.close();
	}

	public void onClick(View view) {
		// TODO Auto-generated method stub
		Intent intent=new Intent();
		switch(view.getId()){
		case R.id.Add:
			intent.setClass(this, AddMoney.class);
			startActivity(intent);
			break;
		case R.id.Subtract:
			intent.setClass(this, SubtractMoney.class);
			startActivity(intent);
			break;
		case R.id.viewReports:
			intent.setClass(this, ViewReports.class);
			startActivity(intent);
		}
	}
}
