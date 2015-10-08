package com.douzi.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

public class EditTextActivity extends Activity
{
	private EditText editTextPhone;
	
	private EditText fontEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.layout_edittext);
		Log.i("douzi", "----getWindow开始------");
		this.getWindow().setContentView(this.getLayoutInflater().inflate(R.layout.layout_edittext, null));
		Log.i("douzi", "----getWindow结束------");
		//输入电话号码的例子
		editTextPhone = (EditText) findViewById(R.id.edittext_phone);
		editTextPhone.addTextChangedListener(new TextWatcher()
		{

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s)
			{
				// TODO Auto-generated method stub
				String phoneStr = s.toString();
				boolean b = isPhoneNumber(phoneStr);
				if (b)
				{
					// 绿色
					editTextPhone.setTextColor(Color.rgb(0, 255, 0));
				} else
				{
					// 红色
					editTextPhone.setTextColor(Color.rgb(255, 0, 0));
				}
			}
		});
		
		//自定义字体
		fontEditText = (EditText)findViewById(R.id.edittext_font);
		//以下字体在Assets目录下，全路径是Assets/fonts/hwxk.ttf
		Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/hwxk.ttf");
		fontEditText.setTypeface(typeface);
	}

	/**
	 * 判断字符串是否为电话格式
	 * @param phoneStr
	 * @return
	 */
	private boolean isPhoneNumber(String phoneStr)
	{
		String regex = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(phoneStr);
		return m.find();
	}
}
