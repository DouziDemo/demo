package com.douzi.demo.weibo;

import com.douzi.demo.R;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;

public class WeiboActivity extends TabActivity
		implements OnCheckedChangeListener
{
	private TabHost mHost;
	private RadioGroup radioGroup;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_weibo_tabhost);
		//对应 android:id="@android:id/tabhost"
		mHost = getTabHost();
		//addTab()对应 android:id="@android:id/tabs"，但是这个tabs又设置了android:visibility="gone"，表示不显示tabs
		//setContent(Intent)对应android:id="@android:id/tabcontent"
		mHost.addTab(mHost.newTabSpec("ONE").setIndicator("ONE").setContent(new Intent(this, OneActivity.class)));
		mHost.addTab(mHost.newTabSpec("TWO").setIndicator("TWO").setContent(new Intent(this, TwoActivity.class)));
		mHost.addTab(mHost.newTabSpec("THREE").setIndicator("THREE").setContent(new Intent(this, ThreeActivity.class)));
		mHost.addTab(mHost.newTabSpec("FOUR").setIndicator("FOUR").setContent(new Intent(this, FourActivity.class)));
		mHost.addTab(mHost.newTabSpec("FIVE").setIndicator("FIVE").setContent(new Intent(this, FiveActivity.class)));
		radioGroup = (RadioGroup)findViewById(R.id.main_radio);
		radioGroup.setOnCheckedChangeListener(this);
	}


	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId)
	{
		switch (checkedId)
		{
		case R.id.radio_button0:
			mHost.setCurrentTabByTag("ONE");
			break;
		case R.id.radio_button1:
			mHost.setCurrentTabByTag("TWO");
			break;
		case R.id.radio_button2:
			mHost.setCurrentTabByTag("THREE");
			break;
		case R.id.radio_button3:
			mHost.setCurrentTabByTag("FOUR");
			break;
		case R.id.radio_button4:
			mHost.setCurrentTabByTag("FIVE");
			break;
		}
	}
}
