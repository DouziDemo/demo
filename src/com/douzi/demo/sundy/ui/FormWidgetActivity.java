package com.douzi.demo.sundy.ui;

import com.douzi.demo.R;

import android.app.Activity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.widget.TextView;
/**
 * 插入图片的例子
 * @author Administrator
 *
 */
public class FormWidgetActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_form_widget);
		
		TextView textView = (TextView)findViewById(R.id.textview_form_widget);
		SpannableStringBuilder ssb = new SpannableStringBuilder("大家好，今天天气不错哦。");
		ImageSpan span = new ImageSpan(FormWidgetActivity.this, R.drawable.ic_launcher) ;
		ssb.setSpan(span, 4, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		textView.setText(ssb);
	}
}
