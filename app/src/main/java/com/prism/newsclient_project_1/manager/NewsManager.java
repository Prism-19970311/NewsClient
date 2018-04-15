package com.prism.newsclient_project_1.manager;

import android.content.Context;
import android.widget.Toast;

import com.prism.newsclient_project_1.SourceProvider.ISource;
import com.prism.newsclient_project_1.SourceProvider.SourceFactory;
import com.prism.newsclient_project_1.bean.NewsInfo;
import com.prism.newsclient_project_1.enueration.SourceType;
import com.prism.newsclient_project_1.sourceOP.NewsSqlOP;
import com.prism.newsclient_project_1.utils.NewsXmlParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prism on 2018/3/22.
 */

public class NewsManager {

    public List<NewsInfo> getNewsListFromSource(final Context context, SourceType type, String path) {
        List<NewsInfo> newsList = new ArrayList<>();
        switch (type) {
            case SOURCE_FROM_DB:
                newsList = new NewsSqlOP(context).queryNews();
                break;
            case SOURCE_FROM_ASSETS:
            case SOURCE_FROM_SERVER:
                newsList = getNewsListFromInPutStream(context, type, path);
                break;
        }
        return newsList;
    }

    public List<NewsInfo> getNewsListFromInPutStream(final Context context, SourceType type, String path) {

        InputStream in = null;

        List<NewsInfo> newsList = new ArrayList<>();

        ISource iSource = SourceFactory.sourceCreate(context, type);
        try {
            in = iSource.getInputStream(path);

            if (in != null) {
                newsList = NewsXmlParser.parse(in);

                final List<NewsInfo> finalNewsList = newsList;

                new Thread() {
                    @Override
                    public void run() {
                        NewsSqlOP sqlOP = new NewsSqlOP(context);
                        while (!sqlOP.insert(finalNewsList)) {
                            System.out.println("----------------------failed");
                        }
                        System.out.println("-----------------------success");
                    }
                }.start();

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return newsList;
    }
}
