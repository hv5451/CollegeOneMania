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

public class DayActivity extends Activity implements OnClickListener{
	TimeTableDataSource t;
	Intent intent;
	TableLayout t1;
	String day;
	public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.dayactivity);
	      intent=new Intent();
	      t1=(TableLayout)findViewById(R.id.timetableLayout);
	      t=new TimeTableDataSource(this);
	      t.open();
	      Bundle bundle=getIntent().getExtras();
	      day=bundle.getString("Day");
	      List<TimeTable> timetable=t.getSpecificTimeTable(day);
	      draw(timetable);
	      Button b=(Button)findViewById(R.id.addTim);
	      b.setOnClickListener(this);
	}
	
	public void draw(List<TimeTable> timetable){
		Button[] b=new Button[timetable.size()];
		TextView[] tx = new TextView[timetable.size()*7];
	      TableRow[] tr = new TableRow[timetable.size()];
	      if(timetable.size()==0){
	    	  Toast.makeText(this, "No TimeTable", Toast.LENGTH_LONG).show();
	    	  TextView tx1=new TextView(this);
	    	  tx1.setText("No Timetable for You");
	    	  TableRow tr1=new TableRow(this);
	    	  tr1.addView(tx1);
	      }
	      int j=-1;
	      for(int i=0;i<timetable.size();i++){
	    	  j++;
	    	  tx[j]=new TextView(this);
	    	  tx[j].setText(timetable.get(i).getFromdate()+"");
	    	  tx[j+1]=new TextView(this);
	    	  tx[j+1].setText(":"+timetable.get(i).getFromdatemin()+"");
	    	  tx[j+2]=new TextView(this);
	    	  tx[j+2].setText("-");
	    	  tx[j+3]=new TextView(this);
	    	  tx[j+3].setText(timetable.get(i).getTodate()+"");
	    	  tx[j+4]=new TextView(this);
	    	  tx[j+4].setText(":"+timetable.get(i).getTodatemin()+"       ");
	    	  tx[j+5]=new TextView(this);
	    	  tx[j+5].setText(timetable.get(i).getSubjectName()+"        ");
	    	  tx[j+6]=new TextView(this);
	    	  tx[j+6].setText(timetable.get(i).getTodo()+"        ");
	    	  b[i]=new Button(this);
	    	  b[i].setText("Delete");
	    	  b[i].setId((int) timetable.get(i).getId());
	    	  b[i].setOnClickListener(this);
	    	  tr[i]=new TableRow(this);
	    	  tr[i].addView(tx[j]);
	    	  tr[i].addView(tx[j+1]);
	    	  tr[i].addView(tx[j+2]);
	    	  tr[i].addView(tx[j+3]);
	    	  tr[i].addView(tx[j+4]);
	    	  tr[i].addView(tx[j+5]);
	    	  tr[i].addView(tx[j+6]);
	    	  tr[i].addView(b[i]);
	    	  j=-1;
	    	  t1.addView(tr[i]);
	      }
	      
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		//Toast.makeText(this,v.getId()+"", Toast.LENGTH_LONG).show();
		switch (v.getId()){
		case R.id.addTim:
			intent.setClass(this, AddTimeTable.class);
			intent.putExtra("Day",day);
			startActivity(intent);
			break;
		default:
			//Toast.makeText(this,v.getId()+"", Toast.LENGTH_LONG).show();
			t.TimeDelete(v.getId());
			intent=new Intent();
			intent.setClass(this, TimeTableActivity.class);
			startActivity(intent);
			//List<TimeTable> timetable=t.getSpecificTimeTable(day);
			//draw(timetable);
			
			//Toast.makeText(this,i+"", Toast.LENGTH_LONG).show();
		}
		t.close();
		
	}
}
