package com.douzi.demo.menu;

import com.douzi.demo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class PopupMenuActivity extends Activity
{
	private TextView popTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_popup_menu);

		popTextView = (TextView) findViewById(R.id.textview_popupmenu);
		popTextView.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				PopupMenu popupMenu = new PopupMenu(PopupMenuActivity.this, v);
				popupMenu.getMenuInflater().inflate(R.menu.sys_popup_menu,
						popupMenu.getMenu());
				popupMenu.setOnMenuItemClickListener(
						new OnMenuItemClickListener()
				{

					@Override
					public boolean onMenuItemClick(MenuItem item)
					{
						Toast.makeText(PopupMenuActivity.this,
								"你选择了：" + item.getTitle(), Toast.LENGTH_SHORT)
								.show();
						return true;
					}
				});
				popupMenu.show();
			}
		});
	}
}
