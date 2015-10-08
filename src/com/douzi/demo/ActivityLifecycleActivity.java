package com.douzi.demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class ActivityLifecycleActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_activity_lifecycle);
		Log.i("douzi", "创建活动.");
	}

	@Override
	protected void onStart()
	{
		// TODO Auto-generated method stub
		super.onStart();
		Log.i("douzi", "活动开始.");
	}

	@Override
	protected void onResume()
	{
		// TODO Auto-generated method stub
		super.onResume();
		Log.i("douzi", "活动重新开始.");
	}

	@Override
	protected void onPause()
	{
		// TODO Auto-generated method stub
		super.onPause();
		Log.i("douzi", "活动暂停.");
	}

	@Override
	protected void onStop()
	{
		// TODO Auto-generated method stub
		super.onStop();
		Log.i("douzi", "活动停止.");
	}

	@Override
	protected void onDestroy()
	{
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i("douzi", "活动销毁.");
	}
}
