package com.douzi.demo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class ImagesAdapter extends BaseAdapter
{
	private Context context;
	
	private Integer[] imagesArray;

	public ImagesAdapter(Context context, Integer[] imagesArray)
	{
		super();
		this.context = context;
		this.imagesArray = imagesArray;
	}

	@Override
	public int getCount()
	{
		return imagesArray.length;
	}

	@Override
	public Object getItem(int position)
	{
		return position;
	}

	@Override
	public long getItemId(int position)
	{
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		if (convertView == null){
			//需要返回的是ImageView,因为要实现的是相册
			ImageView view = new ImageView(this.context);
			//得到图片资源ID
			int id = imagesArray[position];
			//设置imageview的资源ID
			view.setImageResource(id);
			//对ImageView进行布局
			view.setLayoutParams(new Gallery.LayoutParams(80, 80));
			//设置ImageView的图片显示类型为fittx
			view.setScaleType(ImageView.ScaleType.FIT_XY);
			convertView = view;
		}
		return convertView;
	}

}
