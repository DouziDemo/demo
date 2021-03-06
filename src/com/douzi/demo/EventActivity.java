package com.douzi.demo;

import com.douzi.demo.event.AEventActivity;
import com.douzi.demo.event.AddContactsActivity;
import com.douzi.demo.event.CharGameActivity;
import com.douzi.demo.event.DragActivity;
import com.douzi.demo.event.EmailValidActivity;
import com.douzi.demo.event.ImageSwitchActivity;
import com.douzi.demo.event.PageLoadActivity;
import com.douzi.demo.event.PaintActivity;
import com.douzi.demo.event.SeeImageActivity;
import com.douzi.demo.event.ValidateLoginNameActivity;
import com.douzi.demo.event.ViewFlipperActivity;
import com.douzi.demo.event.XYActivity;
import com.douzi.demo.utils.DouziUtil;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ViewFlipper;

public class EventActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_event);
		// 用户名检测
		DouziUtil.setOnclickListener(findViewById(R.id.button_validate),
				EventActivity.this, ValidateLoginNameActivity.class);
		// 打字游戏
		DouziUtil.setOnclickListener(findViewById(R.id.button_char),
				EventActivity.this, CharGameActivity.class);
		// 按钮的快捷键
		DouziUtil.setOnclickListener(findViewById(R.id.button_event_key),
				EventActivity.this, AEventActivity.class);

		// 获取XY坐标
		DouziUtil.setOnclickListener(findViewById(R.id.button_event_xy),
				EventActivity.this, XYActivity.class);

		// window焦点事件
		DouziUtil.setOnclickListener(
				findViewById(R.id.button_event_onwindowfocuschanged),
				EventActivity.this, PageLoadActivity.class);
		// 添加联系人
		DouziUtil.setOnclickListener(
				findViewById(R.id.button_event_oncontentchanged),
				EventActivity.this, AddContactsActivity.class);
		// 宝宝看图识字软件
		DouziUtil.setOnclickListener(findViewById(R.id.button_event_see_image),
				EventActivity.this, SeeImageActivity.class);
		// 拖动事件
		DouziUtil.setOnclickListener(findViewById(R.id.button_event_drag),
				EventActivity.this, DragActivity.class);
		// email检测
		DouziUtil.setOnclickListener(findViewById(R.id.button_event_email),
				EventActivity.this, EmailValidActivity.class);
		// 图片的滑动效果
		DouziUtil.setOnclickListener(findViewById(R.id.button_image_switch),
				EventActivity.this, ImageSwitchActivity.class);
		// 简易画板
		DouziUtil.setOnclickListener(findViewById(R.id.button_simple_paint),
						EventActivity.this, PaintActivity.class);
		// 滑动ViewFlipper
				DouziUtil.setOnclickListener(findViewById(R.id.button_viewflipper),
								EventActivity.this, ViewFlipperActivity.class);

	}
}
