package com.modelsdk.base;

import android.app.ProgressDialog;
import android.content.Context;

import com.modelsdk.global.LCApplication;


/**
 * Activity����֧����ӿ�.
 * 
 * @author wpt
 */
public interface LCIActivitySupport {
	/**
	 * 
	 * ��ȡEimApplication.
	 * 
	 * @author wupeitao
	 * @update 2012-7-6 ����9:05:51
	 */
	public abstract LCApplication getJXBApplication();

	/**
	 * 
	 * У������-���û������͵�������,������true.
	 * 
	 * @return
	 * @author wupeitao
	 * @update 2012-7-6 ����9:03:56
	 */
	public abstract boolean validateInternet();

	/**
	 * 
	 * У������-���û������ͷ���true.
	 * 
	 * @return
	 * @author wupeitao
	 * @update 2012-7-6 ����9:05:15
	 */
	public abstract boolean hasInternetConnected();

	/**
	 * 
	 * �˳�Ӧ��.
	 * 
	 * @author wupeitao
	 * @update 2012-7-6 ����9:06:42
	 */
	public abstract void isExit();

	/**
	 * 
	 * �жϻ�վ�Ƿ��Ѿ�����.
	 * 
	 * @return
	 * @author wupeitao
	 * @update 2012-7-6 ����9:07:34
	 */
	public abstract boolean hasLocationNetWork();

	/**
	 * 
	 * ����ڴ濨.
	 * 
	 * @author wupeitao
	 * @update 2012-7-6 ����9:07:51
	 */
	public abstract void checkMemoryCard();

	/**
	 * 
	 * ��ʾtoast.
	 * 
	 * @param text
	 *            ����
	 * @param longint
	 *            ������ʾ�೤ʱ��
	 * @author wupeitao
	 * @update 2012-7-6 ����9:12:02
	 */
	public abstract void showToast(String text, int longint);

	/**
	 * 
	 * ��ʱ����ʾtoast.
	 * 
	 * @param text
	 * @author wupeitao
	 * @update 2012-7-6 ����9:12:46
	 */
	public abstract void showToast(String text);

	/**
	 * 
	 * ��ȡ������.
	 * 
	 * @return
	 * @author wupeitao
	 * @update 2012-7-6 ����9:14:38
	 */
	public abstract ProgressDialog getProgressDialog();

	/**
	 * 
	 * ���ص�ǰActivity������.
	 * 
	 * @return
	 * @author wupeitao
	 * @update 2012-7-6 ����9:19:54
	 */
	public abstract Context getContext();

	/** ת��string����>String */
	public String mString(int string);

}
