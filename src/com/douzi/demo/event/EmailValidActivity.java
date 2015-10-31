package com.douzi.demo.event;

import com.douzi.demo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.ImageView;

public class EmailValidActivity extends Activity
{
	private EditText input;
	
	private ImageView iv;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_event_key2);
		input = (EditText)findViewById(R.id.edittext_key_inputinfo);
		iv = (ImageView)findViewById(R.id.imageview_show);
		input.setOnKeyListener(new OnKeyListener()
		{
			
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event)
			{
				switch (event.getAction())
				{
				case KeyEvent.ACTION_DOWN:
					String inputStr = input.getText().toString();
					if (inputStr.matches("\\w+@\\w+\\.\\w+")){
						iv.setImageResource(R.drawable.right);
					}
					else{
						iv.setImageResource(R.drawable.wrong);
					}
					break;
				case KeyEvent.ACTION_UP:
					break;
				}
				return false;
			}
		});
	}

}
