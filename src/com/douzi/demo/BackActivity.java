package com.douzi.demo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.KeyEvent;
/**
 * 退出程序的例子，只是退出当前的Activity
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
					//程序关闭
					BackActivity.this.finish();
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
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0){
			createDialog();
		}
		return false;
	}
}
