package com.prism.newsclient_project_1.activities;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.ListView;

import com.prism.newsclient_project_1.R;
import com.prism.newsclient_project_1.bean.NewsInfo;
import com.prism.newsclient_project_1.enueration.SourceType;
import com.prism.newsclient_project_1.handler.MyHandler;
import com.prism.newsclient_project_1.manager.NewsManager;
import com.prism.newsclient_project_1.properties.AppProperties;
import com.prism.newsclient_project_1.sourceOP.NewsSqlOP;

import java.util.List;

        public class MainActivity extends Activity {
        private ListView lv_news;
        private MyHandler myHandler;
        private NewsManager manager;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            initView();
            initData();  //初始化数据
            showNewsList(SourceType.SOURCE_FROM_SERVER,AppProperties.SERVERPATH);  //显示数据
        }

        private void initView() {
            lv_news = findViewById(R.id.lv_news);
        }

        private void initData() {
            manager = new NewsManager();
            myHandler = new MyHandler(this,lv_news);
        }

        private void showNewsList(final SourceType sourceType, final String path) {
            new Thread() {
                @Override
                public void run() {
                    Message msg = new Message();
                    NewsManager manager = new NewsManager();
                    List<NewsInfo> newsList = manager.getNewsListFromSource
                            (MainActivity.this, sourceType,path);
                    //System.out.println("--------------"+newsList.size());
                    msg.obj = newsList;
                    msg.what = AppProperties.NEWSLISTSUCCESS;
                    myHandler.sendMessage(msg);
                }
            }.start();
        }

        public void buttonOnclick(View view) {
            switch (view.getId()) {
                case R.id.bt_server:
                    serverClick();
                    break;
                case R.id.bt_assets:
                    assetsClick();
                    break;
                case R.id.bt_db:
                    dbClick();
                    break;
                default:
                    break;
            }
        }

        private void serverClick() {
            showNewsList(SourceType.SOURCE_FROM_SERVER,AppProperties.SERVERPATH);
        }

        private void assetsClick() {
            showNewsList(SourceType.SOURCE_FROM_ASSETS,AppProperties.ASSETESPATH);
        }

    private void dbClick() {
            showNewsList(SourceType.SOURCE_FROM_DB,null);
    }

}
