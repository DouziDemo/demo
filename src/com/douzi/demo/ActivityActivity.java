package com.douzi.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_activity);

		// 文本的例子
		Button textViewButton = (Button) findViewById(R.id.button_textview);

		textViewButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				Intent _Intent = new Intent(ActivityActivity.this,
						TextActivity.class);
				startActivity(_Intent);
			}
		});

		// 编辑文本的例子
		Button editTextButton = (Button) findViewById(R.id.button_edittext);

		editTextButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				Intent _Intent = new Intent(ActivityActivity.this,
						EditTextActivity.class);
				startActivity(_Intent);
			}
		});

		// 多选按钮的例子
		Button checkboxButton = (Button) findViewById(R.id.button_checkbox);

		checkboxButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				Intent _Intent = new Intent(ActivityActivity.this,
						CheckBoxActivity.class);
				startActivity(_Intent);
			}
		});

		// 多选按钮的例子
		Button radiogroupButton = (Button) findViewById(R.id.button_radiogroup);

		radiogroupButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				Intent _Intent = new Intent(ActivityActivity.this,
						RadioGroupActivity.class);
				startActivity(_Intent);
			}
		});

		/**
		 * 意图的例子 1.意图跳转 2.意图传值 3.意图返回值
		 */
		Button intentButton = (Button) findViewById(R.id.button_intent);

		intentButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				Intent _Intent = new Intent(ActivityActivity.this,
						IntentActivity.class);
				startActivity(_Intent);
			}
		});

		Button activityLifecycleButton = (Button) findViewById(R.id.button_activity_lifecycle);

		activityLifecycleButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				Intent _Intent = new Intent(ActivityActivity.this,
						ActivityLifecycleActivity.class);
				startActivity(_Intent);
			}
		});
		
		//开关、进度条、星级评价等
		Button toggleButtonButton = (Button) findViewById(R.id.button_toggle_button);

		toggleButtonButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				Intent _Intent = new Intent(ActivityActivity.this,
						ToggleButtonActivity.class);
				startActivity(_Intent);
			}
		});
		
		//时间
		Button dateButton = (Button) findViewById(R.id.button_date);

		dateButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				Intent _Intent = new Intent(ActivityActivity.this,
						DateActivity.class);
				startActivity(_Intent);
			}
		});
	}
}