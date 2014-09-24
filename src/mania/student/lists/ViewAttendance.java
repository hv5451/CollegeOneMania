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

public class ViewAttendance extends Activity implements OnClickListener {
	TableLayout t1;
	SubjectDataSource s;
	AttendanceDataSource a;
	TextView tx[];
	
	/*public ViewAttendance(){
		s=new SubjectDataSource(this);
	      a=new AttendanceDataSource(this);
	}*/
	public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.viewattendance);
	      Button b=(Button)findViewById(R.id.viewBack);
	      b.setOnClickListener(this);
	      s=new SubjectDataSource(this);
	      a=new AttendanceDataSource(this);
	      s.open();
	      a.open();
	      t1=(TableLayout)findViewById(R.id.tableLayout1);
	      
	      //s.hello();
	      List<Subject> subjects=s.getAllSubject();
	      tx = new TextView[subjects.size()*2];
	      
	      TableRow[] tr = new TableRow[subjects.size()];
	      //List<Subject> subject=s.getAllSubject();
	      List<Attendance> attendances=a.getAllAttendance();
	      //Toast.makeText(this, attendances.size()+"", Toast.LENGTH_LONG).show();
	      int total,attended=0;
	      //for(int i=0;i<attendances.size();i++){
	      int i=-1;
	    	  for(int j=0;j<subjects.size()*2;j=j+2){
	    		  i++;
	    		  tx[j]=new TextView(this);
		    	  tx[j].setText(subjects.get(i).getName());
		    	  tx[j].setId(j);
	    		 List<Attendance> att=a.getSpecificAttendance(subjects.get(i).getName());
	    		 total=att.size();
	    		 if(total!=0)
	    		 {
	    		 for(int z=0;z<att.size();z++){
	    			 if(att.get(z).getStatus()==1)
	    				 attended++;
	    		 }
	    		 float per=((float)attended/total)*100;
	    		 attended=0;
	    		 tx[j+1]=new TextView(this);
	    		 tx[j+1].setText("         "+per+"");
	    		 tx[j+1].setId(j+1);
	    		 //Toast.makeText(this, per+"", Toast.LENGTH_LONG).show();
	    		 }
	    		 else
	    		 {
	    			 tx[j+1]=new TextView(this);
		    		 tx[j+1].setText("         No Lectures");
		    		 tx[j+1].setId(j+1);
	    			 //Toast.makeText(this,"There where no Lectures of "+subjects.get(j).getName(), Toast.LENGTH_LONG).show();
	    		 }
	    		 tr[i]=new TableRow(this);
	    		 tr[i].addView(tx[j]);
	    		 tr[i].addView(tx[j+1]);
	    		 t1.addView(tr[i]);
	    		 
	    		 }
	    	  }
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent intent=new Intent();
		intent.setClass(this, AttendanceActivity.class);
		startActivity(intent);
		
	}
	    	  
	      //}
	}
