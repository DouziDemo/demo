package com.douzi.demo.alert;

import com.douzi.demo.R;
import com.douzi.demo.R.layout;

import android.R.anim;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

/**
 * 退出程序的例子，只是退出当前的Activity
 * 
 * @author administrator
 *
 */
public class BackActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_back);
		//打印进程ID等
		Log.i("douzi",
				"pid=" + android.os.Process.myPid() + ",uid="
						+ android.os.Process.myUid() + ",tid="
						+ android.os.Process.myTid());
	}

	protected void createDialog()
	{
		AlertDialog.Builder b = new Builder(BackActivity.this);
		b.setMessage("确认要退出吗?");
		b.setTitle("提示");
		b.setPositiveButton("确认", new OnClickListener()
		{

			@Override
			public void onClick(DialogInterface dialog, int which)
			{
				dialog.dismiss();
				// 当前程序(activity)关闭
				//BackActivity.this.finish();
				
				// 结束当前进程的ID
				//android.os.Process.killProcess(android.os.Process.myPid());
				// 关闭当前程序的虚拟机
				System.exit(0);
			}
		});
		b.setNegativeButton("取消", new OnClickListener()
		{

			@Override
			public void onClick(DialogInterface dialog, int which)
			{
				dialog.dismiss();
			}
		});
		b.create().show();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0)
		{
			createDialog();
		}
		return false;
	}
}
