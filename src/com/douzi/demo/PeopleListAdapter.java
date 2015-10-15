package com.douzi.demo;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter.CursorToStringConverter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class PeopleListAdapter extends CursorAdapter
{
	private LayoutInflater mInflater;

	public PeopleListAdapter(Context context, Cursor cursor)
	{
		super(context, cursor);
		mInflater = LayoutInflater.from(context);
	}

	/**
	 * 设置item页面的布局效果
	 */
	@Override
	public void bindView(View view, Context context, Cursor cursor)
	{
		ViewHolder viewHolder = new ViewHolder();
		viewHolder.peopleImage = (ImageView)view.findViewById(R.id.imageview_phone_contaces_item);
		viewHolder.peopleName = (TextView)view.findViewById(R.id.textview_phone_contaces_name_item);
		viewHolder.peopleNumber=(TextView)view.findViewById(R.id.textview_phone_contaces_phone_item);
		
		viewHolder.peopleImage.setBackgroundResource(R.drawable.ic_launcher);
		viewHolder.peopleName.setText(cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)));
		viewHolder.peopleNumber.setText(cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));
	}

	/**
	 * 初始化每个item的view
	 */
	@Override
	public View newView(Context context, Cursor curso, ViewGroup parent)
	{
		return mInflater.inflate(R.layout.layout_phone_contacts_list_item, parent, false);
	}

	/**
	 * 定义内部类作为占位符组合
	 * @author administrator
	 *
	 */
	class ViewHolder
	{
		ImageView peopleImage;
		TextView peopleName;
		TextView peopleNumber;
	}
}
