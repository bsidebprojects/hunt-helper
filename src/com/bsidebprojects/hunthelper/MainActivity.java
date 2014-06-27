package com.bsidebprojects.hunthelper;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}
	
	public void click (View view) {
		Intent intent = new Intent("android.nfc.action.NDEF_DISCOVERED");
		
		EditText text = (EditText) findViewById(R.id.editText1);
		
		intent.setData(Uri.parse("https://nfchunt.appspot.com/f?c="+ text.getText().toString()));

		startActivity(intent);
	}
}