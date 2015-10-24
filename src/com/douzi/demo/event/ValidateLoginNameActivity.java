package com.douzi.demo.event;

import com.douzi.demo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * 检测用户合法性
 * 
 * @author Administrator
 *
 */
public class ValidateLoginNameActivity extends Activity
{
	private EditText editText;
	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_event_loginname);
		editText = (EditText) findViewById(R.id.edittext_event_login_name);
		button = (Button) findViewById(R.id.button_event_validate_login_name);
	}

	public void myclick(View v)
	{
		int len = editText.getText().toString().length();
		if (len > 5 && len < 9)
		{
			editText.setText("用户名合法");
		}
		else
		{
			editText.setText("用户名不合法");
		}
	}
}
