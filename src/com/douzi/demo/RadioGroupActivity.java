package com.douzi.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class RadioGroupActivity extends Activity
{
	private RadioGroup sub1;
	private RadioGroup sub2;
	private RadioGroup sub3;
	private TextView result;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_radio);
		findView();
		setListener();
		
	}
	
	private void findView(){
		sub1=(RadioGroup)findViewById(R.id.sub1);
		sub2=(RadioGroup)findViewById(R.id.sub2);
		sub3=(RadioGroup)findViewById(R.id.sub3);
		result =(TextView)findViewById(R.id.textview_checkbox_results);
	}
	
	private void setListener(){
		sub1.setOnCheckedChangeListener(changeListener);
		sub2.setOnCheckedChangeListener(changeListener);
		sub3.setOnCheckedChangeListener(changeListener);
	}
	
	OnCheckedChangeListener changeListener = new OnCheckedChangeListener()
	{

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId)
		{
			// TODO Auto-generated method stub
			
		}
		
	};
}
