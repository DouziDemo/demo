package com.douzi.demo.sundy.graphic;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;

public class HelloGameControlActivity extends Activity
{
	private GameControlRobotView gameControlRobotView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		gameControlRobotView = new GameControlRobotView(this);
		setContentView(gameControlRobotView);
		new Thread(new GameThread()).start();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		switch (keyCode)
		{
		case KeyEvent.KEYCODE_VOLUME_UP:
			gameControlRobotView.y -= 3;
			break;
		case KeyEvent.KEYCODE_VOLUME_DOWN:
			gameControlRobotView.y += 3;
			break;
		case KeyEvent.KEYCODE_DPAD_DOWN:
			gameControlRobotView.y += 3;
			break;
		case KeyEvent.KEYCODE_DPAD_UP:
			gameControlRobotView.y -= 3;
			break;
		case KeyEvent.KEYCODE_DPAD_LEFT:
			gameControlRobotView.x -= 3;
			break;
		case KeyEvent.KEYCODE_DPAD_RIGHT:
			gameControlRobotView.x += 3;
			break;
		}
		return false;
	}
	class GameThread extends Thread
	{
		@Override
		public void run()
		{
			// 如果当前线程没有被中断
			while (!Thread.currentThread().isInterrupted())
			{
				try
				{
					//每隔一秒
					Thread.sleep(1000);
				} catch (InterruptedException e)
				{
					Thread.currentThread().interrupt();
				}
				//每隔一秒刷新一次gameControlRobotView
				gameControlRobotView.postInvalidate();
			}
		}
	}
}
