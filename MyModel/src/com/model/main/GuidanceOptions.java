package com.model.main;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.testbase.MainTab;
import com.model.adapter.GuidanceOptionsAdapter;
import com.modelsdk.base.ActivitySupport;
import com.modelsdk.view.PullScrollView;


/***
 * 
 * 引导选着
 * 
 * @author wpt
 *
 */
@SuppressLint({ "InflateParams", "NewApi" })
public class GuidanceOptions extends ActivitySupport implements
		PullScrollView.OnPullListener {
	private PullScrollView guidanceoptions_pullsv;
	private ListView guidanceoptions_listview;
	private GuidanceOptionsAdapter guidanceOptionsAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_glidanceoptions);
		setCtenterTitle("引导页列表");
		setRightTitle("跳过");
		setRightTitleListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mIntent(context, MainTab.class);
				finish();
			}
		});
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		guidanceoptions_pullsv = (PullScrollView) findViewById(R.id.guidanceoptions_pullsv);
		View inflate = LayoutInflater.from(context).inflate(
				R.layout.layout_listview, null);
		guidanceoptions_listview = (ListView) inflate
				.findViewById(R.id.guidanceoptions_listview);
		guidanceoptions_pullsv.addBodyView(inflate);
		guidanceoptions_pullsv.setOnPullListener(this);
		guidanceoptions_pullsv.setfooterViewReset();
		guidanceoptions_pullsv
				.setOverScrollMode(guidanceoptions_pullsv.OVER_SCROLL_NEVER);
		List<String> list = new ArrayList<String>();
		list.add("ViewFlipper侧滑引导页");
		list.add("viewpage侧滑引导页");
		list.add("仿人人引导页");
		list.add("仿赶集引导页");
		list.add("仿墨迹天气引导页");
		list.add("Uber的欢迎界面");
		list.add("SCViewPager欢迎页面");
		guidanceOptionsAdapter = new GuidanceOptionsAdapter(list, context);
		guidanceoptions_listview.setAdapter(guidanceOptionsAdapter);
		guidanceoptions_listview
				.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						// TODO Auto-generated method stub
						onClickIntent(position);
					}
				});
	}

	protected void onClickIntent(int position) {
		// TODO Auto-generated method stub
		switch (position) {
		case 0:
			mIntent(context, MyViewFlipperDemo.class);
			break;
		case 1:
			mIntent(context, GuidancePage.class);
			break;
		case 2:
			mIntent(context, GuideActivity.class);
			break;
		case 3:
			mIntent(context, ObservableScrollViewDemo.class);
			break;
		case 4:
			mIntent(context, GuideMoJi.class);
			break;
		case 5:
			mIntent(context, GuideVideoView.class);
			break;
		case 6:
			mIntent(context, GulideSCViewpager.class);
			break;
		}
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		guidanceoptions_pullsv.setheaderViewReset();
	}

	@Override
	public void loadMore() {
		// TODO Auto-generated method stub
		guidanceoptions_pullsv.setfooterViewReset();
		guidanceoptions_pullsv.setfooterViewGone();
	}

}
