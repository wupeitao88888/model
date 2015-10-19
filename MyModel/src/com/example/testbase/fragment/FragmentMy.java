package com.example.testbase.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testbase.commom.T;
import com.model.main.R;

public class FragmentMy extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_my, null);

		T.showShort(getActivity(), "FragmentMy==onCreateView");

		return view;
	}
}
