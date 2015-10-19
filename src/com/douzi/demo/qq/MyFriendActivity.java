package com.douzi.demo.qq;

import java.util.ArrayList;
import java.util.List;

import com.douzi.demo.R;
import com.douzi.demo.qq.adater.MyFriendListAdapter;
import com.douzi.demo.qq.moudle.MyFriend;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MyFriendActivity extends Activity
{
	private ListView lvFriend;
	private MyFriendListAdapter adapter;
	private List<MyFriend> list = new ArrayList<MyFriend>();

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_qq_myfriend);
		setData();
		lvFriend = (ListView)findViewById(R.id.listview_qq_friend);
		adapter = new MyFriendListAdapter(list, MyFriendActivity.this);
		lvFriend.setAdapter(adapter);
		
	}
	
	private void setData(){
		list.add(new MyFriend("在线好友", R.drawable.arrow, "42"));
		list.add(new MyFriend("我的好友", R.drawable.arrow, "32"));
		list.add(new MyFriend("工作好友", R.drawable.arrow, "45"));
		list.add(new MyFriend("同学好友", R.drawable.arrow, "87"));
	}
}
