package com.douzi.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

public class SubMenuActivity extends Activity
{
	private final static int MENU_1 = Menu.FIRST;
	private final static int MENU_2 = Menu.FIRST + 1;
	private final static int MENU_3 = Menu.FIRST + 2;
	private final static int MENU_4 = Menu.FIRST + 3;
	private final static int MENU_5 = Menu.FIRST + 4;
	private final static int MENU_6 = Menu.FIRST + 5;
	private final static int MENU_7 = Menu.FIRST + 6;
	private final static int MENU_8 = Menu.FIRST + 7;
	private final static int MENU_9 = Menu.FIRST + 8;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_submenu);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		SubMenu sub1 = menu.addSubMenu("新建");
		sub1.add(0, MENU_1, 0, "文件1");
		sub1.add(0, MENU_2, 0, "文件2");
		sub1.add(0, MENU_3, 0, "文件3");
		
		SubMenu sub2 = menu.addSubMenu("打开");
		sub2.add(0, MENU_4, 0, "文件4");
		sub2.add(0, MENU_5, 0, "文件5");
		sub2.add(0, MENU_6, 0, "文件6");
		
		SubMenu sub3 = menu.addSubMenu("保存");
		sub3.add(0, MENU_7, 0, "文件7");
		sub3.add(0, MENU_8, 0, "文件8");
		sub3.add(0, MENU_9, 0, "文件9");
		
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
		case 1:
			Toast.makeText(this, "你单击了文件1", Toast.LENGTH_SHORT).show();
			break;
		case 2:
			Toast.makeText(this, "你单击了文件2", Toast.LENGTH_SHORT).show();
			break;
		case 3:
			Toast.makeText(this, "你单击了文件3", Toast.LENGTH_SHORT).show();
			break;
		case 4:
			Toast.makeText(this, "你打开了文件4", Toast.LENGTH_SHORT).show();
			break;
		case 5:
			Toast.makeText(this, "你打开了文件5", Toast.LENGTH_SHORT).show();
			break;
		case 6:
			Toast.makeText(this, "你打开了文件6", Toast.LENGTH_SHORT).show();
			break;
		case 7:
			Toast.makeText(this, "你保存了文件7", Toast.LENGTH_SHORT).show();
			break;
		case 8:
			Toast.makeText(this, "你保存了文件8", Toast.LENGTH_SHORT).show();
			break;
		case 9:
			Toast.makeText(this, "你保存了文件9", Toast.LENGTH_SHORT).show();
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
