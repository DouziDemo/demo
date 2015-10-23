package com.douzi.demo.thread;

import com.douzi.demo.R;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RemoteViews;
/**
 * 下载通知的例子
 * @author Administrator
 *
 */
public class LoadingNotificationActivity extends Activity
{
	private Button sendButton;

	private Button clearButton;

	//通知ID
	private int notificationId = 1;

	//定义通知管理对象
	private NotificationManager nm;

	//定义通知对象
	private Notification notification;

	//记录是否进度条取消
	private Boolean isClear = false;

	//记录进度条的进度
	private int count = 0;

	//定义主线程的Handler
	private Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_loading_notification);
		sendButton = (Button) findViewById(
				R.id.button_send_loading_notification);
		clearButton = (Button) findViewById(
				R.id.button_clear_loading_notification);

		sendButton.setOnClickListener(mylistener);
		clearButton.setOnClickListener(mylistener);

		nm = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);

		notification = new Notification(R.drawable.ic_launcher, "开始下载",
				System.currentTimeMillis());
		//得到Notification的视图对象
		notification.contentView = new RemoteViews(this.getPackageName(),
				R.layout.layout_custom_loading_notification);
		//设置视图中的ProgressBar对象
		notification.contentView.setProgressBar(
				R.id.progressbar_loading_notification, 100, 0, false);
		//定义单击通知的事件
		Intent _Intent = new Intent(this, LoadingNotificationActivity.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
				_Intent, 0);
		notification.contentIntent = pendingIntent;
	}

	private OnClickListener mylistener = new OnClickListener()
	{

		@Override
		public void onClick(View v)
		{
			switch (v.getId())
			{
			case R.id.button_send_loading_notification:
				showNotification();
				handler.post(run);
				break;
			case R.id.button_clear_loading_notification:
				nm.cancel(notificationId);
				isClear = true;
				break;
			}
		}
	};

	//定义Runnable对象进行进度更新，
	Runnable run = new Runnable()
	{

		@Override
		public void run()
		{
			if (!isClear)
			{
				count++;
				notification.contentView.setProgressBar(
						R.id.progressbar_loading_notification, 100, count,
						false);
				showNotification();
				if (count < 100){
					//post延迟。此处为递归
					handler.postDelayed(run, 200);
				}
			}
		}
	};

	//显示notification
	public void showNotification()
	{
		nm.notify(notificationId, notification);
	}
}
