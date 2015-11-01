package com.douzi.demo.event;

import android.R.color;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * 屏幕多点触摸测试器
 * 
 * @author Administrator
 *
 */
public class MultPointView extends SurfaceView implements SurfaceHolder.Callback
{
	// 最多的触摸点数量
	private static final int MAX_TOUCHPOINTS = 10;
	// 提示的问题
	private static final String START_TEXT = "请单点或多点触摸屏幕进行测试";

	// 文字画笔
	private Paint textPaint = new Paint();
	// 圆形画笔
	private Paint touchPaints[] = new Paint[MAX_TOUCHPOINTS];
	// 对应每一个圆形画笔的颜色
	private int colors[] = new int[MAX_TOUCHPOINTS];
	// 记录屏幕的宽度和高度
	private int width, height;
	// 放大的倍数
	private float scale = 1.0f;

	public MultPointView(Context context)
	{
		super(context);
		// 得到当前View的Surfaceholder对象
		SurfaceHolder holder = getHolder();
		// 设置当前holder的回调方法
		holder.addCallback(this);
		// 确保我们的View能获得输入焦点
		setFocusable(true);
		// 确保能接收到触屏事件
		setFocusableInTouchMode(true);
		// 初始化颜色值
		init();
	}

	private void init()
	{
		// 初始化文字笔的颜色
		textPaint.setColor(Color.WHITE);
		// 定义十种按钮的颜色值
		colors[0] = Color.BLUE;
		colors[1] = Color.RED;
		colors[2] = Color.GREEN;
		colors[3] = Color.YELLOW;
		colors[4] = Color.CYAN;
		colors[5] = Color.MAGENTA;
		colors[6] = Color.DKGRAY;
		colors[7] = Color.WHITE;
		colors[8] = Color.LTGRAY;
		colors[9] = Color.GRAY;
		// 分别初始化每个手指的颜色值的笔
		for (int i = 0; i < MAX_TOUCHPOINTS; i++)
		{
			touchPaints[i] = new Paint();
			touchPaints[i].setColor(colors[i]);
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		int pointerCount = event.getPointerCount();
		if (pointerCount > MAX_TOUCHPOINTS)
		{
			pointerCount = MAX_TOUCHPOINTS;
		}
		Canvas c = getHolder().lockCanvas();
		if (c != null)
		{
			c.drawColor(Color.BLACK);
			if (event.getAction() == MotionEvent.ACTION_UP)
			{
				// 当手离开屏幕时，清屏
			}
			else
			{
				//先在屏幕上画一个十字，横向贯穿屏幕，纵向贯穿屏幕
				for (int i = 0; i < pointerCount; i++)
				{
					//获取一个触点的坐标，然后开始绘制
					int id = event.getPointerId(i);
					int x = (int)event.getX(i);
					int y = (int)event.getY(i);
					//drawCrosshairsAndText(x, y, touchPaints[id], i, id, c);
				}
				//使用不同的颜色在每个手指的位置画圆
				for (int i = 0; i < pointerCount; i++){
					int id= event.getPointerId(i);
					int x = (int)event.getX(i);
					int y = (int)event.getY(i);
					//drawCircle(x, y, touchPaints[id], c);
				}

			}
			//画完后，解锁显示
			getHolder().unlockCanvasAndPost(c);
		}

		return super.onTouchEvent(event);
	}
	
	

	@Override
	public void surfaceCreated(SurfaceHolder holder)
	{

	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height)
	{

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder)
	{

	}
}
