package com.prism.newsclient_project_1.SourceProvider;

import java.io.InputStream;

/**
 * Created by Prism-Thinkpad on 2018/4/2.
 */

public interface ISource {
    InputStream getInputStream(String path) throws Exception;
}
