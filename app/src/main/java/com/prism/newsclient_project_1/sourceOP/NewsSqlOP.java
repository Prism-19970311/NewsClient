package com.prism.newsclient_project_1.sourceOP;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.prism.newsclient_project_1.activities.MainActivity;
import com.prism.newsclient_project_1.bean.NewsInfo;
import com.prism.newsclient_project_1.properties.AppProperties;
import com.prism.newsclient_project_1.sourceOP.sqlutils.NewsSqliteHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 18-4-9.
 */

public class NewsSqlOP {
    private NewsSqliteHelper helper;

    public NewsSqlOP(Context context) {
        helper = new NewsSqliteHelper(context);
    }

    public boolean insert(List<NewsInfo> newsList) {
        SQLiteDatabase db = helper.getReadableDatabase();
        long start = -1;
        long end = -1;
        db.beginTransaction();   //事务
        try {
            for (NewsInfo news:newsList) {
                ContentValues values = new ContentValues();
                values.put("title",news.getTitle());
                values.put("link",news.getLink());
                values.put("author",news.getAuthor());
                values.put("image",news.getImage());
                values.put("pubDate",news.getPubDate());
                values.put("type",news.getType());
                values.put("description",news.getDescription());

//                if (start == -1) {
//                    start = db.insert(AppProperties.NEWSTABLE,null,values);
//                    end = start+1;
//                }else {
//                    end = db.insert(AppProperties.NEWSTABLE,null,values);
//                }

                long insert = db.insert(AppProperties.NEWSTABLE,null,values) + 1;
                if (start == -1) {
                    start = insert;
                }
                end = insert+1;

            }
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
            db.close();

            if (newsList.size() == end-start)
                return true;
            else
                return false;
        }
    }

    public List<NewsInfo> queryNews() {
        ArrayList<NewsInfo> newsList = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(AppProperties.NEWSTABLE, null, null, null,
                null, null, null);
        if (cursor != null && cursor.getCount() > 0) {
            while(cursor.moveToNext()) {
                NewsInfo newsInfo = new NewsInfo();
                newsInfo.setTitle(cursor.getString(1));
                newsInfo.setLink(cursor.getString(2));
                newsInfo.setAuthor(cursor.getString(3));
                newsInfo.setImage(cursor.getString(4));
                newsInfo.setPubDate(cursor.getString(5));
                newsInfo.setType(cursor.getString(6));
                newsInfo.setDescription(cursor.getString(7));
                newsList.add(newsInfo);
            }

        }
        cursor.close();
        db.close();

        return newsList;
    }
}
