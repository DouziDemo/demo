package com.douzi.demo;

import com.douzi.demo.thread.DataLoadActivity;
import com.douzi.demo.utils.DouziUtil;

import android.app.Activity;
import android.os.Bundle;

public class TheadDemoActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_thread);
		// 副线程往主线程中发消息
		DouziUtil.setOnclickListener(findViewById(R.id.button_thread_handler),
				TheadDemoActivity.this, DataLoadActivity.class);
	}
}
