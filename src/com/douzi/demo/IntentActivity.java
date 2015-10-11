package com.douzi.demo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

/**
 * 意图跳转的例子
 * 
 * @author administrator
 *
 */
public class IntentActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_intent);

		//通过Intent跳转
		Button intentActivityButton = (Button) findViewById(
				R.id.button_intent_activity);
		intentActivityButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				// 跳转到另外一个Activity中，并传入一个键值对{"com.douzi.demo.DOUZIKEY", "你好！"}
				Intent _Intent = new Intent(IntentActivity.this,
						IntentToActivity.class);
				_Intent.putExtra("com.douzi.demo.DOUZIKEY", "你好！");
				// startActivity(_Intent);
				
				// 使用startActivityForResult(Intent intent, int
				// requestCode)必须得实现onActivityResult(int requestCode, int
				// resultCode, Intent data)
				startActivityForResult(_Intent, 123);
			}
		});
		
		//通过IntentFilter跳转
		Button intentFilterActivityButton = (Button) findViewById(
				R.id.button_intent_filter_activity);
		intentFilterActivityButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				// 跳转到另外一个Activity中，并传入一个键值对{"com.douzi.demo.DOUZIKEY", "你好！"}
				Intent _Intent = new Intent();
				_Intent.setData(Uri.parse("http://www.baidu.com"));
				_Intent.setAction("com.douzi.demo.INTENTTO");
				_Intent.putExtra("com.douzi.demo.DOUZIKEY", "你好！");
				// startActivity(_Intent);
				
				// 使用startActivityForResult(Intent intent, int
				// requestCode)必须得实现onActivityResult(int requestCode, int
				// resultCode, Intent data)
				startActivityForResult(_Intent, 123);
			}
		});
		
		//通过IntentFilter跳转到拨号界面
		Button intentFilterDialActivityButton = (Button) findViewById(
				R.id.button_intent_filter_dial);
		intentFilterDialActivityButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				Intent _Intent = new Intent();
				_Intent.setAction(Intent.ACTION_DIAL);
				_Intent.setData(Uri.parse("tel:18771970972"));
				startActivity(_Intent);
			}
		});
		
		//通过IntentFilter直接拨号
		//需要权限 <uses-permission android:name="android.permission.CALL_PHONE" />
		Button intentFilterCallActivityButton = (Button) findViewById(
				R.id.button_intent_filter_call);
		intentFilterCallActivityButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				Intent _Intent = new Intent();
				_Intent.setAction(Intent.ACTION_CALL);
				_Intent.setData(Uri.parse("tel:18771970972"));
				startActivity(_Intent);
			}
		});
		
		//通过IntentFilter直接拨号
		//需要权限 <uses-permission android:name="android.permission.SEND_SMS" />
		Button intentFilterSMSActivityButton = (Button) findViewById(
				R.id.button_intent_filter_sms);
		intentFilterSMSActivityButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				Intent _Intent = new Intent();
				_Intent.setAction(Intent.ACTION_SENDTO);
				_Intent.setData(Uri.parse("smsto:13800000000"));
				_Intent.putExtra("sms_body", "调用发短信界面");
				startActivity(_Intent);
			}
		});
		
		//调用第三方APP中的Activity
		Button thirdAppActivityButton = (Button) findViewById(
				R.id.button_third_app);
		thirdAppActivityButton.setOnClickListener(new OnClickListener()
		{
	
			@Override
			public void onClick(View v)
			{
				ComponentName com = new ComponentName("com.third.app",
						"com.third.app.XXActivity");
				Intent _Intent = new Intent();
				_Intent.setComponent(com);
				startActivity(_Intent);
			}
		});
		
		
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent data)
	{
		if (1234 == resultCode)
		{
			Toast.makeText(IntentActivity.this,
					data.getStringExtra("com.douzi.demo.DOUZIKEY"),
					3000).show();
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
}
