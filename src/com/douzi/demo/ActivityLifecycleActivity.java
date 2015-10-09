package com.douzi.demo;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ActivityLifecycleActivity extends Activity
{
	private EditText saveDataEditText;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_activity_lifecycle);
		Log.i("douzi", "创建活动.");
		Button newAcitvity = (Button)findViewById(R.id.button_newactivity);
		saveDataEditText = (EditText)findViewById(R.id.edittext_savedata);
		if (null != savedInstanceState){
			saveDataEditText.setText(savedInstanceState.getString("douzi.key"));
		}
		newAcitvity.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				Intent _Intent = new Intent(ActivityLifecycleActivity.this, ActivityActivity.class);
				//_Intent.setAction(Intent.ACTION_CALL);
				//_Intent.setData(Uri.parse("tel:13800000000"));
				startActivity(_Intent);
			}
		});
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
	
	@Override
	protected void onSaveInstanceState(Bundle outState)
	{
		// TODO Auto-generated method stub
		//super.onSaveInstanceState(outState);
		
		outState.putString("douzi.key", "豆子："+saveDataEditText.getText());
		
		Log.i("douzi", "保存状态.");
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
		Log.i("douzi", "恢复状态.");
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig)
	{
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		Log.i("douzi", "配置已经改变.");
		if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
			Log.i("douzi", "已经变为横屏.");
		}
		
	}
}
