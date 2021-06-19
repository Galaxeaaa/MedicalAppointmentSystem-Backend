package com.example.demo.service;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.example.demo.Doctor;
import com.example.demo.Message;
import com.example.demo.User;
import com.example.demo.dao.ChatDao;
import com.example.demo.dao.InfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.URL;
import java.util.*;

@Service
public class ChatServiceImpl implements ChatService{

    @Autowired
    private ChatDao chatDao;

    Map<String,String> sessionList = new HashMap<String,String>();
    List<Message> messageQueue = new ArrayList<>();

    public boolean connect(String pid, String did){
        sessionList.put(pid,did);
        sessionList.put(did,pid);
        return true;
    }

    public boolean disconnect(String pid, String did){
        sessionList.remove(pid,did);
        sessionList.remove(did,pid);
        return true;
    }

    public List<Doctor> getDoctorList(String id){
        return chatDao.getDoctorList(id);
    }

    public List<User> getPatientList(String id){
        return chatDao.getPatientList(id);
    }

    private final static long w = 100000000;

    public boolean sendMessage(String src_id, String name, String dest_id, String content,String time,String type){
        Message msg = new Message(src_id, name, dest_id,content,time,type);
        long r = (long) ((Math.random() + 1) * w);
        System.out.println(System.currentTimeMillis());
        String msgid = (System.currentTimeMillis()+"");// + String.valueOf(r).substring(1);
        msg.setMsg_id((msgid));
        messageQueue.add(msg);
        return chatDao.sendMessage(msg);
    }

    private static String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
    private static String accessKeyId = "LTAI5tEu1zShrbRJc2JeRSut";
    private static String accessKeySecret = "cPCxs0OHcAIBCXEHQRNXbXuFq0aWzc";
    private static String bucketName = "test0517";

    public List<Message> askMessage(String id){

        List<Message> ret = new ArrayList<Message>();
        List<Integer> toRemove = new ArrayList<Integer>();

        for(int i=0;i<messageQueue.size();i=i+1){
            Message msg = messageQueue.get(i);
            if(msg.isMatch(id)){
                if(msg.getType().equals("2")||msg.getType().equals("3")){
                    OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
                    try {
                        String fileName = msg.getContent();
                        Date expiration = new Date(new Date().getTime() + 3600 * 1000);
                        URL url = ossClient.generatePresignedUrl(bucketName, fileName, expiration);
                        ossClient.shutdown();
                        msg.setContent(url.toString());
                    } catch (OSSException oe) {
                        oe.printStackTrace();
                    } catch (ClientException ce) {
                        ce.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        ossClient.shutdown();
                    }
                }
                ret.add(msg);
                toRemove.add(i);
            }
        }
        for(int i=toRemove.size()-1;i>=0;i=i-1){
            messageQueue.remove(messageQueue.get(toRemove.get(i)));
        }
        return ret;
    }

    public List<Message> getHistoryMsg(String selfid, String id){

        List<Message> ret = chatDao.getHistoryMsg(selfid, id);

        for (int i=0;i<ret.size();i=i+1){
            Message msg = ret.get(i);
            System.out.println("initType: "+msg.getType());
            if(msg.getType().equals("2")){
                OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
                try {
                    String fileName = msg.getContent();
                    Date expiration = new Date(new Date().getTime() + 3600 * 1000);
                    URL url = ossClient.generatePresignedUrl(bucketName, fileName, expiration);
                    msg.setContent(url.toString());
                    System.out.println("init:"+url);
                } catch (OSSException oe) {
                    oe.printStackTrace();
                } catch (ClientException ce) {
                    ce.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    ossClient.shutdown();
                }
            }
        }

        return ret;
    }

}
