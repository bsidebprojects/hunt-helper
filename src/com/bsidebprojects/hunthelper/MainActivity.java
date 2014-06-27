package com.bsidebprojects.hunthelper;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}
	
	public void click (View view) {
		Intent intent = new Intent("android.nfc.action.NDEF_DISCOVERED");
		intent.setData(Uri.parse("https://nfchunt.appspot.com/f?c="+ ((Button)view).getText().toString()));

		startActivity(intent);
	}
	public void clickVend (View view) {
		Intent intent = new Intent("android.nfc.action.NDEF_DISCOVERED");
		//intent.setClassName("com.google.wolff.androidhunt2", "com.google.wolff.androidhunt.NoBleButtonActivity");
		intent.putExtra("com.google.wolff.androidhunt.MESSAGE", "vend");

		startActivity(intent);
	}

}