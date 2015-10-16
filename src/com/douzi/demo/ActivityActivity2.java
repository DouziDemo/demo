package com.douzi.demo;

import com.douzi.demo.utils.DouziUtil;

import android.app.Activity;
import android.os.Bundle;

public class ActivityActivity2 extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_activity2);
		
		//Iphone Coverflow
		DouziUtil.setOnclickListener(findViewById(R.id.button_coverflow), ActivityActivity2.this, MycoverflowActivity.class);
		
		//菜单menu
		DouziUtil.setOnclickListener(findViewById(R.id.button_menu), ActivityActivity2.this, MenuActivity.class);
	}
}
