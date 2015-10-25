package com.douzi.demo.event;

import com.douzi.demo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AEventActivity extends Activity
{
	private Button aButton;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_event_key);
		aButton = (Button) findViewById(R.id.button_event_key_a);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		char ch = Character.toLowerCase(event.getDisplayLabel());
		if ('a' == ch)
		{
			myclick(aButton);
		}
		return super.onKeyDown(keyCode, event);
	}

	/**
	 * 必须加View参数
	 * @param v
	 */
	public void myclick(View v)
	{
		Toast.makeText(this, "您点击了我", Toast.LENGTH_SHORT).show();
	}
}
