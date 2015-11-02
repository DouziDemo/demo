package com.douzi.demo.event;

import com.douzi.demo.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.widget.ImageView;

public class MyImageView extends ImageView
{

	
	
	
	private float x_down = 0;
	
	private float y_down = 0;
	//起始点的坐标
	private PointF start = new PointF();
	//中心点的坐标
	private PointF mid = new PointF();
	//原始距离
	private float oldDist = 1f;
	//旋转角度
	private float oldRotation = 0;
	//矩阵对象
	private Matrix matrix = new Matrix();
	private Matrix matrix1 = new Matrix();
	private Matrix saveMatrix = new Matrix();
	
	private static final int NOTE = 0;
	private static final int DRAG = 1;
	private static final int ZOOM = 2;
	private boolean matrixCheck = false;
	
	//记录当前屏幕的宽度
	private int widthScreen;
	//记录当前屏幕的高度
	private int heightScreen;
	//在页面中显示的Bitmap图片
	private Bitmap kenan;
	
	public MyImageView(Context context)
	{
		super(context);
		kenan = BitmapFactory.decodeResource(getResources(), R.drawable.kenan);
		DisplayMetrics dm = new DisplayMetrics();
		
		
	}

}
