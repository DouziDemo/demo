package com.douzi.demo.thread;

import com.douzi.demo.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;
/**
 * 在副线程中发消息到主线程中,主线程处理后反馈到主界面
 * @author administrator
 *
 */
public class DataLoadActivity extends Activity
{
	private TextView tv;

	private final int HANDLER_TEST = 0;

	private Handler h = new Handler()
	{
		public void handleMessage(Message msg)
		{
			super.handleMessage(msg);
			switch (msg.what)
			{
			// 处理副线程的消息并发送到当前activity主界面中
			case HANDLER_TEST:
				Toast.makeText(DataLoadActivity.this, "数据加载完毕",
						Toast.LENGTH_SHORT).show();
				tv.setText("数据加载完毕。");
				break;

			default:
				break;
			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_data_load);
		tv = (TextView) findViewById(R.id.textview_data_load);
		// 在主线程中创建一个副线程
		new Thread(new Runnable()
		{

			@Override
			public void run()
			{
				try
				{
					Thread.sleep(5000);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				// 在副线程中发消息到主线程中，主线程会回调处理消息
				Message msg = new Message();
				msg.what = HANDLER_TEST;
				h.sendMessage(msg);
			}
		}).start();
	}
}
