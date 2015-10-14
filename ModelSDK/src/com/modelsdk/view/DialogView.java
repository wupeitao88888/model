package com.modelsdk.view;

import com.modelsdk.mian.R;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class DialogView extends Dialog {

	private TextView title_tv;
	private TextView content_tv;
	private TextView positive;
	private TextView cancle;

	public DialogView(Context context) {
		super(context);
	}

	public DialogView(Context context, int style,String title,String content) {
		super(context, style);
		View view = LayoutInflater.from(context).inflate(
				R.layout.exit_dialog_view, null);
		title_tv = (TextView) view.findViewById(R.id.title);
		content_tv = (TextView) view.findViewById(R.id.content);
		positive = (TextView) view.findViewById(R.id.positive);
		cancle = (TextView) view.findViewById(R.id.cancle);
		
		title_tv.setText(title);
		content_tv.setText(content);
		this.setContentView(view);
		this.setCanceledOnTouchOutside(false);
	}

	public void setPositiveOnClickListener(
			android.view.View.OnClickListener click) {
		positive.setOnClickListener(click);
	}

	public void setCancleOnClickListener(android.view.View.OnClickListener click) {
		cancle.setOnClickListener(click);
	}

	public void setContentVisibility() {
		content_tv.setVisibility(View.VISIBLE);
	}

	/**
	 * 改变两个按钮上的文字
	 * @param positiveText确定按钮的文字
	 * @param cancleText取消按钮的文字
	 */
	public void setButtonText(String positiveText,String cancleText){
		positive.setText(positiveText);
		cancle.setText(cancleText);
	}
}
