package com.example.testapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout;

public class SplashActivity extends Activity {

	private static int SPLASH_TIME_COlOR_CHANGE = 5000;
	private static int SPLASH_TIME_OUT = 10000;
	LinearLayout splashLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_splash);
		getActionBar().hide();

		splashLayout = (LinearLayout) findViewById(R.id.SplashLayout);
		splashLayout.setBackgroundColor(Color.GRAY);

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {

				splashLayout.setBackgroundColor(Color.WHITE);
			}
		}, SPLASH_TIME_COlOR_CHANGE);

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {

				Intent i = new Intent(SplashActivity.this, MainActivity.class);
				startActivity(i);

				finish();
			}
		}, SPLASH_TIME_OUT);
	}

}
