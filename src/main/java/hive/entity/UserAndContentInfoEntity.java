package hive.entity;

import java.util.List;

public class UserAndContentInfoEntity {
    private List<UserInfo> userInfoList;
    private List<ContentInfo> contentInfoList;

    public UserAndContentInfoEntity() {
    }

    public UserAndContentInfoEntity(List<UserInfo> userInfoList, List<ContentInfo> contentInfoList) {
        this.userInfoList = userInfoList;
        this.contentInfoList = contentInfoList;
    }

    public List<UserInfo> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<UserInfo> userInfoList) {
        this.userInfoList = userInfoList;
    }

    public List<ContentInfo> getContentInfoList() {
        return contentInfoList;
    }

    public void setContentInfoList(List<ContentInfo> contentInfoList) {
        this.contentInfoList = contentInfoList;
    }

    @Override
    public String toString() {
        return "UserAndContentInfoEntity{" +
                "userInfoList=" + userInfoList +
                ", contentInfoList=" + contentInfoList +
                '}';
    }
}
