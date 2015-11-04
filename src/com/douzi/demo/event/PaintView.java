package com.douzi.demo.event;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
/**
 * 画笔
 * @author Administrator
 *
 */
public class PaintView extends View
{
	private int mLastX, mLastY;
	private int mCurrX, mCurrY;
	private Bitmap mBitmap;
	private Paint mPaint;
	

	public PaintView(Context context)
	{
		super(context);
		//初始化画笔
		mPaint = new Paint();
		mPaint.setStrokeWidth(6);
	}
	
	@Override
	protected void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);
		int width = getWidth();
		int height = getHeight();
		if (mBitmap == null){
			mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
		}
		//将之前的bitmap的结果画到当前的页面上
		Canvas tmpCanvas = new Canvas(mBitmap);
		//在当前的页面上划线
		tmpCanvas.drawLine(mLastX, mLastY, mCurrX, mCurrY, mPaint);
		//再把bitmap画到canvas上
		canvas.drawBitmap(mBitmap, 0, 0, mPaint);
				
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		mLastX = mCurrX;
		mLastY = mCurrY;
		mCurrX = (int)event.getX();
		mCurrY = (int)event.getY();
		switch (event.getAction())
		{
		case MotionEvent.ACTION_DOWN:
			mLastX = mCurrX;
			mLastY = mCurrY;
			break;
		default:
			break;
		}
		//重绘view
		invalidate();
		return true;
	}

}
