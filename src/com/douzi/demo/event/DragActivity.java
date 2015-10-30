package com.douzi.demo.event;

import com.douzi.demo.R;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;

public class DragActivity extends Activity
{
	private AreaOne dragAreaOne;

	private AreaTwo dragAreaTwo;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_event_drag_area);
		dragAreaOne = (AreaOne) findViewById(R.id.areaone_drag);
		dragAreaTwo = (AreaTwo) findViewById(R.id.areatwo_drag);
		dragAreaOne.setOnLongClickListener(new OnLongClickListener()
		{

			@Override
			public boolean onLongClick(View v)
			{
				dragAreaOne.startDrag(null, new DragShadowBuilder(v),
						(Object) v, 0);
				return true;
			}
		});

		dragAreaTwo.setOnDragListener(new OnDragListener()
		{

			@Override
			public boolean onDrag(View v, DragEvent event)
			{
				boolean result = false;
				switch (event.getAction())
				{
				case DragEvent.ACTION_DRAG_STARTED:
					Log.e("douzi", "view 开始被拖动");
					/**
					 * 只有返回true,后面的动作才会被执行
					 */
					result = true;
					break;
					//当拖动的View进入当前View时被调用
				case DragEvent.ACTION_DRAG_ENTERED:
					Log.e("douzi", "被拖动的View进入当前View!");
					break;
					//被拖动的View进入当前View后，位置改变时被回调
				case DragEvent.ACTION_DRAG_LOCATION:
					Log.e("douzi", "被拖动的View进入当前View后，位置发生改变");
					break;
					//当拖动的View被放入当前View时被回调
				case DragEvent.ACTION_DROP:
					Log.e("douzi", "拖动的View被放入当前View");
					View mDragView = (View)event.getLocalState();
					Drawable mDragViewBackgroud = mDragView.getBackground();
					mDragView.setBackgroundDrawable(mDragView.getBackground());
					break;
					//拖动结束时被回调
				case DragEvent.ACTION_DRAG_ENDED:
					Log.e("douzi", "拖动结束！");
					//拖动结束时调用的分支
					break;
					//拖动完成时被回调
				case DragEvent.ACTION_DRAG_EXITED:
					Log.e("douzi", "拖动退出!");
					//拖动完成时走入的分支 
					break;
				default:
					break;
				}
				return result;
			}
		});
	}
}
