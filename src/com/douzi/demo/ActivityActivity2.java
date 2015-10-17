package com.douzi.demo;

import com.douzi.demo.menu.MenuActivity;
import com.douzi.demo.menu.PopMenuActivity;
import com.douzi.demo.menu.PopupMenuActivity;
import com.douzi.demo.menu.SimulateMenuActivity;
import com.douzi.demo.menu.SubMenuActivity;
import com.douzi.demo.utils.DouziUtil;

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
		
	}
}
