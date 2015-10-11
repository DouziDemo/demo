package com.douzi.demo.utils;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
/**
 * 工具类
 * @author administrator
 *
 */
public abstract class DouziUtil
{
	/**
	 * 设置点击事件
	 * @param v
	 * @param packageContext
	 * @param cls
	 */
	public static void setOnclickListener(View v, final Activity packageContext, final Class<?> cls){
		v.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				Intent _Intent = new Intent(packageContext, cls);
				packageContext.startActivity(_Intent);
			}
		});
	}
}
