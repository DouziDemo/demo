package com.douzi.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Gallery;
import android.widget.ImageView;

public class GalleryActivity extends Activity
{
	private Gallery gal;
	private ImageView iv;

	private ImagesAdapter adapter;

	private Integer[] imgsIds =
	{ R.drawable.b1, R.drawable.b2, R.drawable.b3, R.drawable.b4, R.drawable.b5,
			R.drawable.b6 };

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_gallery);
		gal = (Gallery) findViewById(R.id.gallery_images);
		iv = (ImageView)findViewById(R.id.imageview_gallery);
		adapter = new ImagesAdapter(this, imgsIds);
		gal.setAdapter(adapter);
		gal.setOnItemClickListener(new OnItemClickListener()
		{

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id)
			{
				iv.setImageResource(imgsIds[position]);
			}
		});
	}
}
