package com.application.booktravel.activity;

import com.application.booktravel.fragment.ContactsFragment;
import com.application.booktravel.fragment.MessageFragment;
import com.application.booktravel.fragment.NewsFragment;
import com.application.booktravel.fragment.SettingFragment;
import com.example.booktravel.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * ��Ŀ����Activity,���е�Fragment��Ƕ�������
 * 
 * @author zwx123
 *
 */
@SuppressLint("NewApi")
public class FragmentMainActivity extends Activity implements OnClickListener {

	/**
	 * ����չʾ��Ϣ��Fragment
	 */
	private MessageFragment messageFragment;

	/**
	 * ����չʾ��ϵ�˵�Fragment
	 */
	private ContactsFragment contactsFragment;

	/**
	 * ����չʾ��̬��Fragment
	 */
	private NewsFragment newsFragment;

	/**
	 * ����չʾ���õ�Fragment
	 */
	private SettingFragment settingFragment;

	/**
	 * ��Ϣ���沼��
	 */
	private View messageLayout;

	/**
	 * ��ϵ�˽��沼��
	 */
	private View contactsLayout;

	/**
	 * ��̬���沼��
	 */
	private View newsLayout;

	/**
	 * ���ý��沼��
	 */
	private View settingLayout;

	/**
	 * ��Tab��������ʾ��Ϣͼ��Ŀؼ�
	 */
	private ImageView messageImage;

	/**
	 * ��Tab��������ʾ��ϵ��ͼ��Ŀؼ�
	 */
	private ImageView contactsImage;

	/**
	 * ��Tab��������ʾ��̬ͼ��Ŀؼ�
	 */
	private ImageView newsImage;

	/**
	 * ��Tab��������ʾ����ͼ��Ŀؼ�
	 */
	private ImageView settingImage;

	/**
	 * ��Tab��������ʾ��Ϣ����Ŀؼ�
	 */
	private TextView messageText;

	/**
	 * ��Tab��������ʾ��ϵ�˱���Ŀؼ�
	 */
	private TextView contactsText;

	/**
	 * ��Tab��������ʾ��̬����Ŀؼ�
	 */
	private TextView newsText;

	/**
	 * ��Tab��������ʾ���ñ���Ŀؼ�
	 */
	private TextView settingText;

	/**
	 * ���ڶ�Fragment���й���
	 */
	private FragmentManager fragmentManager;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// ���ô�����
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		/**
		 * ��ʼ������Ԫ��
		 */
		initViews();
		fragmentManager = getFragmentManager();
		// ��һ������ʱѡ�е�0��tab
		setTabSelection(0);
	}

	/**
	 * ���ݴ����index����������ѡ�е�tabҳ��
	 * 
	 * @param index
	 *            ÿ��tabҳ��Ӧ���±ꡣ0��ʾ��Ϣ��1��ʾ��ϵ�ˣ�2��ʾ��̬��3��ʾ���á�
	 */
	private void setTabSelection(int index) {
		// ÿ��ѡ��ǰ������ϴ�ѡ�е�״̬
		clearSelection();
		// ����һ��Fragment����
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		// �����ص����е�Fragment���Է�ֹ�ж��Fragment��ʾ�ڽ����ϵ����
		hideFragments(transaction);
		switch (index) {
		case 0:
			// ���������Ϣtabʱ���ı�ؼ���ͼƬ��������ɫ
			messageImage.setImageResource(R.drawable.message_selected);
			messageText.setTextColor(Color.WHITE);
			if (messageFragment == null) {
				// ���MessageFragmentΪ�գ��򴴽�һ�������ӵ�������
				messageFragment = new MessageFragment();
				transaction.add(R.id.content, messageFragment);
			} else {
				// ���MessageFragment��Ϊ�գ���ֱ�ӽ�����ʾ����
				transaction.show(messageFragment);
			}
			break;
		case 1:
			contactsImage.setImageResource(R.drawable.contacts_selected);
			contactsText.setTextColor(Color.WHITE);
			if (contactsFragment == null) {
				contactsFragment = new ContactsFragment();
				transaction.add(R.id.content, contactsFragment);
			} else {
				transaction.show(contactsFragment);
			}
			break;
		case 2:
			newsImage.setImageResource(R.drawable.news_selected);
			newsText.setTextColor(Color.WHITE);
			if (newsFragment == null) {
				newsFragment = new NewsFragment();
				transaction.add(R.id.content, newsFragment);
			} else {
				transaction.show(newsFragment);
			}
			break;
		case 3:
			settingImage.setImageResource(R.drawable.setting_selected);
			settingText.setTextColor(Color.WHITE);
			if (settingFragment == null) {
				settingFragment = new SettingFragment();
				transaction.add(R.id.content, settingFragment);
			} else {
				transaction.show(settingFragment);
			}
			break;
		}
		transaction.commit();
	}

	/**
	 * �����е�Fragment����Ϊ����״̬��
	 * 
	 * @param transaction
	 *            ���ڶ�Fragmentִ�в���������
	 */
	private void hideFragments(FragmentTransaction transaction) {
		if (messageFragment != null) {
			transaction.hide(messageFragment);
		}
		if (contactsFragment != null) {
			transaction.hide(contactsFragment);
		}
		if (newsFragment != null) {
			transaction.hide(newsFragment);
		}
		if (settingFragment != null) {
			transaction.hide(settingFragment);
		}
	}

	/**
	 * ��������е�ѡ��״̬��
	 */
	private void clearSelection() {
		messageImage.setImageResource(R.drawable.message_unselected);
		messageText.setTextColor(Color.parseColor("#82858b"));
		contactsImage.setImageResource(R.drawable.contacts_unselected);
		contactsText.setTextColor(Color.parseColor("#82858b"));
		newsImage.setImageResource(R.drawable.news_unselected);
		newsText.setTextColor(Color.parseColor("#82858b"));
		settingImage.setImageResource(R.drawable.setting_unselected);
		settingText.setTextColor(Color.parseColor("#82858b"));
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.message_layout:
			setTabSelection(0);
			break;
		case R.id.contacts_layout:
			setTabSelection(1);
			break;
		case R.id.news_layout:
			setTabSelection(2);
			break;
		case R.id.setting_layout:
			setTabSelection(3);
			break;
		}
	}

	/**
	 * �������ȡ��ÿ����Ҫ�õ��Ŀؼ���ʵ���������������úñ�Ҫ�ĵ���¼���
	 */
	private void initViews() {
		messageLayout = findViewById(R.id.message_layout);
		contactsLayout = findViewById(R.id.contacts_layout);
		newsLayout = findViewById(R.id.news_layout);
		settingLayout = findViewById(R.id.setting_layout);
		messageImage = (ImageView) findViewById(R.id.message_image);
		contactsImage = (ImageView) findViewById(R.id.contacts_image);
		newsImage = (ImageView) findViewById(R.id.news_image);
		settingImage = (ImageView) findViewById(R.id.setting_image);
		messageText = (TextView) findViewById(R.id.message_text);
		contactsText = (TextView) findViewById(R.id.contacts_text);
		newsText = (TextView) findViewById(R.id.news_text);
		settingText = (TextView) findViewById(R.id.setting_text);
		messageLayout.setOnClickListener(this);
		contactsLayout.setOnClickListener(this);
		newsLayout.setOnClickListener(this);
		settingLayout.setOnClickListener(this);
	}
}