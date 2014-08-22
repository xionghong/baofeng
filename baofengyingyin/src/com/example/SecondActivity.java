package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.PopupWindow;

public class SecondActivity extends Activity {

	private PopupWindow popupwindow;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.secondlayout);
		
		ImageView fenlei = (ImageView) findViewById(R.id.fenlei);
		fenlei.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (popupwindow != null&&popupwindow.isShowing()) {  
	                popupwindow.dismiss();  
	                return;  
	            } else {  
	                initmPopupWindowView();  
	                popupwindow.showAsDropDown(v, 0, 5);  
	            }  
			}
		});
	}
	
	public void initmPopupWindowView() {  
		  
        // // 获取自定义布局文件pop.xml的视图  
        View customView = getLayoutInflater().inflate(R.layout.popview_item,  
                null, false);  
        // 创建PopupWindow实例,322,600分别是宽度和高度  
        popupwindow = new PopupWindow(customView, 322, 600);  
        // 设置动画效果 [R.style.AnimationFade 是自己事先定义好的]  
        popupwindow.setAnimationStyle(R.style.AnimationFade);  
        // 自定义view添加触摸事件  
        customView.setOnTouchListener(new OnTouchListener() {  
  
            @Override  
            public boolean onTouch(View v, MotionEvent event) {  
                if (popupwindow != null && popupwindow.isShowing()) {  
                    popupwindow.dismiss();  
                    popupwindow = null;  
                }  
  
                return false;  
            }  
        });  
}
}