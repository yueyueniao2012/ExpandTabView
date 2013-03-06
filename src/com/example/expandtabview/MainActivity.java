package com.example.expandtabview;


import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.view.ExpandTabView;
import com.example.view.ViewLeft;
import com.example.view.ViewMiddle;
import com.example.view.ViewRight;

public class MainActivity extends Activity {

	private ExpandTabView expandTabView;
	private ArrayList<View> mViewArray = new ArrayList<View>();
	private ViewLeft viewLeft;
	private ViewMiddle viewMiddle;
	private ViewRight viewRight;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initVaule();
		initListener();
		
	}

	private void initView() {
		
		expandTabView = (ExpandTabView) findViewById(R.id.expandtab_view);
		viewLeft = new ViewLeft(this);
		viewMiddle = new ViewMiddle(this);
		viewRight = new ViewRight(this);
		
	}

	private void initVaule() {
		
		mViewArray.add(viewLeft);
		mViewArray.add(viewMiddle);
		mViewArray.add(viewRight);
		ArrayList<String> mTextArray = new ArrayList<String>();
		mTextArray.add("距离");
		mTextArray.add("区域");
		mTextArray.add("距离");
		expandTabView.setValue(mTextArray, mViewArray);
		expandTabView.setTitle(viewLeft.getShowText(), 0);
		expandTabView.setTitle(viewMiddle.getShowText(), 1);
		expandTabView.setTitle(viewRight.getShowText(), 2);
		
	}

	private void initListener() {
		
		viewLeft.setOnSelectListener(new ViewLeft.OnSelectListener() {

			@Override
			public void getValue(String distance, String showText) {
				onRefresh(viewLeft, showText);
			}
		});
		
		viewMiddle.setOnSelectListener(new ViewMiddle.OnSelectListener() {
			
			@Override
			public void getValue(String showText) {
				
				onRefresh(viewMiddle,showText);
				
			}
		});
		
		viewRight.setOnSelectListener(new ViewRight.OnSelectListener() {

			@Override
			public void getValue(String distance, String showText) {
				onRefresh(viewRight, showText);
			}
		});
		
	}
	
	private void onRefresh(View view, String showText) {
		
		expandTabView.onPressBack();
		int position = getPositon(view);
		if (position >= 0 && !expandTabView.getTitle(position).equals(showText)) {
			expandTabView.setTitle(showText, position);
		}
		Toast.makeText(MainActivity.this, showText, Toast.LENGTH_SHORT).show();

	}
	
	private int getPositon(View tView) {
		for (int i = 0; i < mViewArray.size(); i++) {
			if (mViewArray.get(i) == tView) {
				return i;
			}
		}
		return -1;
	}
	
	@Override
	public void onBackPressed() {
		
		if (!expandTabView.onPressBack()) {
			finish();
		}
		
	}

}
