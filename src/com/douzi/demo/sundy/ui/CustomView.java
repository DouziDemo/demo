package com.douzi.demo.sundy.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class CustomView extends View
{

	public CustomView(Context context)
	{
		super(context);
	}
	
	@Override
	public void draw(Canvas canvas)
	{
		super.draw(canvas);
		
		Paint paint = new Paint();
		paint.setColor(Color.RED);
		canvas.drawRect(90, 90, 80, 80, paint);
	}

}
