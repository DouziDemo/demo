package com.douzi.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

public class CheckBoxActivity extends Activity
{
	private CheckBox nanqiu;

	private CheckBox pingpang;

	private CheckBox zhuqiu;

	private TextView results;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_checkbox);
		//查找View
		findView();
		//设置CheckBox的监听事件（当选中或未选中的时候）
		setListener();
	}

	/**
	 * 查找View
	 */
	private void findView()
	{
		nanqiu = (CheckBox) findViewById(R.id.checkbox_nanqiu);
		pingpang = (CheckBox) findViewById(R.id.checkbox_pingpeng);
		zhuqiu = (CheckBox) findViewById(R.id.checkbox_zhuqiu);
		results = (TextView) findViewById(R.id.textview_checkbox_results);
	}

	/**
	 * 设置CheckBox的监听事件（当选中或未选中的时候）
	 */
	private void setListener()
	{
		nanqiu.setOnCheckedChangeListener(myOnCheckedChangeListener);
		pingpang.setOnCheckedChangeListener(myOnCheckedChangeListener);
		zhuqiu.setOnCheckedChangeListener(myOnCheckedChangeListener);
	}
	/**
	 * 创建一个新的选中监听事件
	 */
	OnCheckedChangeListener myOnCheckedChangeListener = new OnCheckedChangeListener()
	{

		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked)
		{
			// TODO Auto-generated method stub
			setText();
		}
	};

	/**
	 * 当监听选中或未选中的时候触发的事件（改变结果）
	 */
	private void setText()
	{
		String str;
		results.setText("");
		if (nanqiu.isChecked()){
			str = results.getText().toString() + nanqiu.getText().toString() + ",";
			results.setText(str);
		}
		
		if (pingpang.isChecked()){
			str = results.getText().toString() + pingpang.getText().toString() + ",";
			results.setText(str);
		}
		
		if (zhuqiu.isChecked()){
			str = results.getText().toString() + zhuqiu.getText().toString() + ",";
			results.setText(str);
		}
	}

}
