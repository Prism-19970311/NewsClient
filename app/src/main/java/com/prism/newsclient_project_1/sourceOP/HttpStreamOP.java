package com.prism.newsclient_project_1.sourceOP;

import com.prism.newsclient_project_1.SourceProvider.ISource;
import com.prism.newsclient_project_1.exception.ErrorResponseCodeException;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Prism on 2018/3/22.
 */

public class HttpStreamOP implements ISource{

    @Override
    public InputStream getInputStream(String path) throws Exception {
        InputStream in = null;


        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5000);
        int code = conn.getResponseCode();
        if (code == 200) {
            in = conn.getInputStream();
        }else {
            throw new ErrorResponseCodeException("error is response code is" + code);
        }
        return in;
    }
}
