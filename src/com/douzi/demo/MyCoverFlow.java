package com.douzi.demo;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Transformation;
import android.widget.Gallery;
import android.widget.ImageView;

/**
 * 自定义控件类，继承自Gallery
 * 
 * @author administrator
 *
 */
public class MyCoverFlow extends Gallery
{
	// 定义Camera对象来实现Gallery的伪3D效果
	private Camera camera = new Camera();

	// 标记Gallery旋转的最大角度
	private int maxRotation = 60;
	// 当旋转角度改变是图片大小进行改变
	private int zoom = -120;
	// 定义Coverflow的中心点
	private int center;

	public MyCoverFlow(Context context)
	{
		super(context);
		// 设置图片可有倒影效果
		this.setStaticTransformationsEnabled(true);
	}

	public MyCoverFlow(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		this.setStaticTransformationsEnabled(true);
	}

	public MyCoverFlow(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
		this.setStaticTransformationsEnabled(true);
	}

	/**
	 * 得到图片的中心位置
	 * 
	 * @return
	 */
	private int getCenter()
	{
		return (getWidth() - getPaddingLeft() - getPaddingRight()) / 2
				+ getPaddingLeft();
	}

	/**
	 * 得到整个View的中心位置
	 * 
	 * @param view
	 * @return
	 */
	private int getCenterOfView(View view)
	{
		return view.getLeft() + view.getWidth() / 2;
	}

	@Override
	protected boolean getChildStaticTransformation(View child,
			Transformation trans)
	{
		// 得到中心点
		final int childCenter = getCenterOfView(child);
		// 得到item的宽度
		final int childWidth = child.getWidth();
		// 默认角度为0
		int rotationAngle = 0;
		//
		trans.clear();
		// 根据Matrix矩阵旋转
		trans.setTransformationType(Transformation.TYPE_MATRIX);
		if (childCenter == center)
		{
			// 设置旋转后的图片
			setTransImage((ImageView) child, trans, 0);

		} else
		{
			// 根据中心位置计算旋转角度
			rotationAngle = (int) (((float) (center - childCenter) / childWidth)
					* maxRotation);
			if (Math.abs(rotationAngle) > maxRotation)
			{
				rotationAngle = (rotationAngle < 0) ? -maxRotation
						: maxRotation;
			}
			// 设置旋转后的图片
			setTransImage((ImageView) child, trans, rotationAngle);
		}
		return true;
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh)
	{
		center = getCenter();
		super.onSizeChanged(w, h, oldw, oldh);
	}

	private void setTransImage(ImageView child, Transformation t,
			int rotationAngle)
	{
		//保存当前内容
		camera.save();
		//得到旋转矩阵
		final Matrix imageMatrix = t.getMatrix();
		//得到imageView高度
		final int imageHeight = child.getLayoutParams().height;
		//得到imageView宽度
		final int imageWidth = child.getLayoutParams().width;
		//得到imageView角度
		final int rotation = Math.abs(rotationAngle);
		//根据camer的移动方向决定角度
		camera.translate(0.0f, 0.0f, 100.0f);
		//根据旋转的角度得到图片的放大倍数
		if (rotation < maxRotation){
			float zoomAmount = (float)(zoom + (rotation * 1.5));
			camera.translate(0.0f, 0.0f, zoomAmount);
		}
		//设置y轴的旋转角度
		camera.rotateY(rotation);
		//得到旋转的矩阵
		camera.getMatrix(imageMatrix);
		//设置旋转矩阵的倒影宽高
		imageMatrix.preTranslate(-(imageWidth / 2), -(imageHeight / 2));
		imageMatrix.postTranslate((imageWidth / 2), (imageHeight / 2));
		//保存视角效果
		camera.restore();
	}
}
