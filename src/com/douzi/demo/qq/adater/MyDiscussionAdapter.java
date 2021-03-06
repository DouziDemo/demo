package com.douzi.demo.qq.adater;

import java.util.ArrayList;
import java.util.List;

import com.douzi.demo.R;
import com.douzi.demo.qq.moudle.MyDiscussion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyDiscussionAdapter extends BaseAdapter
{
	private List<MyDiscussion> list = new ArrayList<MyDiscussion>();
	private Context context;

	public MyDiscussionAdapter(java.util.List<MyDiscussion> list,
			Context context)
	{
		this.list = list;
		this.context = context;
	}

	@Override
	public int getCount()
	{
		return list.size();
	}

	@Override
	public Object getItem(int position)
	{
		return list.get(position);
	}

	@Override
	public long getItemId(int position)
	{
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		ViewHolder viewHolder = null;
		if (convertView == null)
		{
			convertView = LayoutInflater.from(context)
					.inflate(R.layout.layout_qq_mydiscussion_item, null);
			viewHolder = new ViewHolder();
			viewHolder.image = (ImageView) convertView
					.findViewById(R.id.imageview_qq_mydiscussion_item);
			viewHolder.name = (TextView) convertView
					.findViewById(R.id.textview_qq_mydiscussion_title);
			viewHolder.number = (TextView) convertView
					.findViewById(R.id.textview_qq_mydiscussion_info);
			convertView.setTag(viewHolder);
		} else
		{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.image.setBackgroundResource(list.get(position).getImgId());
		viewHolder.name.setText(list.get(position).getName());
		viewHolder.number.setText(list.get(position).getInfo());
		return convertView;
	}

	class ViewHolder
	{
		ImageView image;
		TextView name;
		TextView number;
	}

}
