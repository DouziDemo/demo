package com.douzi.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivity extends Activity
{
	private ListView listView01;

	private ArrayAdapter<CharSequence> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_listview);
		listView01 = (ListView) findViewById(R.id.listview_student);
		adapter = ArrayAdapter.createFromResource(this, R.array.names, android.R.layout.simple_gallery_item);
		listView01.setAdapter(adapter);
	}
}
