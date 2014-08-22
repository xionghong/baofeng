package com.example;


import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class LocalActivity extends TabActivity {

	private TabHost tabHost;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.locallayout);
		
		Intent intent1 = new Intent(LocalActivity.this, LocalVideoActivity.class);
		Intent intent2 = new Intent(LocalActivity.this, LocalMusicActivity.class);
		LayoutInflater inflater = LayoutInflater.from(LocalActivity.this);
		View view1 = inflater.inflate(R.layout.localtabitem1, null);
		View view2 = inflater.inflate(R.layout.localtabitem2, null);
		
		tabHost = getTabHost();
		TabSpec tabSpec1 = tabHost.newTabSpec("tab1").setIndicator(view1)
				.setContent(intent1);
		tabHost.addTab(tabSpec1);
		TabSpec tabSpec2 = tabHost.newTabSpec("tab2").setIndicator(view2)
				.setContent(intent2);
		tabHost.addTab(tabSpec2);
		
		Button onlineButton = (Button) findViewById(R.id.onlineButton);
		onlineButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		final ImageView refresh = (ImageView) findViewById(R.id.refresh);
		refresh.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Animation anim = AnimationUtils.loadAnimation(
						LocalActivity.this, R.anim.rotate1);
				refresh.setAnimation(anim);
			}
		});
		
	}
}
