package mania.student.lists;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.app.DatePickerDialog.*;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class ViewReports extends Activity implements OnDateChangedListener{
	MoneyDataSource m;
	DatePicker d;
	DateFormat formatter;
	TableLayout tl;
	public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.viewreports);
	      d=(DatePicker)findViewById(R.id.pickDate);
	      d.init(d.getYear(), d.getMonth(), d.getDayOfMonth(), this);
	      m=new MoneyDataSource(this);
	      //Toast.makeText(this, da.toString(), Toast.LENGTH_LONG).show();
	      m.open();
	      List<Money> l=m.getAllMoney();
	      tl = (TableLayout)findViewById(R.id.tableLayout1);
	      draw(l);
	      //m.getAllMoney();
	      //Toast.makeText(this, l.size(), Toast.LENGTH_LONG).show();
	      /*TextView[] th=new TextView[4];
	      th[0]=new TextView(this);
	      th[0].setText("Money");
	      th[1]=new TextView(this);
	      th[1].setText("Notes");
	      th[2]=new TextView(this);
	      th[2].setText("Total");
	      th[3]=new TextView(this);
	      th[3].setText("Status");
	      TableRow r=new TableRow(this);
	      r.addView(th[0]);
	      r.addView(th[1]);
	      r.addView(th[2]);
	      r.addView(th[3]);
	      tl.addView(r);*/
	      /*TextView[] tx = new TextView[l.size()*4];
	      TableRow[] tr = new TableRow[l.size()];
	      final TableLayout tl = (TableLayout)findViewById(R.id.tableLayout1);
	      int j=0;
	      //Toast.makeText(this, l.size()*4+"", Toast.LENGTH_SHORT).show();
	      for(int i=0;i<l.size()*4;i=i+4){
	    	  
	    	  //j++;
	    	  tx[i]=new TextView(this);
	    	  //tx[i].setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
	    	  //tx[i].setLayoutParams(new LayoutParams(75,25));
	    	  tx[i].setText(l.get(j).getMoney()+"               ");
	    	  tx[i+1]=new TextView(this);
	    	  //tx[i+1].setLayoutParams(new LayoutParams(75,25));
	    	  tx[i+1].setText(l.get(j).getComments()+"            ");
	    	  tx[i+2]=new TextView(this);
	    	  //tx[i+2].setLayoutParams(new LayoutParams(75,25));
	    	  tx[i+2].setText(l.get(j).getTotal()+"            ");
	    	  tx[i+3]=new TextView(this);
	    	  //tx[i+3].setLayoutParams(new LayoutParams(75,25));
	    	  tx[i+3].setText(l.get(j).getStatus()+"               ");
	    	  tr[j]=new TableRow(this);
	    	  tr[j].setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
	    	  tr[j].addView(tx[i]);
	    	  tr[j].addView(tx[i+1]);
	    	  tr[j].addView(tx[i+2]);
	    	  tr[j].addView(tx[i+3]);
	    	  tl.addView(tr[j]);
	    	  //if(i!=0)
	    		  j++;
	      }*/
	      m.close();
	}
	public void onDateChanged(DatePicker arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		m.open();
		List<Money> k=m.getSpecificMoney(d.getMonth(), d.getDayOfMonth(), d.getYear());
		//Toast.makeText(this, k.size()+"", Toast.LENGTH_LONG).show();
		int count=tl.getChildCount();
		if(k.size()!=0){
			tl.removeAllViewsInLayout();
		draw(k);
		}
		else
			Toast.makeText(this, "No Records Found", Toast.LENGTH_LONG).show();
		m.close();
		//Toast.makeText(this, d.getMonth()+"", Toast.LENGTH_LONG).show();
	}
	
	public void draw(List<Money> l){
		TextView[] th=new TextView[4];
	      th[0]=new TextView(this);
	      th[0].setText("Money");
	      th[1]=new TextView(this);
	      th[1].setText("Notes");
	      th[2]=new TextView(this);
	      th[2].setText("Total");
	      th[3]=new TextView(this);
	      th[3].setText("Status");
	      TableRow r=new TableRow(this);
	      r.addView(th[0]);
	      r.addView(th[1]);
	      r.addView(th[2]);
	      r.addView(th[3]);
	      tl.addView(r);
		TextView[] tx = new TextView[l.size()*4];
	      TableRow[] tr = new TableRow[l.size()];
	      //tl = (TableLayout)findViewById(R.id.tableLayout1);

	      int j=0;
	      //Toast.makeText(this, l.size()*4+"", Toast.LENGTH_SHORT).show();
	      for(int i=0;i<l.size()*4;i=i+4){
	    	  
	    	  //j++;
	    	  tx[i]=new TextView(this);
	    	  //tx[i].setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
	    	  //tx[i].setLayoutParams(new LayoutParams(75,25));
	    	  tx[i].setText(l.get(j).getMoney()+"               ");
	    	  tx[i+1]=new TextView(this);
	    	  //tx[i+1].setLayoutParams(new LayoutParams(75,25));
	    	  tx[i+1].setText(l.get(j).getComments()+"            ");
	    	  tx[i+2]=new TextView(this);
	    	  //tx[i+2].setLayoutParams(new LayoutParams(75,25));
	    	  tx[i+2].setText(l.get(j).getTotal()+"            ");
	    	  tx[i+3]=new TextView(this);
	    	  //tx[i+3].setLayoutParams(new LayoutParams(75,25));
	    	  if(l.get(j).getStatus()==1)
	    	  tx[i+3].setText("Deposited"+"               ");
	    	  else
	    	  tx[i+3].setText("Withdrawn"+"               ");
	    	  tr[j]=new TableRow(this);
	    	  tr[j].setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
	    	  tr[j].addView(tx[i]);
	    	  tr[j].addView(tx[i+1]);
	    	  tr[j].addView(tx[i+2]);
	    	  tr[j].addView(tx[i+3]);
	    	  tl.addView(tr[j]);
	    	  //if(i!=0)
	    		  j++;
	      }
	}

}
