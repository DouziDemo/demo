package com.douzi.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;

public class MultiAutoCompleteActivity extends Activity
{
	private static final String[] NAMES =
	{ "zhangsen", "zhangshi", "liushanshan", "wangli", "wangzhengsan" };
	private MultiAutoCompleteTextView multiAutoCompleteTextView01;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_multiautocomplete);

		multiAutoCompleteTextView01 = (MultiAutoCompleteTextView) findViewById(
				R.id.multiautocompletetextview01);
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
				android.R.layout.simple_dropdown_item_1line, NAMES);
		multiAutoCompleteTextView01.setAdapter(adapter);
		multiAutoCompleteTextView01
				.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
	}
}
