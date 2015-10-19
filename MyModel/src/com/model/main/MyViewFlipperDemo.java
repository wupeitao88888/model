package com.model.main;

import java.util.ArrayList;
import java.util.List;

import com.modelsdk.base.ActivitySupport;
import com.modelsdk.view.viewflipper.MyViewFlipper;

import android.app.Activity;
import android.os.Bundle;

public class MyViewFlipperDemo extends ActivitySupport {
	private MyViewFlipper myviewf;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_mviewflipper);
		setRemoveTitle();
		myviewf = (MyViewFlipper) findViewById(R.id.myviewf);
		List<Integer> list = new ArrayList<Integer>();
		list.add(R.drawable.bg1);
		list.add(R.drawable.bg2);
		list.add(R.drawable.bg3);
		list.add(R.drawable.bg4);
		myviewf.setListView(list);
	}

}
