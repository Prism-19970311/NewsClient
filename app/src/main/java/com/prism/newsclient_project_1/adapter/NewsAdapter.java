package com.prism.newsclient_project_1.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.prism.newsclient_project_1.R;
import com.prism.newsclient_project_1.bean.NewsInfo;

import java.util.List;

/**
 * Created by 棱镜 on 2018/3/29.
 * HaHaHaHaHaHaHa!
 */

public class NewsAdapter extends BaseAdapter {
    private List<NewsInfo> newsList;
    private Context context;

    public NewsAdapter(Context context,List<NewsInfo> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    @Override
    public int getCount() {
        return newsList.size();
    }

    @Override
    public Object getItem(int position) {
        return newsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item_news, null);
            viewHolder.im_image = convertView.findViewById(R.id.iv_image);
            viewHolder.tv_title = convertView.findViewById(R.id.tv_title);
            viewHolder.tv_desc = convertView.findViewById(R.id.tv_desc);
            viewHolder.tv_type = convertView.findViewById(R.id.tv_type);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tv_title.setText(newsList.get(position).getTitle());
        viewHolder.tv_desc.setText(newsList.get(position).getDescription().substring(0,20)+"...");
        viewHolder.tv_type.setText(newsList.get(position).getType());

        //TODO
        //showImage in imageView
        new Thread() {
            @Override
            public void run() {

            }
        }.start();

        return convertView;
    }

    private static class ViewHolder {
        ImageView im_image;
        TextView tv_title;
        TextView tv_desc;
        TextView tv_type;
    }
}
