package com.douzi.demo.event;

import com.douzi.demo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;
/**
 * 获取XY坐标
 * @author Administrator
 *
 */
public class XYActivity extends Activity
{
	private TextView xyTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_event_motion);
		xyTextView = (TextView) findViewById(R.id.textview_event_xy);

	}

	/**
	 * ACTION_DOWN:用户按下屏幕的事件
	 * ACTION_MOVE：用户滑动的时间
	 * ACTION_UP：用户手指从按下状态抬起屏幕的时间
	 * event.getAction()得到操作事件的类型
	 * event.getDownTime()得到用户按下的时间
	 * event.getEventTime()得到用户操作的时间
	 * event.getPressure()得到用户的触摸压力值
	 */
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		if (event.getAction() == MotionEvent.ACTION_DOWN)
		{
			xyTextView.setText(
					"您单击的位置是：x:" + event.getX() + ",y:" + event.getY());
		}
		return super.onTouchEvent(event);
	}
}
