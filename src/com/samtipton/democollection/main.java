package com.samtipton.democollection;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class main extends ListActivity {

	String tests[] = {"LifeCycleTest", "SingleTouchTest", "MultiTouchTest",
			"KeyTest", "AccelerometerTest", "AssetsTest", "ExternalStoragetest",
			"SoundPoolTest", "MediaPlayerTest", "FullScreenTest", "RenderViewTest",
			"ShapeTest", "BitmapTest", "FontTest", "SurfaceViewTest", "ButtonAnimationTest", "CircleListActivity" };
	
	ListView LV;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tests));
		
	}
	
	protected void onListItemClick(ListView list, View view, int position, long id) {
		super.onListItemClick(list, view, position, id);
		String testName = tests[position];
		try {
			// original code did not paramertize clazz
			Class<?> clazz = Class.forName("com.samtipton.democollection." + testName);
			Intent intent = new Intent(this, clazz);
			startActivity(intent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
