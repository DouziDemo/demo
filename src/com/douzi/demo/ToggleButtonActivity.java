package com.douzi.demo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ToggleButtonActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_toggle_button);
		
		//弹出框加载条
		Button dialogProgressButton = (Button)findViewById(R.id.button_dialog_progress);
		
		dialogProgressButton.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				ProgressDialog progressDialog = new ProgressDialog(ToggleButtonActivity.this);
				progressDialog.setTitle("程序正在加载中...");
				progressDialog.show();
			}
		});
	}
}
