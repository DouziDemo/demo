package com.douzi.demo;

import com.douzi.demo.sundy.graphic.HelloGameControlActivity;
import com.douzi.demo.sundy.ui.CustomViewActivity;
import com.douzi.demo.sundy.ui.FormWidgetActivity;
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
		
		DouziUtil.setOnclickListener(findViewById(R.id.button_sundy_custom_view),
				SundyUIActivity.this, CustomViewActivity.class);
		DouziUtil.setOnclickListener(findViewById(R.id.button_sundy_insert_image),
				SundyUIActivity.this, FormWidgetActivity.class);
		
		
		
	}
}
