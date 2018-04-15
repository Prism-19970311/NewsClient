package com.prism.newsclient_project_1.SourceProvider;

import android.content.Context;

import com.prism.newsclient_project_1.enueration.SourceType;

/**
 * Created by Prism-Thinkpad on 2018/4/2.
 */

public class SourceFactory {
    public static ISource sourceCreate(Context context,SourceType type) {
        return SourceMap.generateSource(context).get(type);
    }
}
