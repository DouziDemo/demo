package com.douzi.demo;

import android.R.anim;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class GridViewActivity extends Activity
{
	private GridView gridView01;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_gridview);

		gridView01 = (GridView) findViewById(R.id.gridview_seat);

		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
				R.array.seat, android.R.layout.simple_gallery_item);
		
		gridView01.setAdapter(adapter);

	}
}
