package com.model.main;



import android.os.Bundle;

import com.modelsdk.base.ActivitySupport;
import com.modelsdk.view.StartPic;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;


public class Welcome extends ActivitySupport {

	
	private StartPic startPic;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_welcome);
		setRemoveTitle();
		startPic=(StartPic)findViewById(R.id.startPic);
		startPic.setAnimationListener(new AnimatorListener() {
			
			@Override
			public void onAnimationStart(Animator arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animator arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animator arg0) {
				// TODO Auto-generated method stub
				mIntent(Welcome.this,GuidanceOptions.class);
				finish();
			}
			
			@Override
			public void onAnimationCancel(Animator arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	
	}
	
	

	
	
	
}
