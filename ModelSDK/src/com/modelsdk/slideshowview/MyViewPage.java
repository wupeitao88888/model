package com.modelsdk.slideshowview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;

public class MyViewPage extends ViewPager {
	public MyViewPage(Context context) {
		super(context);

	}

	public MyViewPage(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {

//		if (v instanceof HorizontalScrollView) {
//			return true;
//		}
		return super.canScroll(v, checkV, dx, x, y);
	}
}
