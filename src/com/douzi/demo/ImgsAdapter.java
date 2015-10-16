package com.douzi.demo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader.TileMode;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class ImgsAdapter extends BaseAdapter
{
	private Context context;
	
	private Integer[] imageIds;
	
	private ImageView[] images;
	
	
	
	public ImgsAdapter(Context context, Integer[] imageIds)
	{
		super();
		this.context = context;
		this.imageIds = imageIds;
		images = new ImageView[imageIds.length];
	}
	
	public boolean invertedImages(){
		final int reflectionGap = 4;
		
		int index = 0;
		
		for (int imageId : imageIds){
			Bitmap originalImage = BitmapFactory.decodeResource(context.getResources(), imageId);
			int width = originalImage.getWidth();
			int height = originalImage.getHeight();
			
			Matrix matrix = new Matrix();
			matrix.preScale(1, -1);
			
			Bitmap reflectionImage = Bitmap.createBitmap(originalImage, 0, height/2, width, height/2,matrix,false);
			Bitmap bitmapWithReflection = Bitmap.createBitmap(width, (height + height /2 ), Config.ARGB_8888);
			Canvas canvas = new Canvas(bitmapWithReflection);
			canvas.drawBitmap(originalImage, 0, 0, null);
			Paint deafaultPaint = new Paint();
			canvas.drawRect(0, height, width, height + reflectionGap, deafaultPaint);
			canvas.drawBitmap(reflectionImage, 0, height + reflectionGap, null);
			Paint paint = new Paint();
			LinearGradient shader = new LinearGradient(0, originalImage.getHeight(), 0, bitmapWithReflection.getHeight()+reflectionGap, 0x70ffffff, 0x00ffffff, TileMode.CLAMP);
			paint.setShader(shader);
			paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
			canvas.drawRect(0, height, width, bitmapWithReflection.getHeight()+reflectionGap, paint);
			ImageView imageView = new ImageView(context);
			imageView.setImageBitmap(bitmapWithReflection);
			imageView.setLayoutParams(new Gallery.LayoutParams(100, 200));
			
			images[index++] = imageView;
		}
		return true;
	}

	@Override
	public int getCount()
	{
		return imageIds.length;
	}

	@Override
	public Object getItem(int position)
	{
		return position;
	}

	@Override
	public long getItemId(int position)
	{
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		return images[position];
	}

}
