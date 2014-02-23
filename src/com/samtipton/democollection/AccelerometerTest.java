package com.samtipton.democollection;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AccelerometerTest extends Activity implements SensorEventListener {
	TextView textView;
	StringBuilder builder = new StringBuilder();
	int screenRotation;
	static final int ACCELEROMETER_AXIS_SWAP[][] = {
		{1, -1, 0, 1},  // ROTATION_0
		{-1, -1, 1, 0}, // ROTATION_90
		{-1, 1, 0, 1},  // ROTATION_180
		{1, 1, 1, 0}};  // ROTATION_270
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		textView = new TextView(this);
		textView.setTextSize(50);		
		RelativeLayout rl = new RelativeLayout(this);
		rl.setGravity(Gravity.CENTER);
		rl.addView(textView);
		
		setContentView(rl);
		
		SensorManager manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		
		if (manager.getSensorList(Sensor.TYPE_ACCELEROMETER).size() == 0) {
			textView.setText("No accelerometer installed");
		} else {
			Sensor accelerometer = manager.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
			
			if(!manager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME)) {
				textView.setText("Couldn't register sensor listener");
			}
		}
	}
	
	public void onSensorChanged(SensorEvent event) {
		final int[] as = ACCELEROMETER_AXIS_SWAP[screenRotation];
		float x = (float)as[0] * event.values[as[2]];
		float y = (float)as[1] * event.values[as[3]];
		float z = event.values[1];
		
		builder.setLength(0);
		builder.append("x: ");
		builder.append(x);
		builder.append("\ny: ");
		builder.append(y);
		builder.append("\nz: ");
		builder.append(z);
		textView.setText(builder.toString());

	}
	
	public void onResume() {
		super.onResume();
		WindowManager windowMgr = (WindowManager)getSystemService(Activity.WINDOW_SERVICE);
		/* getOrientation() is deprecated in Android 8 but is the same as getRotation()
		   which is the rotation from the natural oreintation of the device */
		screenRotation = windowMgr.getDefaultDisplay().getRotation();
	}
	
	
	
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// nothing to do here
	}
}
