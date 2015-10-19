package com.example.testbase.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testbase.commom.T;
import com.example.testbase.subfragment.SubFragment1;
import com.example.testbase.subfragment.SubFragment2;
import com.example.testbase.subfragment.SubFragment3;
import com.model.main.R;

public class FragmentMessage extends Fragment {

	FragmentTabHost mTabHost = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		
		Bundle bundle = getArguments();
		if (null != bundle) {
			//
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		T.showShort(getActivity(), "FragmentMessage==onCreateView");
		View view = inflater.inflate(R.layout.fragment_message1, null);

		initView(view);

		return view;
	}

	private void initView(View view) {

		mTabHost = (FragmentTabHost) view.findViewById(android.R.id.tabhost);
		
		mTabHost.setup(getActivity(), getChildFragmentManager(),
				android.R.id.tabcontent);

		mTabHost.addTab(mTabHost.newTabSpec("sub1").setIndicator("新闻"),
				SubFragment1.class, null);

		mTabHost.addTab(mTabHost.newTabSpec("sub2").setIndicator("财经"),
				SubFragment2.class, null);

		mTabHost.addTab(mTabHost.newTabSpec("sub3").setIndicator("旅游"),
				SubFragment3.class, null);
		
		mTabHost.getTabWidget().setDividerDrawable(R.color.white);

	}

}
