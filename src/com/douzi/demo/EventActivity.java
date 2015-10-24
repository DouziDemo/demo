package com.douzi.demo;

import com.douzi.demo.event.CharGameActivity;
import com.douzi.demo.event.ValidateLoginNameActivity;
import com.douzi.demo.utils.DouziUtil;

import android.app.Activity;
import android.os.Bundle;

public class EventActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_event);
		//用户名检测
		DouziUtil.setOnclickListener(findViewById(R.id.button_validate),
				EventActivity.this, ValidateLoginNameActivity.class);
		//打字游戏 
		DouziUtil.setOnclickListener(findViewById(R.id.button_char),
				EventActivity.this, CharGameActivity.class);
	}
}
