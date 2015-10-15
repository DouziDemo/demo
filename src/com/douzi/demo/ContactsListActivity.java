package com.douzi.demo;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ListView;

public class ContactsListActivity extends Activity
{
	private ListView listView01;

	private PeopleListAdapter adapter;

	private Cursor cursor;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_listview);

		listView01 = (ListView) findViewById(R.id.listview_student);
		//通过getcontentresolver获得手机中的联系人信息
		cursor = getContentResolver().query(
				ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null,
				null, null);
		adapter = new PeopleListAdapter(this, cursor);
		listView01.setAdapter(adapter);
	}
}
