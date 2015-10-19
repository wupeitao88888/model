package com.modelsdk.view.viewflipper;

import java.util.ArrayList;
import java.util.List;

import com.modelsdk.mian.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.OnGestureListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MyViewFlipper extends RelativeLayout implements OnGestureListener {
	private List<ImageView> ivs = new ArrayList<ImageView>();
	private List<Integer> list = new ArrayList<Integer>();
	private LinearLayout ll_dot;
	private ViewFlipper flipper;
	private GestureDetector detector;
	private Context context;

	public MyViewFlipper(Context context) {
		super(context);
		init(context);
	}

	public MyViewFlipper(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	@SuppressLint("InflateParams")
	private void init(Context context) {
		// TODO Auto-generated method stub
		this.context = context;
		detector = new GestureDetector(context,this);
		View inflate = LayoutInflater.from(context).inflate(
				R.layout.layout_viewflipper, null);
		ll_dot = (LinearLayout) inflate.findViewById(R.id.ll_dot);
		flipper = (ViewFlipper) inflate.findViewById(R.id.viewflipper);
		addView(inflate);
	}

	public void setListView(List<Integer> intlist) {
		this.list = intlist;
		for (int i = 0; i < list.size(); i++) {
			ImageView imageView2 = new ImageView(context);
			imageView2.setImageResource(R.drawable.dot);
			ll_dot.addView(imageView2, new LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
			ivs.add(imageView2);
			ImageView imageView = new ImageView(context);
			imageView.setImageResource(list.get(i));
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);
			flipper.addView(imageView, new LayoutParams(
					LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		}
		ivs.get(0).setEnabled(false);
	}

	private void dotChange(int index) {
		for (int i = 0; i < ivs.size(); i++) {
			if (i == index) {
				ivs.get(i).setEnabled(false);
			} else {
				ivs.get(i).setEnabled(true);
			}
		}
	}

	@Override
	public boolean onDown(MotionEvent e) {
		
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {

	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		return false;
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {

	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		Log.e(VIEW_LOG_TAG, "添加动画");
		if (e1.getX() - e2.getX() > 120) {
			// 添加动画
			this.flipper.setInAnimation(AnimationUtils.loadAnimation(context,
					R.anim.push_left_in));
			this.flipper.setOutAnimation(AnimationUtils.loadAnimation(context,
					R.anim.push_left_out));
			View view = flipper.getChildAt(list.size() - 1);
			View view1 = flipper.getCurrentView();
			// flipper.getDisplayedChild();

			if (view == view1) {
				Toast.makeText(context, "最后一张", Toast.LENGTH_LONG).show();
				// return false;
			} else {
				this.flipper.showNext();
				dotChange(flipper.getDisplayedChild());
			}
			return true;
		}// 从右向左滑动
		else if (e1.getX() - e2.getX() < -120) {
			this.flipper.setInAnimation(AnimationUtils.loadAnimation(context,
					R.anim.push_right_in));
			this.flipper.setOutAnimation(AnimationUtils.loadAnimation(context,
					R.anim.push_right_out));
			if (flipper.getChildAt(0) == flipper.getCurrentView()) {
				Toast.makeText(context, "第一张", Toast.LENGTH_LONG).show();
			} else {
				this.flipper.showPrevious();
				dotChange(flipper.getDisplayedChild());
			}
			return true;
		}
		return true;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Log.e("+++++++++++++", "++++++++++++++++++++++"+this.detector.onTouchEvent(event));
		return true;
	}
}
