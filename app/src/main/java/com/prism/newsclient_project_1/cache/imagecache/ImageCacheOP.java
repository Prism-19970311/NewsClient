package com.prism.newsclient_project_1.cache.imagecache;
/*Create by 棱镜
*/

import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import com.prism.newsclient_project_1.sourceOP.HttpStreamOP;

import java.io.File;
import java.io.InputStream;

public class ImageCacheOP {
    private Context context;

    public ImageCacheOP(Context context) {
        this.context = context;
    }

    public Bitmap getBitMapFromURL(String path) {
        File file = new File(context.getCacheDir(), Base64.encodeToString(path.getBytes(),Base64.DEFAULT));
        if (file.exists() && file.length()>0) {

            System.out.println("------------------------------------cache");
        }else {
            try {
                InputStream in = new HttpStreamOP().getInputStream(path);   

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return BitmapFactory.decodeFile(file.getAbsolutePath());
    }
}
