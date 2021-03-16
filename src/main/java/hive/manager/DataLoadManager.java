package hive.manager;

import hive.entity.ContentInfo;
import hive.entity.UserAndContentInfoEntity;
import hive.entity.UserInfo;
import hive.utils.FileOperatorUtil;
import hive.utils.IOUtil;
import hive.utils.XmlParserUtil;
import org.dom4j.DocumentException;
import org.dom4j.Element;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DataLoadManager {
    //取得所有文件内的行
    public static List<String> getAllFileLineList(String inputDir,String charset) throws IOException {
        ArrayList<String> resultList = new ArrayList<>();
        //获取所有文件名的集合
        List<String> txtFilePathList = FileOperatorUtil.getAllSubFilePath(inputDir);
        int fileCounter = 0;
        //获取文件内容
        for (String txtFilePath : txtFilePathList) {
            List<String> singleTxtLineList = IOUtil.getTxtContent(txtFilePath, charset);
            resultList.addAll(singleTxtLineList);
            fileCounter++;
        }
        System.out.println("共执行"+fileCounter+"个文件。");
        //返回所有文本的内容
        return resultList;
    }


    //获得构建实体，传入所有文本内容 一个文件一个行
    public static UserAndContentInfoEntity getConstructInfoEntity(List<String> resultList) throws DocumentException, IOException {
        //结构化
        List<UserInfo> userPojoList = new ArrayList<>();
        List<ContentInfo> contentPojoList = new ArrayList<>();
        int errorLineCounter = 0;
        int uselessData = 0;
        for (String line : resultList){
//            System.out.println("取出来的每个对象   "+line);
            line = line.trim();
            if (line.length() == 0){
                continue;
            }
            //区分list中的对象类型
            if (line.startsWith("<")){
                //说明content类型。
                line = line.trim();
//                System.out.println("content的line    "+line);
//                拿到根节点
                Element xmlRootElement = XmlParserUtil.getXmlRootElement(line);
                if (xmlRootElement == null){
                    errorLineCounter++;
                    continue;
                }
                //判断数据有效
                if(xmlRootElement.elementText("content") == null || xmlRootElement.elementText("time") == null){
                    System.out.println("无效数据");
                    uselessData++;
                    continue;
                }
                ContentInfo contentInfo = new ContentInfo();
                contentInfo.setContent(xmlRootElement.elementText("content"));
                contentInfo.setTime(xmlRootElement.elementText("time"));
                contentInfo.setRepostsCount(Integer.parseInt(xmlRootElement.elementText("repostsCount")));
                contentInfo.setCommentsCount(Integer.parseInt(xmlRootElement.elementText("commentsCount")));
                //将形成的对象集 加入contentlist
                contentPojoList.add(contentInfo);

            }else if (line.startsWith("U")){
                //剩余user类型
                UserInfo userInfo = new UserInfo();
                line = line.subSequence(line.indexOf('[')+1, line.lastIndexOf(']')).toString();
//                System.out.println("user处理后的line  "+line);
                String[] kvArray = line.split(",");
                for (String kv : kvArray) {
                    kv = kv.trim();
                    String[] kvPairs = kv.split("=");
                    if (kvPairs[0].equals("id")) {
                        userInfo.setId(Long.parseLong(kvPairs[1]));
                    } else if (kvPairs[0].equals("screenName")) {
                        userInfo.setScreenName(kvPairs[1]);
                    } else if (kvPairs[0].equals("name")) {
                        userInfo.setName(kvPairs[1]);
                    } else if (kvPairs[0].equals("province")) {
                        userInfo.setProvince(Integer.parseInt(kvPairs[1]));
                    } else if (kvPairs[0].equals("city")) {
                        userInfo.setCity(Integer.parseInt(kvPairs[1]));
                    } else if (kvPairs[0].equals("location")) {
                        userInfo.setLocation(kvPairs[1]);
                    } else if (kvPairs[0].equals("description")) {
                        userInfo.setDescription(kvPairs[1]);
                    } else if (kvPairs[0].equals("url")) {
                        userInfo.setUrl(kvPairs[1]);
                    } else if (kvPairs[0].equals("profileImageUrl")) {
                        userInfo.setProfileImageUrl(kvPairs[1]);
                    } else if (kvPairs[0].equals("userDomain")) {
                        userInfo.setUserDomain(kvPairs[1]);
                    } else if (kvPairs[0].equals("gender")) {
                        userInfo.setGender(kvPairs[1]);
                    } else if (kvPairs[0].equals("followersCount")) {
                        userInfo.setFollowersCount(Integer.parseInt(kvPairs[1]));
                    } else if (kvPairs[0].equals("friendsCount")) {
                        userInfo.setFriendsCount(Integer.parseInt(kvPairs[1]));
                    }else if (kvPairs[0].equals("statusesCount")){
                        userInfo.setStatusesCount(Integer.parseInt(kvPairs[1]));
                    }else if(kvPairs[0].equals("favouritesCount")){
                        userInfo.setFavouritesCount(Integer.parseInt(kvPairs[1]));
                    }else if (kvPairs[0].equals("createdAt")){
                        userInfo.setCreatedAt(kvPairs[1]);
                    }else if (kvPairs[0].equals("following")){
                        userInfo.setFollowing(Boolean.parseBoolean(kvPairs[1]));
                    }else if (kvPairs[0].equals("verified")){
                        userInfo.setVerified(Boolean.parseBoolean(kvPairs[1]));
                    }else if (kvPairs[0].equals("verifiedType")){
                        userInfo.setVerifiedType(Integer.parseInt(kvPairs[1]));
                    }else if (kvPairs[0].equals("allowAllActMsg")){
                        userInfo.setAllowAllActMsg(Boolean.parseBoolean(kvPairs[1]));
                    }else if (kvPairs[0].equals("allowAllComment")){
                        userInfo.setAllowAllComment(Boolean.parseBoolean(kvPairs[1]));
                    }else if (kvPairs[0].equals("followMe")){
                        userInfo.setFollowMe(Boolean.parseBoolean(kvPairs[1]));
                    }else if (kvPairs[0].equals("avatarLarge")){
                        userInfo.setAvatarLarge(kvPairs[1]);
                    }else if (kvPairs[0].equals("onlineStatus")){
                        userInfo.setOnlineStatus(Integer.parseInt(kvPairs[1]));
                    }else if (kvPairs[0].equals("status")){
                        userInfo.setStatus(kvPairs[1]);
                    }else if (kvPairs[0].equals("biFollowersCount")){
                        userInfo.setBiFollowersCount(Integer.parseInt(kvPairs[1]));
                    }else if (kvPairs[0].equals("remark")){
                        userInfo.setRemark(kvPairs[1]);
                    }else if (kvPairs[0].equals("lang")){
                        userInfo.setLang(kvPairs[1]);
                    }else if (kvPairs[0].equals("verifiedReason")){
                        userInfo.setVerifiedReason(kvPairs[1]);
                    }
                }
                userPojoList.add(userInfo);
            }else{
                continue;
            }
        }
        System.out.println("错误行数 = "+errorLineCounter+",无效数据 = "+uselessData);
        return new UserAndContentInfoEntity(userPojoList,contentPojoList);
    }


    //将处理后的User实体写入文件;
    public static boolean writePojoToFile(UserAndContentInfoEntity userAndContentInfoEntity,
                                          String userOutputFilePath, String contentOutputFilePath, String outputCharset,String seq) throws IOException {
        //输出user pojo list
        List<UserInfo> userInfoPojoList = userAndContentInfoEntity.getUserInfoList();

        StringBuilder stringBuilder = new StringBuilder();
        int lineCounter = 0;
        for(UserInfo tempPojo : userInfoPojoList){
            if (lineCounter > 0){
                stringBuilder.append("\n");
            }
            stringBuilder.append(tempPojo.toString4FileOutput(seq));
            lineCounter++;
        }
        IOUtil.writeListToFile(stringBuilder.toString(),userOutputFilePath,outputCharset);

        //输出contentpojo
        List<ContentInfo> contentInfoPojoList = userAndContentInfoEntity.getContentInfoList();

        stringBuilder = new StringBuilder();
        lineCounter = 0;
        for(ContentInfo tempPojo : contentInfoPojoList){
            if (lineCounter > 0){
                stringBuilder.append("\n");
            }
            stringBuilder.append(tempPojo.toString4FileOutput(seq));
            lineCounter++;
        }
        IOUtil.writeListToFile(stringBuilder.toString(),contentOutputFilePath,outputCharset);
        return true;
    }
    public static void startProcess(String inputPath,String inputCharset,String output4User,String output4Content,String charset,String seq) throws IOException, DocumentException {
        long startTime = System.currentTimeMillis();    //获取开始时间
        System.out.println("程序开始！");
        List<String> resultList = getAllFileLineList(inputPath,inputCharset);
        UserAndContentInfoEntity userAndContentInfoEntity = getConstructInfoEntity(resultList);
        writePojoToFile(userAndContentInfoEntity,output4User,output4Content,charset,seq);
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("执行结束！总用时："+(endTime - startTime)+"ms");

    }

    public static void main(String[] args) throws IOException, DocumentException {
/*        String inputDir = "weibodata";
        String inputCharset = "gbk";*/
//        String output4User=args[1];
//        String output4Content = args[2];
//        String outputCharset = "utf-8";
        //把给定目录的文本文件读取成list，即获取所有文件的所有内容。
//        List<String> resultList = getAllFileLineList(inputDir,"gbk");
        //args[0]:输入文件的路径
//        List<String> resultList = getAllFileLineList(args[0],"gbk");
        //把字符串的list转换成结构化对象pojo形式的list;
//        UserAndContentInfoEntity userAndContentInfoEntity = getConstructInfoEntity(resultList);

        //把两个pojo形式的list对象，分别持久化输出到一个统一的文件中，编码为utf-8
//        writePojoToFile(userAndContentInfoEntity,output4User,output4Content,outputCharset);
        //args[1],args[2]:输入目录1User，输出目录二 Content
//        writePojoToFile(userAndContentInfoEntity,output4User,output4Content,"utf-8");
        //输入文件路径，输入文件的格式，user输出路径，content输出路径，输出文件格式，seq文段分隔形式
        DataLoadManager.startProcess(args[0],args[1],args[2],args[3],args[4],args[5]);
//        DataLoadManager.startProcess("weibodata","GBK","user.txt","content.txt","utf-8","\t");

    }
}
