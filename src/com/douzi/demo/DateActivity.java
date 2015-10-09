package com.douzi.demo;


import java.sql.Date;
import java.text.SimpleDateFormat;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DigitalClock;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class DateActivity extends Activity
{
	//创建DatePickerDialog的标示
	private final int DATEDIALOG = 0;
	//创建TimePickerDialog的标示
	private final int TIMEDIALOG = 1;
	
	private TextView dateTextView;
	
	//日期控件
	private DatePicker dateDatePicker;
	
	private TextView timeTextView;

	//时间控件
	private TimePicker timePicker;
	
	private TextView setDateTextView;
	//日期Dialog
	private Button dateButton;
	//时间Dialog
	private Button timeButton;
	
	//AnalogClock
	private AnalogClock analogClock;
	
	//DigitalClock
	private DigitalClock digitalClock;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_date);
		findView();
		setListener();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
		Date curDate = new Date(System.currentTimeMillis());
		String str = formatter.format(curDate);
		digitalClock.setText(str);
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
		
		dateButton.setOnClickListener(mylistener);
		timeButton.setOnClickListener(mylistener);
	}
	
	OnClickListener mylistener = new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			// TODO Auto-generated method stub
			switch (v.getId())
			{
			case R.id.button_date:
				showDialog(DATEDIALOG, null);
				break;
			case R.id.button_time:
				showDialog(TIMEDIALOG, null);
			default:
				break;
			}
		}
	};
	
	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id)
		{
		case DATEDIALOG:
			DatePickerDialog dpd = new DatePickerDialog(this, new OnDateSetListener(){

				@Override
				public void onDateSet(DatePicker view, int year,
						int monthOfYear, int dayOfMonth)
				{
					setDateTextView.setText("年："+year+"\n月："+monthOfYear+"\n日："+dayOfMonth);
				}

				
			}, 1990, 10, 1);
			return dpd;
		case TIMEDIALOG:
			TimePickerDialog timePickerDialog = new TimePickerDialog(this, new OnTimeSetListener()
			{
				
				@Override
				public void onTimeSet(TimePicker view, int hourOfDay, int minute)
				{
					// TODO Auto-generated method stub
					setDateTextView.setText(setDateTextView.getText() + "\n小时："+hourOfDay+"\n分钟："+minute);
				}
			}, 12, 0, true);
			return timePickerDialog;
		default:
			break;
		}
		return super.onCreateDialog(id);
	};

	private void findView()
	{
		dateTextView = (TextView) findViewById(R.id.textview_date);
		dateDatePicker = (DatePicker) findViewById(R.id.datepicker_date);
		
		timeTextView = (TextView)findViewById(R.id.textview_time);
		timePicker = (TimePicker)findViewById(R.id.timepicker_time);
		
		setDateTextView = (TextView)findViewById(R.id.textview_setdate);
		dateButton = (Button)findViewById(R.id.button_date);
		timeButton = (Button)findViewById(R.id.button_time);
		
		analogClock = (AnalogClock)findViewById(R.id.analogclock01);
		digitalClock = (DigitalClock)findViewById(R.id.digitalclock01);
	}
}
