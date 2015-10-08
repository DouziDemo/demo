package com.douzi.demo;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.widget.TextView;

public class TextActivity extends Activity
{
	private TextView tv;
	private TextView html;
	
	private TextView img;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		//文本例子
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_text);
		tv = (TextView)findViewById(R.id.textview_Tv);
		//界面显示“我是一个机器人的开发程序员。”
		tv.setText("我是一个机器人的开发程序员。");
		//界面显示“我是一个机器人的开发程序员。,是的吗？”
		tv.append(",是的吗？");
		//界面显示“我是一个程序员”
		//tv.setText(R.string.string_tr);
		//界面显示“,是的吗？”
		//tv.setText(",是的吗？", BufferType.SPANNABLE);
		//界面显示“,是的吗？”
		//tv.setText(",是的吗？", BufferType.SPANNABLE);
		
		//普通文本包含HTML的例子
		html = (TextView)findViewById(R.id.textview_html);
		String htmlStr = "<font color=\"#FF0000\">我有一个梦想</font>";
		html.setText(Html.fromHtml(htmlStr));
		
		//普通文本包含图片的例子
		img = (TextView)findViewById(R.id.textview_img);
		
		String imgString = "<h1>测试图片</h1><p><img src="+R.drawable.wm+"></p>";
		
		img.setText(Html.fromHtml(imgString, imgGetter, null));
	}
	
	ImageGetter imgGetter = new Html.ImageGetter()
	{
		
		@Override
		public Drawable getDrawable(String source)
		{
			int id = Integer.parseInt(source);
			Drawable drawable = getResources().getDrawable(id);
			drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
			return drawable;
		}
	};
}
