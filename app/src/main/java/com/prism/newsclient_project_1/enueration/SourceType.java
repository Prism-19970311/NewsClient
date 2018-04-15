package com.prism.newsclient_project_1.enueration;

/**
 * Created by Prism-Thinkpad on 2018/4/2.
 */
//枚举 枚举中所有元素都是静态的，可以通过 .方法名调用方法
public enum SourceType {
    SOURCE_FROM_SERVER("SOURCE_FROM_SERVER"),
    SOURCE_FROM_ASSETS("SOURCE_FROM_ASSETS"),
    SOURCE_FROM_DB("SOURCE_FROM_DB");

    private String type;
    SourceType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
