package com.bsidebprojects.hunthelper;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
		click( ((Button)view).getText().toString());
	}
	public void click (String key) {
		Intent intent = new Intent("android.nfc.action.NDEF_DISCOVERED");
		intent.setData(Uri.parse("https://nfchunt.appspot.com/f?c="+key));

		startActivity(intent);
	}
	
	public void clickAlert(View view) {
		final String key = ((Button)view).getText().toString();
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Warning");
		builder.setMessage("You need to enable bluetooh before continuing. When the app asks yoy to get close to the vending machine, rename other bluetooth device to 107.170.224.219 and bring them together.\n\nNote: both devices have to support BLE (Nexus 4, Nexus 5, ...)");
		builder.setPositiveButton("Accept", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				click(key);
			}
		});
		builder.setNegativeButton("Cancel", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
			}
		});
		builder.create().show();
	}
	
	/*public void clickVend (View view) {
		Intent intent = new Intent("android.nfc.action.NDEF_DISCOVERED");
		//intent.setClassName("com.google.wolff.androidhunt2", "com.google.wolff.androidhunt.NoBleButtonActivity");
		intent.putExtra("com.google.wolff.androidhunt.MESSAGE", "vend");

		startActivity(intent);
	}*/
}