package com.douzi.demo.sundy.graphic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class GameControlRobotView extends View
{
	int mCount = 0;
	int x,y = 0;
	
	public GameControlRobotView(Context context)
	{
		super(context);
		setFocusable(true);
		setFocusableInTouchMode(true);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		return false;
	}
	
	@Override
	protected void onDraw(Canvas canvas)
	{
		if (mCount < 100 ){
			mCount ++;
		}
		else{
			mCount = 0;
		}
		Paint _Paint = new Paint();
		switch (mCount%4)
		{
		case 0:
			_Paint.setColor(Color.BLUE);
			break;
		case 1:
			_Paint.setColor(Color.GREEN);
			break;
		case 2:
			_Paint.setColor(Color.RED);
			break;
		case 3:
			_Paint.setColor(Color.YELLOW);
			break;
		default:
			_Paint.setColor(Color.WHITE);
			break;
		}
		canvas.drawRect(x, y, x+60, y+40, _Paint);
	}

}
