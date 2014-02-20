// Tom Walsh, simple UI test app, fluentnet.com

package com.fluentnet.uisampler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends Activity implements OnItemSelectedListener {
	public static final String TAG = "UISampler";
	private Spinner mActivitySpinner;
	private String mCurrentSpinnerValue;
	private static final String KEYBOARD_ACTIVITY = "Keyboard Activity";
	private static final String WEB_ACTIVITY = "Web Activity";
	private static final String LIST_ACTIVITY = "List Activity";
	private EditText mTextToPass;
	private Button mSubmitButton;
	public static final String MAIN_TEXT = "com.fluentnet.android.UISampler.main_text";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		addListenerOnSpinnerItemSelection();

		mTextToPass = (EditText) findViewById(R.id.textToPass);
		mSubmitButton = (Button) findViewById(R.id.btnSubmit);
		mSubmitButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// Create the intent to start the selected activity
				Class c;
				if (mCurrentSpinnerValue.equals(LIST_ACTIVITY)) {
					Log.i(TAG, "MainActivity: LIST_ACTIVITY");
					c = ListActivity.class;
				} else if (mCurrentSpinnerValue.equals(WEB_ACTIVITY)) {
					Log.i(TAG, "MainActivity: WEB_ACTIVITY");
					c = WebActivity.class;
				} else {
					Log.i(TAG, "MainActivity: KEYBOARD_ACTIVITY");
					c = KeyboardActivity.class;
				}
				Intent i = new Intent(MainActivity.this, c);

				String str = mTextToPass.getText().toString();
				i.putExtra(MainActivity.MAIN_TEXT, str);
				
				Log.d( TAG, "startActivityForResult");

				startActivityForResult(i, 0);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void addListenerOnSpinnerItemSelection() {
		Log.i( TAG, "addListenerOnSpinnerItemSelection()");
		mActivitySpinner = (Spinner) findViewById(R.id.activitySpinner);
		mActivitySpinner.setOnItemSelectedListener(this);
	}

	public void doNextActivity(View resource) {
		Log.i(TAG, "in doNextActivity");
	}

	public void onItemSelected(AdapterView<?> parent, View view, int pos,
			long id) {
		Log.i(TAG, "in MainActivity.onItemSelected");
		mCurrentSpinnerValue = (String) mActivitySpinner.getSelectedItem();
		Log.i(TAG, "MainActivity.onItemSelected mCurrentSpinnerValue = " + mCurrentSpinnerValue);
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
	}

}
