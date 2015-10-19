package com.douzi.demo.qq;

import java.util.ArrayList;
import java.util.List;

import com.douzi.demo.R;
import com.douzi.demo.qq.adater.MyGroupListAdapter;
import com.douzi.demo.qq.moudle.MyGroup;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MyGroupActivity extends Activity
{
	private ListView lvMyGroup;
	private MyGroupListAdapter adapter;
	private List<MyGroup> list = new ArrayList<MyGroup>();

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_qq_mygroup);
		setData();
		lvMyGroup = (ListView)findViewById(R.id.listview_qq_mygroup);
		adapter = new MyGroupListAdapter(list, MyGroupActivity.this);
		lvMyGroup.setAdapter(adapter);
	}

	private void setData()
	{
		list.add(new MyGroup("工作群", R.drawable.group, "讨论工作中的事情"));
		list.add(new MyGroup("学习群", R.drawable.group, "分享最新的学习信息"));
		list.add(new MyGroup("游戏群", R.drawable.group, "游戏共享"));
		list.add(new MyGroup("影视群", R.drawable.group, "最新影评"));
	}
}
