package com.douzi.demo.event;

import com.douzi.demo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.ViewFlipper;

public class ViewFlipperActivity extends Activity implements OnGestureListener
{
	private ViewFlipper viewFlipper;
	private GestureDetector detector;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_viewflipper);
		viewFlipper = (ViewFlipper)findViewById(R.id.viewflipper01);
		detector = new GestureDetector(this);
	}

	//当页面被触摸时自动回调，把拿到的事件给手势识别器进行处理
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		return this.detector.onTouchEvent(event);
	}
	//当页面被按下时自动回调
	@Override
	public boolean onDown(MotionEvent e)
	{
		// TODO Auto-generated method stub
		return false;
	}

	//当界面被按压时候自动调用
	@Override
	public void onShowPress(MotionEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	//当轻击界面的时候自动调用
	@Override
	public boolean onSingleTapUp(MotionEvent e)
	{
		// TODO Auto-generated method stub
		return false;
	}

	//界面滚动的时候自动调用
	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY)
	{
		// TODO Auto-generated method stub
		return false;
	}

	//当在界面长按时自动调用
	@Override
	public void onLongPress(MotionEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	/**
	 * 当在页面中滑动时自动回调
	 */
	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY)
	{
		//得到滑动过程中的亮点的x和y坐标，进行判断
		if (e1.getX() > e2.getY()){
			//当向左滑动时显示上一张
			this.viewFlipper.showNext();
			
		}else if (e1.getX() < e2.getX()){
			//当向右滑动时显示下一张
			this.viewFlipper.showPrevious();
		}else{
			return false;
		}
		return true;
	}
}
