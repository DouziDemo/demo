package com.douzi.demo;

import javax.security.auth.PrivateCredentialPermission;

import android.app.Activity;
import android.os.Bundle;

public class MycoverflowActivity extends Activity
{
	private Integer[] imgs = {
			R.drawable.b1,
			R.drawable.b2,
			R.drawable.b3,
			R.drawable.b4,
			R.drawable.b5,
			R.drawable.b6
	};
	
	private MyCoverFlow myCoverFlow;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_coverflow);
		
		ImgsAdapter adapter = new ImgsAdapter(this, imgs);
		adapter.invertedImages();
		
		myCoverFlow = (MyCoverFlow)findViewById(R.id.mycoverflow_image);
		myCoverFlow.setAdapter(adapter);

	}
}
