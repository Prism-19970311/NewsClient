package com.prism.newsclient_project_1.utils;

import android.util.Xml;

import com.prism.newsclient_project_1.bean.NewsInfo;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 棱镜 on 2018/3/26.
 * HaHaHaHaHaHaHa!
 */

public class NewsXmlParser {

    private static NewsInfo newsInfo;

    public static List<NewsInfo> parse (InputStream in) {             // utils工具都是静态的
        List<NewsInfo> newsList = new ArrayList<>();
        XmlPullParser parser = Xml.newPullParser();
        try {
            parser.setInput(in,"utf-8");
            int type = parser.getEventType();
            while (type != parser.END_DOCUMENT) {
                switch (type) {
                    case XmlPullParser.START_TAG:
                        if (parser.getName().equals("item")) {
                            newsInfo = new NewsInfo();
                        }else if (parser.getName().equals("title")) {
                            String title = parser.nextText();
                            newsInfo.setTitle(title);
                        }else if (parser.getName().equals("link")) {
                            String link = parser.nextText();
                            newsInfo.setLink(link);
                        }else if (parser.getName().equals("author")) {
                            String author = parser.nextText();
                            newsInfo.setAuthor(author);
                        }else if (parser.getName().equals("image")) {
                            String image = parser.nextText();
                            newsInfo.setImage(image);
                        }else if (parser.getName().equals("pubDate")) {
                            String pubDate = parser.nextText();
                            newsInfo.setPubDate(pubDate);
                        }else if (parser.getName().equals("type")) {
                            String types = parser.nextText();
                            newsInfo.setType(types);
                        }else if (parser.getName().equals("description")) {
                            String description = parser.nextText();
                            newsInfo.setDescription(description);
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if (parser.getName().equals("item")) {
                            newsList.add(newsInfo);
                        }
                        break;
                }
                type = parser.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newsList;
    }
}
