package com.prism.newsclient_project_1.SourceProvider;

import android.content.Context;

import com.prism.newsclient_project_1.enueration.SourceType;
import com.prism.newsclient_project_1.sourceOP.AssetsStreamOP;
import com.prism.newsclient_project_1.sourceOP.HttpStreamOP;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Prism-Thinkpad on 2018/4/2.
 */

public class SourceMap {
    public static Map<SourceType,ISource> generateSource(Context context) {
        Map<SourceType,ISource> sourceMap = new HashMap<>();
        sourceMap.put(SourceType.SOURCE_FROM_SERVER,new HttpStreamOP());
        sourceMap.put(SourceType.SOURCE_FROM_ASSETS,new AssetsStreamOP(context));

        return sourceMap;
    }
}
