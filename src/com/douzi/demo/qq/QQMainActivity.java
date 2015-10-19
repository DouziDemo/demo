package com.douzi.demo.qq;

import com.douzi.demo.R;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class QQMainActivity extends TabActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_tabhost);
		
		TabHost tabHost = getTabHost();
		TabHost.TabSpec spec;
		Intent i ;
		i = new Intent(QQMainActivity.this, MyFriendActivity.class);
		spec = tabHost.newTabSpec("0").setIndicator("好友").setContent(i);
		tabHost.addTab(spec);
		
		i = new Intent(QQMainActivity.this, MyGroupActivity.class);
		spec = tabHost.newTabSpec("1").setIndicator("群").setContent(i);
		tabHost.addTab(spec);
		i = new Intent(QQMainActivity.this, MyDiscussionActivity.class);
		spec = tabHost.newTabSpec("2").setIndicator("讨论组").setContent(i);
		tabHost.addTab(spec);
		
		tabHost.setCurrentTab(1);
	}
}
