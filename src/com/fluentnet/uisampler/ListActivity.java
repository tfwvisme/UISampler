package com.fluentnet.uisampler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ListActivity extends Activity {
	public static final String TAG = "UISampler";
	private ListView mListView;
	private Button mBackButton;
	private String mSelected;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);

		String[] values = new String[] { "1.5 Cupcake", "1.6 Donut",
				"2.0 Eclair", "2.1 Eclair", "2.2 Froyo", "2.3 Gingerbread",
				"3 Honeycomb", "4.0 Ice Cream Sandwich", "4.1 Jelly Bean",
				"4.2 Jelly Bean", "4.3 Jelly Bean", "4.4 KitKat" };

		mListView = (ListView) findViewById(R.id.verList);

		// Define a new Adapter
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, values);

		// Assign adapter to the ListView
		mListView.setAdapter(adapter);

		// ListView item click listener
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// ListView clicked item index
				int itemPosition = position;

				// ListView clicked item value
				String itemValue = (String) mListView
						.getItemAtPosition(position);

				// Show Alert
				Log.i(TAG, "ListActivity: onItemClick itemPosition = "
						+ itemPosition + " itemValue = " + itemValue);
				mSelected = itemValue;
			}
		});

		mBackButton = (Button) findViewById(R.id.btnBack);
		mBackButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.i(TAG, "ListActivity: returning mSelected" + mSelected);
				Intent returnIntent = new Intent();
				returnIntent.putExtra("SelectedAndroidVersion", mSelected);
				setResult(RESULT_OK, returnIntent);
				
				finish();
			}
		});

	}

	/*
	 * @Override protected void onCreate(Bundle savedInstanceState) {
	 * super.onCreate(savedInstanceState);
	 * setContentView(R.layout.activity_list);
	 * 
	 * mListView = (ListView) findViewById(R.id.verList); String[] values = new
	 * String[] { "1.5 Cupcake", "1.6 Donut", "2.0 Eclair", "2.1 Eclair",
	 * "2.2 Froyo", "2.3 Gingerbread", "3 Honeycomb", "4.0 Ice Cream Sandwich",
	 * "4.1 Jelly Bean", "4.2 Jelly Bean", "4.3 Jelly Bean", "4.4 KitKat" };
	 * 
	 * // Define a new Adapter ArrayAdapter<String> adapter = new
	 * ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
	 * android.R.id.text1, values);
	 * 
	 * // Assign adapter to the ListView mListView.setAdapter(adapter);
	 * 
	 * // ListView item click listener mListView.setOnItemClickListener(new
	 * OnItemClickListener() {
	 * 
	 * @Override public void onItemClick(AdapterView<?> parent, View view, int
	 * position, long id) { // ListView clicked item index int itemPosition =
	 * position;
	 * 
	 * // ListView clicked item value String itemValue =
	 * (String)mListView.getItemAtPosition(position);
	 * 
	 * // Show Alert Log.i(TAG, "ListActivity: onItemClick itemPosition = " +
	 * itemPosition + " itemValue = " + itemValue); } });
	 * 
	 * }
	 */

}