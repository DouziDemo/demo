package com.douzi.demo.menu;

import java.util.ArrayList;
import java.util.List;

import com.douzi.demo.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;
/**
 * 伪菜单
 * @author administrator
 *
 */
public class SimulateMenuActivity extends Activity
{
	private final int ITEM_1 = 0;
	private final int ITEM_2 = 1;
	private final int ITEM_3 = 2;
	private final int ITEM_4 = 3;
	private final int ITEM_5 = 4;
	private final int ITEM_6 = 5;
	private final int ITEM_7 = 6;
	private final int ITEM_8 = 7;
	private final int ITEM_9 = 8;

	private AlertDialog dia;

	private GridView gridView;

	private View view;
	
	private List<Item> list = new ArrayList<Item>();

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main_simulate_menu);

		setData();
		setMenuView();
	}

	public void setData()
	{
		list.add(new Item(R.drawable.m1, "搜索"));
		list.add(new Item(R.drawable.m2, "文件管理"));
		list.add(new Item(R.drawable.m3, "下载管理"));
		list.add(new Item(R.drawable.m4, "全屏"));
		list.add(new Item(R.drawable.m5, "网址"));
		list.add(new Item(R.drawable.m6, "书签"));
		list.add(new Item(R.drawable.m7, "加入书签"));
		list.add(new Item(R.drawable.m8, "分享"));
		list.add(new Item(R.drawable.m9, "退出"));
	}

	public void setMenuView()
	{
		view = View.inflate(this, R.layout.layout_simulate_menu, null);
		dia = new AlertDialog.Builder(this).create();
		dia.setView(view);
		dia.setOnKeyListener(new OnKeyListener()
		{
			
			@Override
			public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event)
			{
				if (keyCode == KeyEvent.KEYCODE_MENU){
					dialog.dismiss();
				}
				return false;
			}
		});
		
		GridViewAdapter gridViewAdapter = new GridViewAdapter(this, list);
		gridView = (GridView)view.findViewById(R.id.gridview_simulate_menu);
		gridView.setAdapter(gridViewAdapter);
		gridView.setOnItemClickListener(new OnItemClickListener()
		{

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id)
			{
				switch (position)
				{
				case ITEM_1:
					Toast.makeText(SimulateMenuActivity.this, "选择了搜索", Toast.LENGTH_SHORT).show();
					break;
				case ITEM_2:
					Toast.makeText(SimulateMenuActivity.this, "选择了文件", Toast.LENGTH_SHORT).show();
					break;
				case ITEM_3:
					Toast.makeText(SimulateMenuActivity.this, "选择了下载", Toast.LENGTH_SHORT).show();
					break;
				case ITEM_4:
					Toast.makeText(SimulateMenuActivity.this, "选择了全屏", Toast.LENGTH_SHORT).show();
					break;
				case ITEM_5:
					Toast.makeText(SimulateMenuActivity.this, "选择了网址", Toast.LENGTH_SHORT).show();
					break;
				case ITEM_6:
					Toast.makeText(SimulateMenuActivity.this, "选择了书签", Toast.LENGTH_SHORT).show();
					break;
				case ITEM_7:
					Toast.makeText(SimulateMenuActivity.this, "选择了加入书签", Toast.LENGTH_SHORT).show();
					break;
				case ITEM_8:
					Toast.makeText(SimulateMenuActivity.this, "选择了分享", Toast.LENGTH_SHORT).show();
					break;
				case ITEM_9:
					Toast.makeText(SimulateMenuActivity.this, "选择了退出", Toast.LENGTH_SHORT).show();
					break;
				}
				dia.dismiss();
				
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		menu.add("menu"); //必须创建一项
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onMenuOpened(int featureId, Menu menu)
	{
		if(dia == null){
			dia = new AlertDialog.Builder(this).setView(view).show();
		}else{
			dia.show();
		}
		return super.onMenuOpened(featureId, menu);
	}
}
