package com.douzi.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerActivity extends Activity
{
	private TextView textviewSpinner;

	private Spinner spinner01;

	ArrayAdapter<CharSequence> adapter;

	private boolean isFirstIn = false;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_spinner);
		textviewSpinner = (TextView) findViewById(R.id.textview_spinner);
		spinner01 = (Spinner) findViewById(R.id.spinner01);
		// 将可选内容与ArrayAdapter连接起来
		adapter = ArrayAdapter.createFromResource(this, R.array.System,
				android.R.layout.simple_spinner_item);

		spinner01.setAdapter(adapter);
		spinner01.setOnItemSelectedListener(new OnItemSelectedListener()
		{

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id)
			{
				if (!isFirstIn)
				{
					isFirstIn = true;
				} else
				{
					textviewSpinner
							.setText(adapter.getItem(position).toString());
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent)
			{
				textviewSpinner.setText("没有选择任务项");
			}
		});
	}
}
