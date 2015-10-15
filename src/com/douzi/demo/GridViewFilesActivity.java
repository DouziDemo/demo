package com.douzi.demo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

public class GridViewFilesActivity extends Activity
{
	private GridView gridView01;
	private FileListAdapter adapter;
	private List<MyFile> fileList = new ArrayList<MyFile>();

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_gridview_files);
		gridView01 = (GridView) findViewById(R.id.gridview_grid_files);
		setData();
		adapter = new FileListAdapter(this, fileList);
		gridView01.setAdapter(adapter);
	}

	private void setData()
	{
		fileList.add(new MyFile("test.txt", R.drawable.doc));
		fileList.add(new MyFile("test.jpg", R.drawable.image));
		fileList.add(new MyFile("test.avi", R.drawable.video));
		fileList.add(new MyFile("dir1", R.drawable.dir));
		fileList.add(new MyFile("test.doc", R.drawable.doc));
		fileList.add(new MyFile("test.rmvb", R.drawable.video));
		fileList.add(new MyFile("test.mp4", R.drawable.video));
		fileList.add(new MyFile("test.rm", R.drawable.video));
		fileList.add(new MyFile("test.png", R.drawable.image));
		fileList.add(new MyFile("dir2", R.drawable.dir));
	}
}
