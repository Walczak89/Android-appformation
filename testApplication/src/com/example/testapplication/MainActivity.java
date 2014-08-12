package com.example.testapplication;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	ListView RssList;
	public static final String TAG = "MyActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getActionBar().setTitle("Ekran wyboru");

		RssList = (ListView) findViewById(R.id.listViewRSS);

		GetRssDataTask task = new GetRssDataTask();

		//task.execute("http://www.itcuties.com/feed/");
		task.execute("http://magicznyskladnik.pl/feed/");

	}
/*
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
	//	getMenuInflater().inflate(R.menu.main, menu);
	//	return true;
	//}

//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {

	//	int id = item.getItemId();
	//	if (id == R.id.action_settings) {
	//		return true;
	//	}
	//	return super.onOptionsItemSelected(item);
//	}
*/
	public class GetRssDataTask extends AsyncTask<String, Void, List<RssItem>> {

		@Override
		protected List<RssItem> doInBackground(String... urls) {

			Log.i("Start background", Thread.currentThread().getName());

			try {
				RssParse rssParse = new RssParse(urls[0]);

				return rssParse.getItems();
			} catch (Exception e) {

			}

			return null;
		}

		@Override
		protected void onPostExecute(final List<RssItem> result) {

			final ArrayAdapter<RssItem> adapter = new ArrayAdapter<RssItem>(
					MainActivity.this, android.R.layout.simple_list_item_2,
					android.R.id.text1, result) {

				@Override
				public View getView(int position, View convertView,
						ViewGroup parent) {

					View view = super.getView(position, convertView, parent);

					RssItem data = result.get(position);
					
					String entry = data.toString();
					String entry2 = data.toString2();
					
					TextView text1 = (TextView) view
							.findViewById(android.R.id.text1);
					TextView text2 = (TextView) view
							.findViewById(android.R.id.text2);
					
					text1.setText(entry);
					text2.setText(entry2);
					
					return view;
				}

			};

			RssList.setAdapter(adapter);

			OnItemClickListener mMessageClickedHandler = new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {

					RssItem given = adapter.getItem(arg2);

					Intent i = new Intent(MainActivity.this, RssReader.class);

					Bundle b = new Bundle();

					b.putString("chosenOne", given.getTitle());

					b.putString("chosenContent", given.getContent());
					i.putExtras(b);

					i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

					startActivity(i);
				}
			};

			RssList.setOnItemClickListener(mMessageClickedHandler);
		}
	}
}
