package com.douzi.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
/**
 * 自动补全
 * @author administrator
 *
 */
public class AutoCompleteActivity extends Activity
{
	private static final String[] WORDS =
	{ "abbreviation", "action", "ally", "ball", "bask" };

	private AutoCompleteTextView autoCompleteTextView01;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_autocomplete);
		autoCompleteTextView01 = (AutoCompleteTextView) findViewById(
				R.id.autocompletetextview01);
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
				android.R.layout.simple_dropdown_item_1line, WORDS);
		autoCompleteTextView01.setAdapter(adapter);
	}
}
