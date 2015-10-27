package com.douzi.demo.event;

import com.douzi.demo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
/**
 * 添加联系人
 * @author Administrator
 *
 */
public class AddContactsActivity extends Activity
{
	private Button addContactsButton;
	
	private int count;
	
	private LinearLayout ll;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_event_add_contacts);
		ll = (LinearLayout)findViewById(R.id.linearlayout_ll);
		addContactsButton = (Button)findViewById(R.id.button_add_contacts);
		addContactsButton.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				addEditText();
			}
		});
	}
	
	@Override
	public void onContentChanged()
	{
		super.onContentChanged();
		Toast.makeText(AddContactsActivity.this, "已经添加了"+count+"个联系人！", Toast.LENGTH_SHORT).show();
		count++;
	}
	
	private void addEditText(){
		EditText e = new EditText(AddContactsActivity.this);
		e.setHint("请输入第"+count+"个联系人的信息");
		ll.addView(e);
		setContentView(ll);
		
	}
}
