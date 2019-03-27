package com.youdian.util;

import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author hs
 * @date 2018/12/8 - 14:57
 */
public class UploadImage {

    public static String  uploadImage(MultipartFile fileName ,HttpServletRequest request){

        String rootPath = null;
        try {
            rootPath = ResourceUtils.getURL("classpath:").getPath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String path = "";
        if(!fileName.isEmpty()){
            //生成UUID作为文件名
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            //获取文件类型
            String contentType = fileName.getContentType();
            //获取文件后缀名
            String imageName = contentType.substring(contentType.indexOf("/") + 1);
            path = "upload/"+uuid+"."+imageName;
            //将文件上传到该路径   项目路径+文件相对路径  相当于创建一个文件
            try {
                fileName.transferTo(new File(rootPath+"static/upload/"+uuid+"."+imageName));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //返回图片的路径
        return path;
    }

    public static List<String>  uploadImages(MultipartFile fileNames[] ,HttpServletRequest request){
        //获取项目根目录
        String rootPath = null;
        try {
            rootPath = ResourceUtils.getURL("classpath:").getPath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<String> urls = new ArrayList<>();
        try {
            for (MultipartFile fileName : fileNames){
                //生成UUID作为文件名
                String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                //获取文件类型
                String contentType = fileName.getContentType();
                //获取文件后缀名
                String imageName = contentType.substring(contentType.indexOf("/") + 1);

                urls.add("upload/"+uuid+"."+imageName);
                fileName.transferTo(new File(rootPath+"static/upload/"+uuid+"."+imageName));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //返回图片的路径
        return urls;
    }

    public static String uploadMv(MultipartFile fileName){
        String rootPath = null;
        try {
            //获取根路径
            rootPath = ResourceUtils.getURL("classpath:").getPath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //获取文件类型
        String contentType = fileName.getContentType();
        //获取文件后缀名
        String imageName = contentType.substring(contentType.indexOf("/") + 1);
        //生成UUID作为文件名
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");

        try {

            fileName.transferTo(new File(rootPath+"static/mv/"+uuid+"."+imageName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String path = "mv/"+uuid+"."+imageName;
        return path;
    }
}
