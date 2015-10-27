package com.douzi.demo;

import com.douzi.demo.event.AEventActivity;
import com.douzi.demo.event.AddContactsActivity;
import com.douzi.demo.event.CharGameActivity;
import com.douzi.demo.event.PageLoadActivity;
import com.douzi.demo.event.SeeImageActivity;
import com.douzi.demo.event.ValidateLoginNameActivity;
import com.douzi.demo.event.XYActivity;
import com.douzi.demo.utils.DouziUtil;

import android.app.Activity;
import android.os.Bundle;

public class EventActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_event);
		//用户名检测
		DouziUtil.setOnclickListener(findViewById(R.id.button_validate),
				EventActivity.this, ValidateLoginNameActivity.class);
		//打字游戏 
		DouziUtil.setOnclickListener(findViewById(R.id.button_char),
				EventActivity.this, CharGameActivity.class);
		//按钮的快捷键
		DouziUtil.setOnclickListener(findViewById(R.id.button_event_key),
						EventActivity.this, AEventActivity.class);
	
	    //获取XY坐标
		DouziUtil.setOnclickListener(findViewById(R.id.button_event_xy),
							EventActivity.this, XYActivity.class);
		
		//window焦点事件
		DouziUtil.setOnclickListener(findViewById(R.id.button_event_onwindowfocuschanged),
									EventActivity.this, PageLoadActivity.class);
		//添加联系人
		DouziUtil.setOnclickListener(findViewById(R.id.button_event_oncontentchanged),
											EventActivity.this, AddContactsActivity.class);
		//宝宝看图识字软件
		DouziUtil.setOnclickListener(findViewById(R.id.button_event_see_image),
													EventActivity.this, SeeImageActivity.class);
		
	}
}
