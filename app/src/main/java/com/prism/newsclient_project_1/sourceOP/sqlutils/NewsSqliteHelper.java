package com.prism.newsclient_project_1.sourceOP.sqlutils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.prism.newsclient_project_1.properties.AppProperties;

/**
 * Created by root on 18-4-9.
 */

public class NewsSqliteHelper extends SQLiteOpenHelper {
    public NewsSqliteHelper(Context context) {
        super(context, "class3", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ AppProperties.NEWSTABLE+
                "(_id integer primary key autoincrement,title varchar(100)," +
                "link varchar(200),author varchar(200),image varchar(300)," +
                "pubDate varchar(100),type varchar(100),description text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
