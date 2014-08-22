package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.Toast;

public class FirstActivity extends Activity implements Callback {

	private int[] imageids = { R.drawable.image1, R.drawable.image2,
			R.drawable.image3 };
	private LayoutInflater inflater;

	// 代表gallery的当前索引
	private int currentIndex = 0;
	private Gallery gallery;
	private Handler handler;
	private GridView gridView;
	private int[] gridImageids = { R.drawable.wangbuer, R.drawable.wangbuer,
			R.drawable.wangbuer, R.drawable.wangbuer, R.drawable.wangbuer,
			R.drawable.wangbuer, R.drawable.wangbuer, R.drawable.wangbuer,
			R.drawable.wangbuer, R.drawable.wangbuer };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.firstlayout);

		inflater = LayoutInflater.from(FirstActivity.this);
		// gridView = (GridView) findViewById(R.id.gridviewTest);
		// gridView.setAdapter(gridAdapter);

		gallery = (Gallery) findViewById(R.id.gallaryTest);
		gallery.setAdapter(gallayAdapter);
		handler = new Handler(FirstActivity.this);
		handler.sendEmptyMessage(1);

		ImageView jingxuanjuchang = (ImageView) findViewById(R.id.jingxuanzhuanti);
		jingxuanjuchang.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 Intent intent = new Intent(FirstActivity.this,
				 JingXuanZhuanTiActivity.class);
				 startActivity(intent);
//				Toast.makeText(FirstActivity.this, "123",
//						Toast.LENGTH_SHORT).show();
			}
		});

	}

	/*
	 * private BaseAdapter gridAdapter = new BaseAdapter() {
	 * 
	 * @Override public View getView(int arg0, View arg1, ViewGroup arg2) { //
	 * TODO Auto-generated method stub View view =
	 * inflater.inflate(R.layout.gridimagelayout, null); ImageView imageView =
	 * (ImageView) view.findViewById(R.id.imageId);
	 * imageView.setImageResource(gridImageids[arg0]); return view; }
	 * 
	 * @Override public long getItemId(int arg0) { // TODO Auto-generated method
	 * stub return gridImageids[arg0]; }
	 * 
	 * @Override public Object getItem(int arg0) { // TODO Auto-generated method
	 * stub return null; }
	 * 
	 * @Override public int getCount() { // TODO Auto-generated method stub
	 * return gridImageids.length; } };
	 */
	private BaseAdapter gallayAdapter = new BaseAdapter() {

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			// TODO Auto-generated method stub
			ImageView imageView = new ImageView(FirstActivity.this);
			imageView.setImageResource(imageids[arg0]);

			imageView.setScaleType(ScaleType.FIT_XY);

			// 取决于父亲
			imageView.setLayoutParams(new Gallery.LayoutParams(480, 200));
			return imageView;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return imageids[arg0];
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return imageids.length;
		}
	};

	@Override
	public boolean handleMessage(Message msg) {
		// TODO Auto-generated method stub
		if (currentIndex >= imageids.length) {
			currentIndex = 0;
		}
		gallery.setSelection(currentIndex);
		++currentIndex;
		handler.sendEmptyMessageDelayed(1, 2000);
		return false;
	}

}
