package com.douzi.demo.menu;

import com.douzi.demo.R;
import com.douzi.demo.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MenuActivity extends Activity
{
	private final static int MENU_1 = Menu.FIRST;
	private final static int MENU_2 = Menu.FIRST + 1;
	private final static int MENU_3 = Menu.FIRST + 2;
	private final static int MENU_4 = Menu.FIRST + 3;
	private final static int MENU_5 = Menu.FIRST + 4;
	private final static int MENU_6 = Menu.FIRST + 5;
	private final static int MENU_7 = Menu.FIRST + 6;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_mune);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		//参数menu就是拿到的当前Activity菜单对象
		//想要给当前页面添加方法的话就add进去即可
		//add方法的参数：add（分组ID,ITEMID，排序，菜单文字）
		menu.add(0, MENU_1, 0, "编辑模式");
		menu.add(0, MENU_2, 0, "修改壁纸");
		menu.add(0, MENU_3, 0, "全局搜索");
		menu.add(0, MENU_4, 0, "桌面缩略图");
		menu.add(0, MENU_5, 0, "桌面效果");
		menu.add(0, MENU_6, 0, "系统设置");
		menu.add(0, MENU_7, 0, "用户信息");
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
		case 1:
			Toast.makeText(this, "你单击了编辑模式选项", Toast.LENGTH_SHORT).show();
			break;
		case 2:
			Toast.makeText(this, "你单击了修改壁纸", Toast.LENGTH_SHORT).show();
			break;
		case 3:
			Toast.makeText(this, "你单击了全局搜索", Toast.LENGTH_SHORT).show();
			break;
		case 4:
			Toast.makeText(this, "你单击了桌面缩略图", Toast.LENGTH_SHORT).show();
			break;
		case 5:
			Toast.makeText(this, "你单击了桌面效果", Toast.LENGTH_SHORT).show();
			break;
		case 6:
			Toast.makeText(this, "你单击了系统设置", Toast.LENGTH_SHORT).show();
			break;
		case 7:
			Toast.makeText(this, "你单击了用户信息", Toast.LENGTH_SHORT).show();
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void onOptionsMenuClosed(Menu menu)
	{
		Log.e("douzi", "用户菜单关闭了");
	}
	
	@Override
	public boolean onPrepareOptionsMenu(Menu menu)
	{
		Log.e("douzi", "用户菜单准备好被显示了");
		return true;
	}
}
