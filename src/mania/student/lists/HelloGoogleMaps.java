package mania.student.lists;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

import android.app.*;
import android.os.Bundle;

public class HelloGoogleMaps extends MapActivity {

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.googlemap);
	    MapView mapView = (MapView) findViewById(R.id.mapview);
	    mapView.setBuiltInZoomControls(true);
	}
}
