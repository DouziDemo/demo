package com.douzi.demo.event;

import android.app.Activity;
import android.os.Bundle;

public class PaintActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		PaintView v = new PaintView(PaintActivity.this);
		setContentView(v);
	}
}
