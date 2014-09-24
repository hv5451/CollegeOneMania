package mania.student.lists;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class TimeTableActivity extends ListActivity{
	public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      //setContentView(R.layout.attendance);
	      String values[]={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
	        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,values);
	        setListAdapter(adapter);
	}
	protected void onListItemClick(ListView l,View v,int position,long id){
    	String item=(String)getListAdapter().getItem(position);
    	//Toast.makeText(this, item+" Selected", Toast.LENGTH_LONG).show();
    	Intent intent=new Intent();
    	if(item.equals("Monday")){
    		Toast.makeText(this, item+" Selected", Toast.LENGTH_LONG).show();
    		intent.putExtra("Day", "Monday");
    		intent.setClass(this, DayActivity.class);
    		startActivity(intent);
    	}
    	else
    		if(item.equals("Tuesday")){
    			intent.putExtra("Day", "Tuesday");
        		intent.setClass(this, DayActivity.class);
        		startActivity(intent);
    	}
    		else
    			if(item.equals("Wednesday")){
    				intent.putExtra("Day", "Wednesday");
    	    		intent.setClass(this, DayActivity.class);
    	    		startActivity(intent);
    			}
    			else
    				if(item.equals("Thursday")){
    					intent.putExtra("Day", "Thursday");
    		    		intent.setClass(this, DayActivity.class);
    		    		startActivity(intent);
    				}
    				else
    					if(item.equals("Friday")){
    						intent.putExtra("Day", "Friday");
    			    		intent.setClass(this, DayActivity.class);
    			    		startActivity(intent);
    					}
    					else
    						if(item.equals("Saturday")){
    							intent.putExtra("Day", "Saturday");
    				    		intent.setClass(this, DayActivity.class);
    				    		startActivity(intent);
    						}
    						else
    							if(item.equals("Sunday")){
    								intent.putExtra("Day", "Sunday");
    					    		intent.setClass(this, DayActivity.class);
    					    		startActivity(intent);
    							}
    }
}
