package com.douzi.demo;

import com.douzi.demo.thread.DataLoadActivity;
import com.douzi.demo.thread.ImageLoadActivity;
import com.douzi.demo.thread.LoadingNotificationActivity;
import com.douzi.demo.thread.NotificationActivity;
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
		
		//使用线程加载网络图片
		DouziUtil.setOnclickListener(findViewById(R.id.button_load_network_image),
				TheadDemoActivity.this, ImageLoadActivity.class);
		
		//通知(Notification)
		DouziUtil.setOnclickListener(findViewById(R.id.button_notification),
						TheadDemoActivity.this, NotificationActivity.class);
		
		//下载通知(Notification)
		DouziUtil.setOnclickListener(findViewById(R.id.button_loading_notification),
								TheadDemoActivity.this, LoadingNotificationActivity.class);
		
	}
}
