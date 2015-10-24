package com.douzi.demo;

import com.douzi.demo.utils.DouziUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main);

		Button activityButton = (Button) findViewById(R.id.button_activity);
		activityButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				Intent _Intent = new Intent(MainActivity.this,
						ActivityActivity.class);
				startActivity(_Intent);
			}
		});
		DouziUtil.setOnclickListener(findViewById(R.id.button_activity2),
				MainActivity.this, ActivityActivity2.class);

		DouziUtil.setOnclickListener(findViewById(R.id.button_layout),
				MainActivity.this, LayoutActivity.class);

		DouziUtil.setOnclickListener(findViewById(R.id.button_event),
				MainActivity.this, EventActivity.class);

		DouziUtil.setOnclickListener(findViewById(R.id.button_sundy_ui),
				MainActivity.this, SundyUIActivity.class);

		DouziUtil.setOnclickListener(findViewById(R.id.button_thread),
				MainActivity.this, TheadDemoActivity.class);

	}
}
