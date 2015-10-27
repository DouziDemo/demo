package com.douzi.demo.event;

import com.douzi.demo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class SeeImageActivity extends Activity
{
	private TextView resultTextView;
	private TextView redTextView;
	private TextView blueTextView;
	private TextView greenTextView;
	private TextView ratTextView;
	private TextView elephantTextView;
	private TextView tigerTextView;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_event_see_image);
		resultTextView = (TextView)findViewById(R.id.textview_event_see_image_result);
		redTextView = (TextView)findViewById(R.id.textview_event_see_image_red);
		blueTextView = (TextView)findViewById(R.id.textview_event_see_image_blue);
		greenTextView = (TextView)findViewById(R.id.textview_event_see_image_green);
		ratTextView = (TextView)findViewById(R.id.textview_event_see_image_rad);
		elephantTextView = (TextView)findViewById(R.id.textview_event_see_image_elephant);
		tigerTextView = (TextView)findViewById(R.id.textview_event_see_image_tiger);
		
		redTextView.setOnClickListener(mylistener);
		blueTextView.setOnClickListener(mylistener);
		greenTextView.setOnClickListener(mylistener);
		ratTextView.setOnClickListener(mylistener);
		elephantTextView.setOnClickListener(mylistener);
		tigerTextView.setOnClickListener(mylistener);
	}
	
	OnClickListener mylistener = new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			switch (v.getId())
			{
			case R.id.textview_event_see_image_red:
				resultTextView.setText("您选择了红色。");
				break;
			case R.id.textview_event_see_image_blue:
				resultTextView.setText("您选择了蓝色。");
				break;
			case R.id.textview_event_see_image_green:
				resultTextView.setText("您选择了绿色。");
				break;
			case R.id.textview_event_see_image_rad:
				resultTextView.setText("您选择了老鼠。");
				break;
			case R.id.textview_event_see_image_elephant:
				resultTextView.setText("您选择了大象。");
				break;
			case R.id.textview_event_see_image_tiger:
				resultTextView.setText("您选择了老虎。");
				break;
			}
		}
	};
}
