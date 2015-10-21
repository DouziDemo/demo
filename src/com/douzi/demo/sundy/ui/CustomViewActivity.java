package com.douzi.demo.sundy.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class CustomViewActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		//定义自定义视图
		CustomView view = new CustomView(this);
		//这是android.os.view的点击事件，CustomView也继承于了此事件
		view.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				Toast.makeText(CustomViewActivity.this, "你点击了自定义View的我", 3000).show();
			}
		});
		setContentView(view);
	}
}
