package com.douzi.demo;

import com.douzi.demo.alert.AlertEventActivity;
import com.douzi.demo.alert.BackActivity;
import com.douzi.demo.alert.CustomAlertTitleActivity;
import com.douzi.demo.menu.MenuActivity;
import com.douzi.demo.menu.PopMenuActivity;
import com.douzi.demo.menu.PopupMenuActivity;
import com.douzi.demo.menu.PopupWindowActivity;
import com.douzi.demo.menu.SimulateMenuActivity;
import com.douzi.demo.menu.SubMenuActivity;
import com.douzi.demo.qq.QQMainActivity;
import com.douzi.demo.utils.DouziUtil;
import com.douzi.demo.weibo.WeiboActivity;

import android.app.Activity;
import android.os.Bundle;

public class ActivityActivity2 extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_activity2);
		
		//Iphone Coverflow
		DouziUtil.setOnclickListener(findViewById(R.id.button_coverflow), ActivityActivity2.this, MycoverflowActivity.class);
		
		//菜单menu
		DouziUtil.setOnclickListener(findViewById(R.id.button_menu), ActivityActivity2.this, MenuActivity.class);
		
		//子菜单menu
		DouziUtil.setOnclickListener(findViewById(R.id.button_submenu), ActivityActivity2.this, SubMenuActivity.class);
		
		//弹出菜单menu
		DouziUtil.setOnclickListener(findViewById(R.id.button_popmenu), ActivityActivity2.this, PopMenuActivity.class);
		//伪菜单menu
		DouziUtil.setOnclickListener(findViewById(R.id.button_simulate_menu), ActivityActivity2.this, SimulateMenuActivity.class);
		//弹出菜单menu2
		DouziUtil.setOnclickListener(findViewById(R.id.button_popup_menu), ActivityActivity2.this, PopupMenuActivity.class);
		//弹出窗口popupwindow
		DouziUtil.setOnclickListener(findViewById(R.id.button_popup_window), ActivityActivity2.this, PopupWindowActivity.class);
		//qq标签效果
		DouziUtil.setOnclickListener(findViewById(R.id.button_qq), ActivityActivity2.this, QQMainActivity.class);
		//仿新浪微博的主页效果
		DouziUtil.setOnclickListener(findViewById(R.id.button_weibo), ActivityActivity2.this, WeiboActivity.class);
		//退出程序的例子
		DouziUtil.setOnclickListener(findViewById(R.id.button_back), ActivityActivity2.this, BackActivity.class);
		//关于的例子（自定义alert的title）
		DouziUtil.setOnclickListener(findViewById(R.id.button_about), ActivityActivity2.this, CustomAlertTitleActivity.class);
		//评价的例子（alert事件处理）
		DouziUtil.setOnclickListener(findViewById(R.id.button_alert_event), ActivityActivity2.this, AlertEventActivity.class);
	}
}
