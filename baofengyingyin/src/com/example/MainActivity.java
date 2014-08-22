package com.example;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends TabActivity {
	private SlideMenu slideMenu;
	private TabHost tabHost;
	private LayoutInflater inflater;
	private Intent intent1, intent2, intent3, intent4, intent5, intent6;

	private long exitTime = 0;
	
	private static final int SWIPE_MIN_DISTANCE = 120;  
    private static final int SWIPE_MAX_OFF_PATH = 250;  
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;  
    private GestureDetector gestureDetector;  
    View.OnTouchListener gestureListener;  
  
    int currentView = 0;  
    private static int maxTabIndex = 5;  

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK
				&& event.getAction() == KeyEvent.ACTION_DOWN) {
			if ((System.currentTimeMillis() - exitTime) > 2000) {
				Toast.makeText(MainActivity.this, "再按一次退出程序",
						Toast.LENGTH_SHORT).show();
				exitTime = System.currentTimeMillis();
			} else {
				finish();
				System.exit(0);
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		
		gestureDetector = new GestureDetector(new MyGestureDetector());  
        gestureListener = new View.OnTouchListener() {  
            public boolean onTouch(View v, MotionEvent event) {  
                if (gestureDetector.onTouchEvent(event)) {  
                    return true;  
                }  
                return false;  
            }  
        };  
		
		// 抽屉效果
		slideMenu = (SlideMenu) findViewById(R.id.slide_menu);
		ImageView menuImg = (ImageView) findViewById(R.id.slide_firstmenu);
		menuImg.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (slideMenu.isMainScreenShowing()) {
					slideMenu.openMenu();
				} else {
					slideMenu.closeMenu();
				}
			}
		});

		intent1 = new Intent(MainActivity.this, FirstActivity.class);
		intent2 = new Intent(MainActivity.this, SecondActivity.class);
		intent3 = new Intent(MainActivity.this, SecondActivity.class);
		intent4 = new Intent(MainActivity.this, SecondActivity.class);
		intent5 = new Intent(MainActivity.this, SecondActivity.class);
		intent6 = new Intent(MainActivity.this, MoreInformationActivity.class);

		LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
		View view1 = inflater.inflate(R.layout.tabitem_1, null);
		View view2 = inflater.inflate(R.layout.tabitem_2, null);
		View view3 = inflater.inflate(R.layout.tabitem_3, null);
		View view4 = inflater.inflate(R.layout.tabitem_4, null);
		View view5 = inflater.inflate(R.layout.tabitem_5, null);
		View view6 = inflater.inflate(R.layout.tabitem_6, null);

		// 创建TabHost
		// tabHost = (TabHost) findViewById(R.id.tabHost);
		// tabHost.setup();
		tabHost = getTabHost();
		TabSpec tabSpec1 = tabHost.newTabSpec("tab1").setIndicator(view1)
				.setContent(intent1);
		tabHost.addTab(tabSpec1);
		TabSpec tabSpec2 = tabHost.newTabSpec("tab2").setIndicator(view2)
				.setContent(intent2);
		tabHost.addTab(tabSpec2);
		TabSpec tabSpec3 = tabHost.newTabSpec("tab3").setIndicator(view3)
				.setContent(intent3);
		tabHost.addTab(tabSpec3);
		TabSpec tabSpec4 = tabHost.newTabSpec("tab4").setIndicator(view4)
				.setContent(intent4);
		tabHost.addTab(tabSpec4);
		TabSpec tabSpec5 = tabHost.newTabSpec("tab5").setIndicator(view5)
				.setContent(intent5);
		tabHost.addTab(tabSpec5);
		TabSpec tabSpec6 = tabHost.newTabSpec("tab6").setIndicator(view6)
				.setContent(intent6);
		tabHost.addTab(tabSpec6);

		Button imageButton1 = (Button) findViewById(R.id.imageButton1);
		imageButton1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// Toast.makeText(MainActivity.this, "123", Toast.LENGTH_SHORT)
				// .show();
				Intent newIntent = new Intent(MainActivity.this,
						LocalActivity.class);
				startActivity(newIntent);
			}
		});

		ImageView slide_menu_history = (ImageView) findViewById(R.id.slide_menu_history);
		slide_menu_history.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent newIntent = new Intent(MainActivity.this,
						HistoryActivity.class);
				startActivity(newIntent);
			}
		});

		ImageView slide_menu_search = (ImageView) findViewById(R.id.slide_menu_search);
		slide_menu_search.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent newIntent = new Intent(MainActivity.this,
						SearchActivity.class);
				startActivity(newIntent);
			}
		});

	}
	
	
	// 左右滑动刚好页面也有滑动效果  
    class MyGestureDetector extends SimpleOnGestureListener {  
        @Override  
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,  
                float velocityY) {  
            TabHost tabHost = getTabHost();  
            System.out.println("************");  
            try {  
                if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)  
                    return false;  
                // right to left swipe  
                if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE  
                        && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {  
                    Log.i("test", "right");  
                    if (currentView == maxTabIndex) {  
                        currentView = 0;  
                    } else {  
                        currentView++;  
                    }  
                    tabHost.setCurrentTab(currentView);  
                } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE  
                        && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {  
                    Log.i("test", "left");  
                    if (currentView == 0) {  
                        currentView = maxTabIndex;  
                    } else {  
                        currentView--;  
                    }  
                    tabHost.setCurrentTab(currentView);  
                }  
            } catch (Exception e) {  
            }  
            return false;  
        }  
    }  
  
    @Override  
    public boolean dispatchTouchEvent(MotionEvent event) {  
        if (gestureDetector.onTouchEvent(event)) {  
            event.setAction(MotionEvent.ACTION_CANCEL);  
        }  
        return super.dispatchTouchEvent(event);  
    }  
  
    @Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return gestureDetector.onTouchEvent(event);
	}
//    @Override  
//    public boolean onCreateOptionsMenu(Menu menu) {  
//        getMenuInflater().inflate(R.menu.activity_main, menu);  
//        return true;  
//    }  

}
