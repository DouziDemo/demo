package com.douzi.demo;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;

/**
 * 计时器
 * 
 * @author administrator
 *
 */
public class ChronometerActivity extends Activity
{
	private Chronometer chronometer;

	private Button startChronometerButton;

	private Button stopChronometerButton;

	private Button resetChronometerButton;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_chronometer);

		findView();

		setListener();
	}

	private void findView()
	{
		chronometer = (Chronometer) findViewById(R.id.chronometer01);
		startChronometerButton = (Button) findViewById(
				R.id.button_chronometer_start);
		stopChronometerButton = (Button) findViewById(
				R.id.button_chronometer_stop);
		resetChronometerButton = (Button) findViewById(
				R.id.button_chronometer_reset);
	}

	private void setListener()
	{
		startChronometerButton.setOnClickListener(myClickListener);
		stopChronometerButton.setOnClickListener(myClickListener);
		resetChronometerButton.setOnClickListener(myClickListener);
	}

	OnClickListener myClickListener = new OnClickListener()
	{

		@Override
		public void onClick(View v)
		{
			switch (v.getId())
			{
			// 开始
			case R.id.button_chronometer_start:
				chronometer.start();
				break;
			// 停止
			case R.id.button_chronometer_stop:
				chronometer.stop();
				break;
			// 重置
			case R.id.button_chronometer_reset:
				chronometer.setBase(SystemClock.elapsedRealtime());
				break;
			default:
				break;
			}
		}
	};
}
