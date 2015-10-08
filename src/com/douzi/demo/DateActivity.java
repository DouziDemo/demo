package com.douzi.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class DateActivity extends Activity
{
	private TextView dateTextView;

	private DatePicker dateDatePicker;
	
	private TextView timeTextView;

	private TimePicker timePicker;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_date);
		findView();
		setListener();
	}

	private void setListener()
	{
		//设置当日期变更的时候触发的事件
		dateDatePicker.init(1983, 11, 9, new OnDateChangedListener()
		{

			@Override
			public void onDateChanged(DatePicker view, int year,
					int monthOfYear, int dayOfMonth)
			{
				dateTextView.setText("年：" + dateDatePicker.getYear() + "\n月："
						+ (dateDatePicker.getMonth() + 1) + "\n日："
						+ dateDatePicker.getDayOfMonth());
			}

		});
		
		//设置当时间变更的时候触发的事件
		timePicker.setOnTimeChangedListener(new OnTimeChangedListener(){

			@Override
			public void onTimeChanged(TimePicker view, int hourOfDay,
					int minute)
			{
				timeTextView.setText("小时："+hourOfDay+"\n分钟："+minute);
			}
			
		});
	}

	private void findView()
	{
		dateTextView = (TextView) findViewById(R.id.textview_date);
		dateDatePicker = (DatePicker) findViewById(R.id.datepicker_date);
		timeTextView = (TextView)findViewById(R.id.textview_time);
		timePicker = (TimePicker)findViewById(R.id.timepicker_time);
	}
}
