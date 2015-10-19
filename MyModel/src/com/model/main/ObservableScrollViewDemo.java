package com.model.main;

import com.modelsdk.base.ActivitySupport;
import com.modelsdk.view.ObservableScrollView.FeatureAnimationListener;
import com.modelsdk.view.ObservableScrollView.ObservableScrollView;
import com.modelsdk.view.ObservableScrollView.OnScrollChangedListener;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class ObservableScrollViewDemo extends ActivitySupport implements OnGlobalLayoutListener, OnScrollChangedListener {
	private ObservableScrollView mScrollView;
	private View mAnimView;
	private int mScrollViewHeight;
	private int mStartAnimateTop;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_obsevablesv);
		setRemoveTitle();
		mScrollView = (ObservableScrollView)this.findViewById(R.id.scrollView1);
		mScrollView.getViewTreeObserver().addOnGlobalLayoutListener(this);
		mScrollView.setOnScrollChangedListener(this);
		
		mAnimView = this.findViewById(R.id.anim1);
		mAnimView.setVisibility(View.INVISIBLE);
	}


	@Override
	public void onGlobalLayout() {
		mScrollViewHeight = mScrollView.getHeight();
		mStartAnimateTop = mScrollViewHeight / 3 * 2;
	}

	boolean hasStart = false;
	@Override
	public void onScrollChanged(int top, int oldTop) {
		int animTop = mAnimView.getTop() - top;
		
		if(top > oldTop) {
			if(animTop < mStartAnimateTop && !hasStart) {
				Animation anim1 = AnimationUtils.loadAnimation(this, R.anim.feature_anim2scale_in);
				anim1.setAnimationListener(new FeatureAnimationListener(mAnimView, true));
				
				mAnimView.startAnimation(anim1);
				hasStart = true;
			}
		} else {
			if(animTop > mStartAnimateTop && hasStart) {
				Animation anim1 = AnimationUtils.loadAnimation(this, R.anim.feature_alpha_out);
				anim1.setAnimationListener(new FeatureAnimationListener(mAnimView, false));
				
				mAnimView.startAnimation(anim1);
				hasStart = false;
			}
		}
	}
}
