package com.douzi.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class IntentToActivity extends Activity
{
	private Intent _Intent;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_intent_to);

		// 接收上一个activity值入的值，如果有值，则显示出来
		_Intent = this.getIntent();
		String value = _Intent.getStringExtra("com.douzi.demo.DOUZIKEY");
		if (null != value)
		{
			Toast.makeText(IntentToActivity.this, value, Toast.LENGTH_SHORT)
					.show();
		}
		String uriString = _Intent.getDataString();
		if (null != uriString){
			Toast.makeText(IntentToActivity.this, uriString, Toast.LENGTH_SHORT)
			.show();
		}
		
		Button resultButton = (Button)findViewById(R.id.button_intent_return);
		resultButton.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				_Intent.putExtra("com.douzi.demo.DOUZIKEY", "豆子，你好！");
				setResult(1234, _Intent);
				//调用这个当你的活动,应该关闭。ActivityResult传回给谁了你通过onActivityResult()。
				finish();
			}
		});
	}
}
