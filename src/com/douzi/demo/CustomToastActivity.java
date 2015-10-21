package com.douzi.demo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 自定义Toast
 * 
 * @author administrator
 *
 */
public class CustomToastActivity extends Activity
{
	Handler handler = new Handler();
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_custom_toast);
		Button b1 = (Button) findViewById(R.id.button_toast_default);
		//默认Toast样式
		b1.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				Toast.makeText(CustomToastActivity.this, "默认Toast样式",
						Toast.LENGTH_SHORT).show();
			}
		});
		//自定义显示位置效果
		Button b2 = (Button) findViewById(R.id.button_toast_weizi);
		b2.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				Toast t = Toast.makeText(CustomToastActivity.this, "自定义显示位置效果",
						Toast.LENGTH_SHORT);
				t.setGravity(Gravity.CENTER, 0, 0);
				t.show();
			}
		});
		//带图片效果
		Button b3 = (Button) findViewById(R.id.button_toast_image);
		b3.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				Toast t = Toast.makeText(CustomToastActivity.this, "带图片效果",
						Toast.LENGTH_SHORT);
				t.setGravity(Gravity.CENTER, 0, 0);
				LinearLayout layout = (LinearLayout)t.getView();
				ImageView iv = new ImageView(getApplicationContext());
				iv.setImageResource(R.drawable.ic_launcher);
				layout.addView(iv, 0);
				t.show();
			}
		});
		//完全自定义效果
		Button b4 = (Button) findViewById(R.id.button_toast_all);
		b4.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				LayoutInflater inflater = getLayoutInflater();
				   View layout = inflater.inflate(R.layout.custom,
				     (ViewGroup) findViewById(R.id.llToast));
				   ImageView image = (ImageView) layout
				     .findViewById(R.id.tvImageToast);
				   image.setImageResource(R.drawable.ic_launcher);
				   TextView title = (TextView) layout.findViewById(R.id.tvTitleToast);
				   title.setText("Attention");
				   TextView text = (TextView) layout.findViewById(R.id.tvTextToast);
				   text.setText("完全自定义Toast");
				   Toast toast = new Toast(getApplicationContext());
				   toast.setGravity(Gravity.RIGHT | Gravity.TOP, 12, 40);
				   toast.setDuration(Toast.LENGTH_LONG);
				   toast.setView(layout);
				   toast.show();
			}
		});
		//我来自其他线程
		Button b5 = (Button) findViewById(R.id.button_toast_other_thread);
		
		b5.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				handler.post(new Runnable() {

			   @Override
			   public void run() {
			    Toast.makeText(getApplicationContext(), "我来自其他线程！",
			      Toast.LENGTH_SHORT).show();

			   }
			  });
			}
		});
	}
}
