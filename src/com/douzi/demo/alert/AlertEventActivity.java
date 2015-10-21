package com.douzi.demo.alert;

import com.douzi.demo.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

public class AlertEventActivity extends Activity
{
	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_alert_event);
		tv = (TextView) findViewById(R.id.textview_alert_event);
	}

	protected void createDialog()
	{
		Dialog dialog = new AlertDialog.Builder(this).setTitle("评价对话框")
				.setIcon(android.R.drawable.btn_dialog)
				.setMessage("请对我们的服务进行评价：")
				.setPositiveButton("很好", new OnClickListener()
				{

					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						tv.setText("很好");
					}
				}).setNegativeButton("有待改进", new OnClickListener()
				{

					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						tv.setText("有待改进");
					}
				}).setNeutralButton("一般", new OnClickListener()
				{

					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						tv.setText("一般");
					}
				}).create();
		dialog.show();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0)
		{
			createDialog();
		}
		return false;
	}
}
