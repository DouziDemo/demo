package com.douzi.demo.thread;

import com.douzi.demo.R;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
/**
 * 发送通知
 * @author Administrator
 *
 */
public class NotificationActivity extends Activity
{
	private Button notificationButton;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_notification);
		notificationButton = (Button)findViewById(R.id.button_notification);
		notificationButton.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				sendNotification();
			}
		});
	}
	
	/**
	 * 发送一个Notification通知
	 */
	private void sendNotification(){
		//得到系统的Notification服务对象
		NotificationManager manager = (NotificationManager)this.getSystemService(Context.NOTIFICATION_SERVICE);
		//创建一个Notification对象
		Notification notification = new Notification();
		//设置显示Notification对象的图标
		notification.icon = R.drawable.ic_launcher;
		//设置显示Notification对象的内容
		notification.tickerText = "您有一条新的短消息！";
		notification.defaults = Notification.DEFAULT_SOUND;
		//设置显示Notification对象的声音
		notification.audioStreamType = android.media.AudioManager.ADJUST_LOWER;
		// FLAG_AUTO_CANCEL表明当通知被用户点击时，通知将被清除。
		notification.flags = Notification.FLAG_AUTO_CANCEL;
		//定义单击Notification的事件Intent
		Intent intent = new Intent(this, NotificationActivity.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
		//单击状态樯的图标出现的提示信息设置
		notification.setLatestEventInfo(this, "短消息内容", "我是一个短消息, 愚人节快乐!", pendingIntent);
		//发送Notification消息
		manager.notify(1, notification);
	}

}
