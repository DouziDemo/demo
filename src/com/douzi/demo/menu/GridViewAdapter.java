package com.douzi.demo.menu;

import java.util.List;

import com.douzi.demo.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridViewAdapter extends BaseAdapter
{
	private Context context;
	private List<Item> fileList;

	public GridViewAdapter(Context context, List<Item> fileList)
	{
		this.context = context;
		this.fileList = fileList;
	}

	@Override
	public int getCount()
	{
		return fileList.size();
	}

	@Override
	public Object getItem(int position)
	{
		return fileList.get(position);
	}

	@Override
	public long getItemId(int position)
	{
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		ViewHolder viewHolder = new ViewHolder();
		if (convertView == null){
			//初始化当前view的布局视图
			convertView = LayoutInflater.from(context).inflate(R.layout.menu_item, null);
		}
		viewHolder.fileImage = (ImageView)convertView.findViewById(R.id.imageview_menu_item);
		viewHolder.fileName = (TextView)convertView.findViewById(R.id.textview_menu_item);
		
		viewHolder.fileImage.setBackgroundResource(fileList.get(position).getItemImg());
		viewHolder.fileName.setText(fileList.get(position).getItemTitle());
		return convertView;
	}

	class ViewHolder
	{
		ImageView fileImage;
		TextView fileName;
	}

}
