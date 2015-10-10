package com.douzi.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AActivity extends Activity
{
	private static int mIndex = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_task);
		Log.i("douzi", "AActivity" + mIndex + " TaskId=" + this.getTaskId());
		++mIndex;

		Button aButton = (Button) findViewById(R.id.button_task_a);
		aButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				Intent _Intent = new Intent(AActivity.this, AActivity.class);
				startActivity(_Intent);
			}
		});

		Button bButton = (Button) findViewById(R.id.button_task_b);
		bButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				Intent _Intent = new Intent(AActivity.this, BActivity.class);
				startActivity(_Intent);
			}
		});
	}
}
