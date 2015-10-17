package com.douzi.demo.menu;

import org.w3c.dom.Text;

import com.douzi.demo.R;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;

public class PopupWindowActivity extends Activity
{
	private TextView textView01;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_window_popup_login);
		textView01 = (TextView)findViewById(R.id.textview_popupwindow_login);
		textView01.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				LayoutInflater layoutInflater = (LayoutInflater)(PopupWindowActivity.this).getSystemService(LAYOUT_INFLATER_SERVICE);
				View popyupLayout = layoutInflater.inflate(R.layout.window_popupwindow_login, null);
				PopupWindow popupWindow = new PopupWindow(popyupLayout, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				//设置背景
				popupWindow.setBackgroundDrawable(new BitmapDrawable());
				//设置可以获取焦点
				popupWindow.setFocusable(true);
				//设置popupwindow之外，popupwindow就消失
				popupWindow.setOutsideTouchable(true);
				//设置popupwindow的显示位置
				popupWindow.showAtLocation(findViewById(R.id.liMain), Gravity.CENTER, 0, 0);
			}
		});
	}
}
