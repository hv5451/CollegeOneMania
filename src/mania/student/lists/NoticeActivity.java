package mania.student.lists;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class NoticeActivity extends Activity implements OnClickListener{
	NoticeDataSource n;
	TableLayout t1;
	public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.notice);
	      Button b=(Button)findViewById(R.id.addnotice);
	      Button ba=(Button)findViewById(R.id.BackNote); 
	      b.setOnClickListener(this);
	      ba.setOnClickListener(this);
	      n=new NoticeDataSource(this);
	      n.open();
	      int count=n.getCount();
	      List<Notice> notice=n.getAllNotice();
	      t1=(TableLayout)findViewById(R.id.tableLayout1);
	      draw(notice,count);
}
	public void draw(List<Notice> notice,int count){
		TextView[] tx = new TextView[notice.size()];
	      TableRow[] tr = new TableRow[notice.size()];
	      if(notice.size()==0){
	    	  Toast.makeText(this, "No Notices", Toast.LENGTH_LONG).show();
	    	  TextView tx1=new TextView(this);
	    	  tx1.setText("No Notices for You");
	    	  TableRow tr1=new TableRow(this);
	    	  tr1.addView(tx1);
	      }
	      int k=0;
	      if(notice.size()>10){
	    	  k=notice.size()-10;
	      }
	      for(int i=k;i<notice.size();i++){
	    	  tx[i]=new TextView(this);
	    	  tx[i].setText(notice.get(i).getNotice());
	    	  tr[i]=new TableRow(this);
	    	  tr[i].addView(tx[i]);
	    	  t1.addView(tr[i]);
	      }
	      
	}
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i;
		switch (v.getId()){
		case R.id.addnotice:
			i=new Intent();
			i.setClass(this,AddNotice.class);
			startActivity(i);
			break;
		case R.id.BackNote:
			i=new Intent();
			i.setClass(this,ManiaActivity.class);
			startActivity(i);
		}
	}
}