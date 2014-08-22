package com.example;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MoreInformationActivity extends Activity {

	private int imageIds[] = { R.drawable.channel_sport,
			R.drawable.channel_class, R.drawable.channel_music,
			R.drawable.channel_ent, R.drawable.channel_news,
			R.drawable.channel_default, R.drawable.channel_default,
			R.drawable.channel_default, R.drawable.channel_default };
	private String txts[] = { "体育", "公开课", "音乐", "娱乐", "资讯", "美剧", "经典", "V榜",
			"最八卦" };

	private List<MoreListItem> moreListItems;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.moreinformationlayout);

		ListView listView = (ListView) findViewById(R.id.listviewTest);

		moreListItems = new ArrayList<MoreListItem>();
		moreListItems.add(new MoreListItem(imageIds[0], txts[0]));
		moreListItems.add(new MoreListItem(imageIds[1], txts[1]));
		moreListItems.add(new MoreListItem(imageIds[2], txts[2]));
		moreListItems.add(new MoreListItem(imageIds[3], txts[3]));
		moreListItems.add(new MoreListItem(imageIds[4], txts[4]));
		moreListItems.add(new MoreListItem(imageIds[5], txts[5]));
		moreListItems.add(new MoreListItem(imageIds[6], txts[6]));
		moreListItems.add(new MoreListItem(imageIds[7], txts[7]));
		moreListItems.add(new MoreListItem(imageIds[8], txts[8]));

		listView.setAdapter(adapter);

	}

	BaseAdapter adapter = new BaseAdapter() {

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			// TODO Auto-generated method stub
			View view = LayoutInflater.from(MoreInformationActivity.this)
					.inflate(R.layout.morelistitem, null);

			ImageView imageView = (ImageView) view.findViewById(R.id.more_inf_imageid);
			TextView textView = (TextView) view.findViewById(R.id.more_inf_txt);
			MoreListItem moreListItem = moreListItems.get(arg0);
			imageView.setImageResource(moreListItem.getImageId());
			textView.setText(moreListItem.getTxt());

			return view;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return moreListItems.get(arg0);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return moreListItems.size();
		}
	};
}
