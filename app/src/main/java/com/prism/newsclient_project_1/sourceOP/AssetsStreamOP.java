package com.prism.newsclient_project_1.sourceOP;

import android.content.Context;

import com.prism.newsclient_project_1.SourceProvider.ISource;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 棱镜 on 2018/3/29.
 * HaHaHaHaHaHaHa!
 */

public class AssetsStreamOP implements ISource{

    private Context context;

    public AssetsStreamOP(Context context) {
        this.context = context;
    }

    public InputStream getInputStream(String path) throws Exception {
        return context.getAssets().open(path);
    }
}
