package com.douzi.demo.event;

import com.douzi.demo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

public class ImageSwitchActivity extends Activity
{
	private ImageView iv;
	// 定义手势检测器对象
	private GestureDetector gestureDetector;
	private int[] resId = new int[]
	{ R.drawable.k1, R.drawable.k2, R.drawable.k3 };
	// 定义当前显示的图片的下标
	private int count = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_image_switch);
		iv = (ImageView) findViewById(R.id.imageview_switch);
		//设置手势监听器的处理效果由OnGestureListener来处理
		gestureDetector = new GestureDetector(ImageSwitchActivity.this,
				onGestureListener);

	}

	//定义了GestureDetector的手势识别监听器
	private GestureDetector.OnGestureListener onGestureListener = new GestureDetector.SimpleOnGestureListener()
	{
		//当识别的手势是滑动手势时回调onFinger方法
		public boolean onFling(android.view.MotionEvent e1,
				android.view.MotionEvent e2, float velocityX, float velocityY)
		{
			//得到滑动手势的起始和结束点的x,y坐标，并进行计算
			float x = e2.getX() - e1.getX();
			float y = e2.getY() - e2.getY();
			//通过计算结果判断用户是向左滑动或向左滑动
			if (x > 0){
				count++;
				count%=3;
			}else if (x  < 0){
				count--;
				count = (count+3)%3;
			}
			changeImg();
			return true;
		};
	};
	
	public void changeImg(){
		iv.setImageResource(resId[count]);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		//当前Activity被触摸时回调
		return gestureDetector.onTouchEvent(event);
	}
}
