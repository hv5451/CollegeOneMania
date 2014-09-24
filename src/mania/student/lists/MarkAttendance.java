package mania.student.lists;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MarkAttendance extends Activity implements OnClickListener {
	RadioGroup rg[];
	TextView[] tx;
	SubjectDataSource s;
	AttendanceDataSource a;
	TableLayout t1;
	int size;
	Button bu[];
	public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.markattendance);
	      a=new AttendanceDataSource(this);
	      s=new SubjectDataSource(this);
	      Button b=(Button)findViewById(R.id.Attend);
	      b.setOnClickListener(this);
	      a.open();
	      s.open();
	      int count=s.getCount();
	      size=count;
	      List<Subject> subject=s.getAllSubject();
	      t1=(TableLayout)findViewById(R.id.tableLayout1);
	      draw(subject);
	}
	public void draw(List<Subject> subject){
			tx = new TextView[subject.size()];
	      TableRow[] tr = new TableRow[subject.size()];
	      //RadioButton rb[]=new RadioButton[3];
	      rg=new RadioGroup[subject.size()];
	      bu=new Button[subject.size()];
	      if(subject.size()==0){
	    	  Toast.makeText(this, "No Subjects Added", Toast.LENGTH_LONG).show();
	      }
	      int j=0;
	      for(int i=0;i<subject.size();i++){
	    	  tx[i]=new TextView(this);
	    	  tx[i].setText(subject.get(i).getName());
	    	  tx[i].setId(i);
	    	  rg[i]=new RadioGroup(this);
	    	  
	    	  rg[i].setId(i);
	    	  rg[i].setOrientation(RadioGroup.HORIZONTAL);
	    	  String st[]={"P","A","N"};
	    	  //int j=0;
	    	  //RadioButton rb[]=new RadioButton[3];
	    	  //for(int j=0;j<2;j++){
	    		  RadioButton rb=new RadioButton(this);
	    		  rb.setText("P");
	    		  rb.setId(0);
	    		  rg[i].addView(rb);
	    		  RadioButton rb1=new RadioButton(this);
	    		  rb1.setText("A");
	    		  rb1.setId(1);
	    		  rg[i].addView(rb1);
	    		  bu[i]=new Button(this);
	    		  bu[i].setText("Delete");
		    	  bu[i].setOnClickListener(this);
		    	  System.out.println(subject.get(i).getId());
		    	  bu[i].setId((int) subject.get(i).getId());
	    		 /* RadioButton rb2=new RadioButton(this);
	    		  rb2.setText("N");
	    		  rb2.setChecked(true);
	    		  rb2.setId(2);
	    		  rg[i].addView(rb2);*/
	    	  //}
	    	 // rb[0].setChecked(true);
	    		  if(j>2){
	    	  tr[i]=new TableRow(this);
	    	  tr[i].addView(tx[i]);
	    	  tr[i].addView(rg[i]);
	    	  tr[i].addView(bu[i]);
	    	  t1.addView(tr[i]);
	    		  }
	    		  else{
	    			  j++;
	    			  i=-1;
	    		  }
	      }
	}
	public void onClick(View view) {
		// TODO Auto-generated method stub
		Intent intent=new Intent();
		switch(view.getId()){
		case R.id.Attend:
			/*for(int i=0;i<size;i++){
				if(rg[i].getChildAt(1).isSelected())
			}*/
			int count=0;
			for(int i=0;i<size;i++){
				if(rg[i].getCheckedRadioButtonId()!=-1){
					if(rg[i].getCheckedRadioButtonId()==0)
						//if(tx[i]!=null)
						a.insertAttendance(tx[i].getText().toString(), 1);
							//a.hello();
					else
						a.insertAttendance(tx[i].getText().toString(), 0);
				
				//Toast.makeText(this, "Attendance Marked", Toast.LENGTH_LONG).show();
				}
				
		}
			Toast.makeText(this, "Attendance Marked", Toast.LENGTH_LONG).show();
			intent.setClass(this, AttendanceActivity.class);
			startActivity(intent);
			break;
			default:
				s.SubjectDelete(view.getId());
				intent=new Intent();
				intent.setClass(this, AttendanceActivity.class);
				startActivity(intent);
	//}
		}
	}
}
//}
