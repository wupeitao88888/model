package com.model.adapter;

import java.util.List;

import com.model.main.R;
import com.modelsdk.utils.L;
import com.modelsdk.utils.ViewHolder;
import com.modelsdk.utils.ViewUtil;
import com.nineoldandroids.view.ViewHelper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class GuidanceOptionsAdapter extends BaseAdapter {

	private List<String> list;
	private Context context;
	
	
	public GuidanceOptionsAdapter(List<String> list, Context context) {
		super();
		this.list = list;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list == null ? 0 : list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		String string = list.get(position);
		if(convertView==null){
			convertView=LayoutInflater.from(context).inflate(R.layout.layout_guidanceoptions_item, null);
		}
		TextView view = (TextView)ViewHolder.get(convertView, R.id.go_item_text);
		ViewUtil.setText(context, view, string);
		return convertView;
	}

}
