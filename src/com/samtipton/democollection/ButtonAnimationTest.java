package com.samtipton.democollection;

import com.samtipton.democollection.R;
import com.samtipton.democollection.R.anim;
import com.samtipton.democollection.R.id;
import com.samtipton.democollection.R.layout;
import com.samtipton.democollection.R.menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class ButtonAnimationTest extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.button_anim_test);
		
		final Animation animTranslate = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
		final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
		final Animation animScale = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
		final Animation animRotate = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
		
		Button btnTranslate = (Button)findViewById(R.id.translate);
		Button btnAlpha = (Button)findViewById(R.id.alpha);
		Button btnScale = (Button)findViewById(R.id.scale);
		Button btnRotate = (Button)findViewById(R.id.rotate);
		
		btnTranslate.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				arg0.startAnimation(animTranslate);
			}

		});

		btnAlpha.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				arg0.startAnimation(animAlpha);
			}
		});

		btnScale.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				arg0.startAnimation(animScale);
			}
		});

		btnRotate.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				arg0.startAnimation(animRotate);
			}
		});
	}

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
