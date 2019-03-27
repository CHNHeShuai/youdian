package com.youdian.controller;

import com.youdian.bean.Welfare;
import com.youdian.service.WelfareService;
import com.youdian.util.FileUploadUtils;
import com.youdian.util.UploadImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author hs
 * @date 2019/3/8 - 12:19
 */
@Controller
@RequestMapping("/youdian")
public class WelfareController {

    @Autowired
    WelfareService welfareService;

    @RequestMapping("/welfareList")
    public String welfareList(Model model,HttpServletRequest request){
        List<Welfare> welfareList = welfareService.welfareList(request);
        model.addAttribute("welfareList",welfareList);
        return "updateWelfare";
    }

    @RequestMapping("/updateWelfare")
    public String updateWelfare(Welfare welfare, BindingResult bindingResult, @RequestParam(value = "image") MultipartFile imageFile,
                                HttpServletRequest request, Model model){
        String rootPath = null;
        try {
            //获取根路径
            rootPath = ResourceUtils.getURL("classpath:").getPath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //获取前台传输的视频的地址
        String deleteImage = request.getParameter("deleteImage");
        //删除原来的视频文件
        File f=new File(rootPath+"static/"+deleteImage);
        if(f.exists()){
            f.delete();
        }
        //接受前台上传的视频
        String image = UploadImage.uploadMv(imageFile);
        welfare.setImage(image);
        welfareService.updateWelfare(welfare);
        return "redirect:/youdian/welfareList";
    }

}
