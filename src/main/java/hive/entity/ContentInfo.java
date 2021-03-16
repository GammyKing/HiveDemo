package hive.entity;

import hive.utils.StringUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContentInfo {
    private long uid;
    private String content;
    private String time;
    private int repostsCount;
    private int commentsCount;

    public ContentInfo() {
    }

    public ContentInfo(long uid, String content, String time, int repostsCount, int commentsCount) {
        this.uid = uid;
        this.content = content;
        this.time = time;
        this.repostsCount = repostsCount;
        this.commentsCount = commentsCount;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getRepostsCount() {
        return repostsCount;
    }

    public void setRepostsCount(int repostsCount) {
        this.repostsCount = repostsCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    @Override
    public String toString() {
        return "ContentInfo{" +
                "uid=" + uid +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", repostsCount=" + repostsCount +
                ", commentsCount=" + commentsCount +
                '}';
    }
    public String toString4FileOutput(String seq){
        List<Object> fieldList = new ArrayList<>();
//        fieldList.add(uid);
        fieldList.add(content);
        fieldList.add(time);
        fieldList.add(repostsCount);
        fieldList.add(commentsCount);
        // 注意三目运算符的优先级，三目优先级最低。
//        System.out.println("screenName="+(screenName == null?"null":"null字符串"));
        return StringUtil.join(fieldList,seq);
    }
}
