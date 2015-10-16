package com.douzi.demo.menu;

import com.douzi.demo.R;
import com.douzi.demo.R.id;
import com.douzi.demo.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Toast;

public class PopMenuActivity extends Activity
{
	private final static int MENU_1 = Menu.FIRST;
	private final static int MENU_2 = Menu.FIRST + 1;
	private final static int MENU_3 = Menu.FIRST + 2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_popmenu);
		registerForContextMenu(findViewById(R.id.edittext_pop_menu));
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo)
	{
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.add(0, MENU_1, 0, "复制文字");
		menu.add(0, MENU_2, 0, "粘贴文字");
		menu.add(0, MENU_3, 0, "全选文字");
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
			case 1:
				Toast.makeText(this, "复制文字", Toast.LENGTH_SHORT).show();
				break;
			case 2:
				Toast.makeText(this, "粘贴文字", Toast.LENGTH_SHORT).show();
				break;
			case 3:
				Toast.makeText(this, "全选文字", Toast.LENGTH_SHORT).show();
				break;
	
			default:
				break;
		}
		return super.onContextItemSelected(item);
	}
}
