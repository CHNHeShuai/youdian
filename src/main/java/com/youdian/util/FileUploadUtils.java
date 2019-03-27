package com.youdian.util;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author hs
 * @date 2019/3/8 - 13:26
 */
public class FileUploadUtils {

    //文件上传工具类服务方法
    public static void uploadFile(byte[] file,String filePath,String fileName) throws Exception{

        File targerFile = new File(filePath);

        if(!targerFile.exists()){
            targerFile.mkdirs();
        }

        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}
