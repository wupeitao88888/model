package com.model.main;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.modelsdk.base.LCActivitySupport;

public class Wecome extends LCActivitySupport {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main);
	}


}
