package com.example.demo.controller;


import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.example.demo.Doctor;
import com.example.demo.Message;
import com.example.demo.User;
import com.example.demo.service.ChatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

import java.time.LocalTime;

@RestController
@RequestMapping(value = "/chat")
public class ChatController {

    @Autowired
    private ChatServiceImpl chatService;

    @RequestMapping(value = "/connect", method = RequestMethod.POST)
    public boolean connect(@RequestParam(value = "pid", required = true) String pid, @RequestParam(value = "did", required = true) String did) {
        System.out.println("建立连接");
        return chatService.connect(pid,did);
    }


    @RequestMapping(value = "/getdoctorlist", method = RequestMethod.GET)
    public List<Doctor> getDoctorList(@RequestParam(value = "pid", required = true) String pid){
        return chatService.getDoctorList(pid);
    }

    @RequestMapping(value = "/getpatientlist", method = RequestMethod.GET)
    public List<User> getPatientList(@RequestParam(value = "did", required = true) String did){
        return chatService.getPatientList(did);
    }

    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    public boolean sendMessage(
            @RequestParam(value = "from", required = true) String src_id,
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "dest", required = true) String dest_id,
            @RequestParam(value = "content", required = true) String content,
            @RequestParam(value = "time", required = true) String time,
            @RequestParam(value = "type", required = true) String type
    ){
        return chatService.sendMessage(src_id, name, dest_id, content, time, type);
    }

    @ResponseBody
    @RequestMapping(value = "/askMessage", method = RequestMethod.GET)
    public List<Message> askMessage(@RequestParam(value = "id", required = true) String id){
        return chatService.askMessage(id);
    }

    @RequestMapping(value = "/getHistoryMsg", method = RequestMethod.GET)
    public List<Message> getHistoryMsg(
            @RequestParam(value = "selfid", required = true) String selfid,
            @RequestParam(value = "id", required = true) String id
            ){
        return chatService.getHistoryMsg(selfid, id);
    }


    private static String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
    private static String accessKeyId = "LTAI5tEu1zShrbRJc2JeRSut";
    private static String accessKeySecret = "cPCxs0OHcAIBCXEHQRNXbXuFq0aWzc";
    private static String bucketName = "test0517";
    @PostMapping("/file")
    public List<String> uploadFlie(MultipartFile file) throws IOException {
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            //获取上传文件输入流
            InputStream inputStream = file.getInputStream();
            //获取文件名称
            String fileName = file.getOriginalFilename();
            String datePath = new Date().getTime()+"_";
            fileName = datePath+fileName;
            fileName = "ChatFile/" + fileName;

            //调用oss方法实现上传
            //第一个参数  Bucket名称
            //第二个参数  上传到oss文件路径和文件名称   aa/bb/1.jpg
            //第三个参数  上传文件输入流
            ossClient.putObject(bucketName, fileName , inputStream);
            System.out.println("Object：" + fileName + "存入OSS成功。");

            // 把上传之后文件路径返回
            Date expiration = new Date(new Date().getTime() + 3600 * 1000);
            URL url = ossClient.generatePresignedUrl(bucketName, fileName, expiration);
            System.out.println("url:"+url);

            // 关闭OSSClient。
            ossClient.shutdown();

            List<String> ret = new ArrayList<String>();
            ret.add(fileName);
            ret.add(url.toString());

            return ret;
        } catch (OSSException oe) {
            oe.printStackTrace();
        } catch (ClientException ce) {
            ce.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
        }

        //String url="";
        return null;
    }

}
