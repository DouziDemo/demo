package com.douzi.demo.event;

import com.douzi.demo.R;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
/**
 * 打字游戏
 * @author Administrator
 *
 */
import android.widget.TextView;

public class CharGameActivity extends Activity
{
	private TextView charTextView;
	private int count = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_event_char);
		charTextView = (TextView) findViewById(
				R.id.textview_event_char_content);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		//得到用户所按下的键
		char ch = Character.toLowerCase(event.getDisplayLabel());
		//判断用户按下的字母是那个按钮
		if (ch == charTextView.getText().charAt(count - 1))
		{
			//得到文本内容
			SpannableString ss = new SpannableString(charTextView.getText().toString());
			//设置单个的字符颜色
			ss.setSpan(new ForegroundColorSpan(Color.RED), 0, count, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
			ss.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), 0, count, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
			//记录用户输入的字符的个数
			count++;
			//在TextView中显示修饰后的字符串
			charTextView.setText(ss);
		}
		return super.onKeyDown(keyCode, event);
	}
}
