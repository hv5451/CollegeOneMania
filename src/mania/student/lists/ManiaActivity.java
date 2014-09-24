package mania.student.lists;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ManiaActivity extends ListActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        String values[]={"Attendance Management","Calculator","Interactive Time Table","Money Manager","Map Locator","Notice Board"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,values);
        setListAdapter(adapter);

    }
    protected void onListItemClick(ListView l,View v,int position,long id){
    	String item=(String)getListAdapter().getItem(position);
    	//Toast.makeText(this, item+" Selected", Toast.LENGTH_LONG).show();
    	Intent intent=new Intent();
    	if(item.equals("Attendance Management")){
    	intent.setClass(this, AttendanceActivity.class);
    	startActivity(intent);
    	}
    	else
    		if(item.equals("Calculator")){
    			intent.setClass(this, Calculator.class);
    	    	startActivity(intent);
    	}
    		else
    			if(item.equals("Interactive Time Table")){
    				intent.setClass(this, TimeTableActivity.class);
    		    	startActivity(intent);
    			}
    			else
    				if(item.equals("Money Manager")){
    					intent.setClass(this, MoneyManager.class);
    			    	startActivity(intent);
    				}
    				else
    					if(item.equals("Map Locator")){
    						intent.setClass(this, HelloGoogleMaps.class);
    				    	startActivity(intent);
    					}
    					else
    						if(item.equals("Notice Board")){
    							intent.setClass(this, NoticeActivity.class);
    					    	startActivity(intent);
    						}
    }
}