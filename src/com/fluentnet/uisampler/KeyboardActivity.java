package com.fluentnet.uisampler;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class KeyboardActivity extends Activity {
	private String mMainStr;
	private EditText mTextFromMain;
	private EditText mCenterText;
	private EditText mBottomText;
	private Button mBackButton;
	private Button mHideButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_keyboard);
		
		mMainStr = getIntent().getStringExtra(MainActivity.MAIN_TEXT);
		
		mTextFromMain = (EditText)findViewById(R.id.textFromMain);
		mTextFromMain.setText(mMainStr);
		mTextFromMain.setOnFocusChangeListener(new View.OnFocusChangeListener() {
		    @Override
		    public void onFocusChange(View v, boolean hasFocus) {
		        if (hasFocus) {
		        	Log.i("sara", "in mTextFromMain:onFocusChange");
		            //dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
		    	    ((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE))
		            .showSoftInput(mCenterText, InputMethodManager.SHOW_FORCED);
		        }
		    }
		});

		mCenterText = (EditText)findViewById(R.id.centerText);
		//InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		//mgr.showSoftInput(mCenterText, InputMethodManager.SHOW_IMPLICIT);
	    ((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE))
        .showSoftInput(mCenterText, InputMethodManager.SHOW_FORCED);
	    
		mBottomText = (EditText)findViewById(R.id.bottomText);
	    ((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE))
        .showSoftInput(mBottomText, InputMethodManager.SHOW_FORCED);
	    
		mBackButton = (Button)findViewById(R.id.btnBack);
		mBackButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
		mHideButton = (Button)findViewById(R.id.btnHide);
		mHideButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				InputMethodManager imm = (InputMethodManager)getSystemService(
					Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(mTextFromMain.getWindowToken(), 0);
			}
		});
		
	}
}
