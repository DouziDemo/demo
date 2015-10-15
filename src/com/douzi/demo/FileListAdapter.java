package com.douzi.demo;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * 自定义adapter
 * @author administrator
 *
 */
public class FileListAdapter extends BaseAdapter
{
	private Context mContext;
	//定义要显示的MyFile列表
	private List<MyFile> fileList;

	public FileListAdapter(Context mContext, List<MyFile> fileList)
	{
		this.mContext = mContext;
		this.fileList = fileList;
	}

	/**
	 * 获取显示为条目数量
	 */
	@Override
	public int getCount()
	{
		return fileList.size();
	}

	/**
	 * 获取列表中的单个对象
	 */
	@Override
	public Object getItem(int position)
	{
		return fileList.get(position);
	}

	/**
	 * 获取列表中对象的ID
	 */
	@Override
	public long getItemId(int position)
	{
		return position;
	}

	/**
	 * 构造每一个item的View视图
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		//定义位置占位符类的对象
		ViewHolder viewHolder = new ViewHolder();
		if (convertView == null){
			//初始化当前view的布局视图
			convertView = LayoutInflater.from(mContext).inflate(R.layout.layout_filelist_item, null);
		}
		//获取到对应的控件对象
		viewHolder.fileImage = (ImageView)convertView.findViewById(R.id.imageview_fileitem);
		viewHolder.fileName = (TextView)convertView.findViewById(R.id.textview_fileitem);
		//给控件对象设置相应的内容
		viewHolder.fileImage.setBackgroundResource(fileList.get(position).getImageId());
		viewHolder.fileName.setText(fileList.get(position).getFileName());
		return convertView;
		
	}
	//定义内部类作为占位符组合
	class ViewHolder{
		ImageView fileImage;
		TextView fileName;
	}
}
