package com.husky.cloud.util.rocket;

import java.io.Serializable;

public class MsgWrap implements Serializable {

    private static final long serialVersionUID = 1L;

    private String group;
    private String topic;
    private String tag;
    private Object content ;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
