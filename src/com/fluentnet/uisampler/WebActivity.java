package com.fluentnet.uisampler;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class WebActivity extends Activity {
	private WebView mWebView;
	private Button mGoButton;
	private Button mBackButton;
	private EditText mUrlText;
	private String mUrl ="http://my.yahoo.com";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web);
		
		Log.d( "TAG", "class WebActivity " +mUrl);
		
		mWebView = (WebView) findViewById(R.id.webView1);
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                Log.d("TAG", "shouldOverrideUrlLoading ==> "+url);
                view.loadUrl(url);
                return true;                
            }   

        });
		
		
		Log.d( "TAG", "class WebActivity loadUrl " +mUrl);
		
		mWebView.loadUrl( mUrl );
		//mWebView.loadUrl("http://www.yahoo.com");		
		
		mGoButton = (Button)findViewById(R.id.btnGo);
		mGoButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mUrlText = (EditText) findViewById(R.id.urlText);
				String str = mUrlText.getText().toString();
				mWebView.loadUrl(str);
				
				Log.d( "TAG", "class WebActivity Override onClick " +str);	
			}
		});
		
		Log.d( "TAG", "class WebActivity after " +mUrl);
		
		mBackButton = (Button)findViewById(R.id.btnBack);
		mBackButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}

}


