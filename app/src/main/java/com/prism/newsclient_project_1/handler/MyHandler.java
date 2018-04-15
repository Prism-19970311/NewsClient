package com.prism.newsclient_project_1.handler;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ListView;

import com.prism.newsclient_project_1.adapter.NewsAdapter;
import com.prism.newsclient_project_1.bean.NewsInfo;
import com.prism.newsclient_project_1.properties.AppProperties;

import java.util.List;

/**
 * Created by 棱镜 on 2018/3/26.
 * HaHaHaHaHaHaHa!
 */

public class MyHandler extends Handler {
    View view;
    Context context;
    NewsAdapter adapter;
    public MyHandler(Context context,View view) {
        this.context = context;
        this.view = view;
    }
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case AppProperties.NEWSLISTSUCCESS:
                    List<NewsInfo> newsInfoList = (List<NewsInfo>) msg.obj;
                    adapter = new NewsAdapter(context, newsInfoList);

                    ((ListView)view).setAdapter(this.adapter);
                    break;
                case 2:

                    break;
            }
        }
}
