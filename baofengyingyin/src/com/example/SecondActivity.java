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
		  
        // // ��ȡ�Զ��岼���ļ�pop.xml����ͼ  
        View customView = getLayoutInflater().inflate(R.layout.popview_item,  
                null, false);  
        // ����PopupWindowʵ��,322,600�ֱ��ǿ�Ⱥ͸߶�  
        popupwindow = new PopupWindow(customView, 322, 600);  
        // ���ö���Ч�� [R.style.AnimationFade ���Լ����ȶ���õ�]  
        popupwindow.setAnimationStyle(R.style.AnimationFade);  
        // �Զ���view��Ӵ����¼�  
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