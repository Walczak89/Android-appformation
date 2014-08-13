package com.example.testapplication;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class RssReader extends Activity {

	TextView articleView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rss);

		articleView = (TextView) findViewById(R.id.textViewArticle);

		Bundle b = getIntent().getExtras();
		String title = b.getString("chosenOne");
		String content = b.getString("chosenContent");

		ActionBar ab = getActionBar();
		ab.setTitle(title);
		ab.setDisplayHomeAsUpEnabled(true);

		articleView.setText(content);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			this.finish();

			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
