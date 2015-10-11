package com.douzi.demo;

import com.douzi.demo.sundy.graphic.HelloGameControlActivity;
import com.douzi.demo.utils.DouziUtil;

import android.app.Activity;
import android.os.Bundle;

public class SundyUIActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_sundy_ui);
		
		DouziUtil.setOnclickListener(findViewById(R.id.button_game_control),
				SundyUIActivity.this, HelloGameControlActivity.class);
	}
}
