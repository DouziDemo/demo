package com.douzi.demo.qq;

import java.util.ArrayList;
import java.util.List;

import com.douzi.demo.R;
import com.douzi.demo.qq.adater.MyDiscussionAdapter;
import com.douzi.demo.qq.moudle.MyDiscussion;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MyDiscussionActivity extends Activity
{
	private ListView lvFriend;

	private MyDiscussionAdapter adapter;
	
	private List<MyDiscussion> list = new ArrayList<MyDiscussion>();

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_qq_mydiscussion);
		
		getData();
		
		lvFriend = (ListView)findViewById(R.id.listview_qq_mydiscussion);
		adapter = new MyDiscussionAdapter(list, MyDiscussionActivity.this);
		lvFriend.setAdapter(adapter);
		
	}
	
	private void getData(){
		list.add(new MyDiscussion("临时讨论组", R.drawable.dicussion, "张三，李四，王五"));
		list.add(new MyDiscussion("项目研讨组", R.drawable.dicussion, "赵六，刘八，池的花"));
		list.add(new MyDiscussion("自定义讨论组", R.drawable.dicussion, "shune,黑境骑士，白雪"));
		list.add(new MyDiscussion("课程讨论组", R.drawable.dicussion, "A1,blue,李经理"));
	}
}
