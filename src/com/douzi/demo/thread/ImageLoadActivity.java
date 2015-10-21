package com.douzi.demo.thread;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.douzi.demo.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.test.suitebuilder.TestSuiteBuilder.FailedToCreateTests;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * 网络图片加载
 * 
 * @author administrator
 *
 */
public class ImageLoadActivity extends Activity
{
	private ImageView iv;

	private final int SUCCESS = 0;
	private final int FAILED = 1;
	private final String URL = "http://pic16.nipic.com/20111006/4509604_110611009301_2.jpg";
	private Bitmap bit = null;

	private Handler h = new Handler()
	{
		public void handleMessage(android.os.Message msg)
		{
			super.handleMessage(msg);
			switch (msg.what)
			{
			case SUCCESS:
				Toast.makeText(ImageLoadActivity.this, "图片加载成功",
						Toast.LENGTH_SHORT).show();
				iv.setImageBitmap(bit);
				break;
			case FAILED:
				Toast.makeText(ImageLoadActivity.this, "图片加载失败",
						Toast.LENGTH_SHORT).show();
				break;
			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_image_load);
		iv = (ImageView) findViewById(R.id.imageview_image_load);
		if (isOpenNetwork())
		{
			new Thread()
			{
				@Override
				public void run()
				{
					super.run();
					try
					{
						bit = getRemoteImage(new URL(URL));
					}
					catch (MalformedURLException e)
					{
						e.printStackTrace();
					}
					//得到bitmap
					if (bit != null)
					{
						Message msg = new Message();
						msg.what = SUCCESS;
						h.sendMessage(msg);
					}
					//没有得到bitmap
					else
					{
						Message msg = new Message();
						msg.what = FAILED;
						h.sendMessage(msg);
					}
				}
			}.start();
		}
		else
		{
			Toast.makeText(ImageLoadActivity.this, "网络不通", Toast.LENGTH_SHORT)
					.show();
		}
	}

	/**
	 * 远程获取图片
	 * 
	 * @param aurl
	 * @return
	 */
	public Bitmap getRemoteImage(final URL aurl)
	{
		try
		{
			//建议URL连接
			final URLConnection conn = aurl.openConnection();
			//从URL连接中读取图片流
			final BufferedInputStream bis = new BufferedInputStream(
					conn.getInputStream());
			//从图片流中得到bitmap图片
			final Bitmap bm = BitmapFactory.decodeStream(bis);
			//关闭图片流
			bis.close();
			return bm;
		}
		catch (IOException e)
		{
			Log.d("douzi", "Oh noooz an error.....");
		}
		return null;
	}

	/**
	 * 判断网络状态是否正常
	 * 
	 * @return
	 */
	private boolean isOpenNetwork()
	{
		// 得到系统的网络连接服务
		ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(
				Context.CONNECTIVITY_SERVICE);
		// 判断是否网络可连接
		if (connectivityManager.getActiveNetworkInfo() != null)
		{
			return connectivityManager.getActiveNetworkInfo().isAvailable();
		}
		return false;
	}
}
