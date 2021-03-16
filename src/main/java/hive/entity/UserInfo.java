package hive.entity;

import hive.utils.StringUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserInfo {
   private long id;
   private String screenName;
   private String name;
   private int province;
   private int city;
   private String location;
   private String description;
   private String url;
   private String profileImageUrl;
   private String userDomain;
   private String gender;
   private int followersCount;
   private int friendsCount;
   private int statusesCount;
   private int favouritesCount;
   private String createdAt;
   private boolean following;
   private boolean verified;
   private int verifiedType;
   private boolean allowAllActMsg;
   private boolean allowAllComment;
   private boolean followMe;
   private String avatarLarge;
   private int onlineStatus;
   private String status;
   private int biFollowersCount;
   private String remark;
   private String lang;
   private String verifiedReason;

    public UserInfo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProvince() {
        return province;
    }

    public void setProvince(int province) {
        this.province = province;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getUserDomain() {
        return userDomain;
    }

    public void setUserDomain(String userDomain) {
        this.userDomain = userDomain;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public int getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount(int friendsCount) {
        this.friendsCount = friendsCount;
    }

    public int getStatusesCount() {
        return statusesCount;
    }

    public void setStatusesCount(int statusesCount) {
        this.statusesCount = statusesCount;
    }

    public int getFavouritesCount() {
        return favouritesCount;
    }

    public void setFavouritesCount(int favouritesCount) {
        this.favouritesCount = favouritesCount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isFollowing() {
        return following;
    }

    public void setFollowing(boolean following) {
        this.following = following;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public int getVerifiedType() {
        return verifiedType;
    }

    public void setVerifiedType(int verifiedType) {
        this.verifiedType = verifiedType;
    }

    public boolean isAllowAllActMsg() {
        return allowAllActMsg;
    }

    public void setAllowAllActMsg(boolean allowAllActMsg) {
        this.allowAllActMsg = allowAllActMsg;
    }

    public boolean isAllowAllComment() {
        return allowAllComment;
    }

    public void setAllowAllComment(boolean allowAllComment) {
        this.allowAllComment = allowAllComment;
    }

    public boolean isFollowMe() {
        return followMe;
    }

    public void setFollowMe(boolean followMe) {
        this.followMe = followMe;
    }

    public String getAvatarLarge() {
        return avatarLarge;
    }

    public void setAvatarLarge(String avatarLarge) {
        this.avatarLarge = avatarLarge;
    }

    public int getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(int onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getBiFollowersCount() {
        return biFollowersCount;
    }

    public void setBiFollowersCount(int biFollowersCount) {
        this.biFollowersCount = biFollowersCount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getVerifiedReason() {
        return verifiedReason;
    }

    public void setVerifiedReason(String verifiedReason) {
        this.verifiedReason = verifiedReason;
    }

    public String toString4FileOutput(){
        List<Object> fieldList = new ArrayList<>();
        fieldList.add(id);
        fieldList.add(screenName);
        fieldList.add(name);
        fieldList.add(province);
        fieldList.add(city);
        fieldList.add(location);
        fieldList.add(description);
        fieldList.add(url);
        fieldList.add(profileImageUrl);
        fieldList.add(userDomain);
        fieldList.add(gender);
        fieldList.add(followersCount);
        fieldList.add(friendsCount);
        fieldList.add(statusesCount);
        fieldList.add(favouritesCount);
        fieldList.add(createdAt);
        fieldList.add(following);
        fieldList.add(verified);
        fieldList.add(verifiedType);
        fieldList.add(allowAllActMsg);
        fieldList.add(allowAllComment);
        fieldList.add(followMe);
        fieldList.add(avatarLarge);
        fieldList.add(onlineStatus);
        fieldList.add(status);
        fieldList.add(biFollowersCount);
        fieldList.add(remark);
        fieldList.add(lang);
        fieldList.add(verifiedReason);
        // 注意三目运算符的优先级，三目优先级最低。
//        System.out.println("screenName="+(screenName == null?"null":"null字符串"));
        return StringUtil.join(fieldList,"\t");
    }
}
