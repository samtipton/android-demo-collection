package com.samtipton.democollection;

import java.io.IOException;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class SoundPoolTest extends Activity implements OnTouchListener {
	SoundPool soundPool;
	int soundID = -1;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
		textView.setOnTouchListener(this);
		setContentView(textView);
		
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		soundPool = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);
		
		try {
			AssetManager assetManager = getAssets();
			AssetFileDescriptor descriptor = assetManager.openFd("bitten.ogg");
			soundID = soundPool.load(descriptor, 1);
		} catch (IOException e) {
			textView.setText("Couldn't load sound effect from asset, " + e.getMessage());
		}
		finally {
			textView.setText("Touch to the screen to hear a sound!");
		}
	}
	
	public boolean onTouch(View v, MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_UP) {
			if(soundID != -1) {
				soundPool.play(soundID, 1, 1, 0, 0, 1);
			}
		}
		return true;
	}
}
