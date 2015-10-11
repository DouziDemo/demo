package com.douzi.demo;

import com.douzi.demo.utils.DouziUtil;

import android.app.Activity;
import android.os.Bundle;
/**
 * Android中常见布局的使用
 * @author administrator
 *
 */
public class LayoutActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_layout);

		//用户注册页面
		DouziUtil.setOnclickListener(findViewById(R.id.button_reg),
				LayoutActivity.this, RegActivity.class);
		
		//学生成绩列表页面
		DouziUtil.setOnclickListener(findViewById(R.id.button_student),
				LayoutActivity.this, StudentActivity.class);
		
		//登陆页面
		DouziUtil.setOnclickListener(findViewById(R.id.button_login),
				LayoutActivity.this, LoginActivity.class);
		//图片相框效果
		DouziUtil.setOnclickListener(findViewById(R.id.button_frame_layout),
				LayoutActivity.this, FrameLayoutActivity.class);
		
		//三字经？？长文字
		DouziUtil.setOnclickListener(findViewById(R.id.button_scrollview),
				LayoutActivity.this, ScrollViewActivity.class);
		//计算器（LinearLayout组合）
		DouziUtil.setOnclickListener(findViewById(R.id.button_calculator),
				LayoutActivity.this, CalculatorActivity.class);
		
		
	}
}
