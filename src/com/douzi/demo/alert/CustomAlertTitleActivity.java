package com.douzi.demo.alert;

import com.douzi.demo.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

public class CustomAlertTitleActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_custom_alert_title);
	}

	protected void createDialog()
	{
		AlertDialog.Builder b = new Builder(CustomAlertTitleActivity.this);
		b.setMessage("本程序是v1.0版本，如有问题请及时提出!");
		TextView title = new TextView(CustomAlertTitleActivity.this);
		title.setGravity(android.view.Gravity.CENTER_HORIZONTAL);
		title.setText("关于");
		AlertDialog alert = b.create();
		alert.setCustomTitle(title);
		alert.show();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		if (keyCode == KeyEvent.KEYCODE_MENU && event.getRepeatCount() == 0)
		{
			createDialog();
		}
		return false;
	}
}
