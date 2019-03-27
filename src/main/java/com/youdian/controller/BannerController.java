package com.youdian.controller;


import com.youdian.bean.Banner;
import com.youdian.service.BannerService;
import com.youdian.util.UploadImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author hs
 * @date 2019/3/3 - 13:18
 */
@Controller
@RequestMapping("/youdian")
public class BannerController {

    @Autowired
    BannerService bannerService;


    @RequestMapping("/bannerList")
    public String bannerList(Model model,HttpServletRequest request){
        List<Banner> bannerList = bannerService.bannerList(request);
        model.addAttribute("bannerList",bannerList);
        return "bannerList";
    }

    @RequestMapping("/insertBanner")
    public String insertBanner(Banner banner, BindingResult bindingResult, @RequestParam(value = "image") MultipartFile imageFile,
                               HttpServletRequest request, Model model){
        //接受前台上传的图片
        String image = UploadImage.uploadImage(imageFile, request);
        banner.setImage(image);
        bannerService.insertBanner(banner);
        return "redirect:/youdian/bannerList";
    }

    @RequestMapping("/updateBanner")
    public String updateBanner(Banner banner,BindingResult bindingResult, @RequestParam(value = "image") MultipartFile imageFile,
                               HttpServletRequest request, Model model){
        //接受前台上传的图片
        String image = UploadImage.uploadImage(imageFile, request);
        banner.setImage(image);
        bannerService.updateBanner(banner);
        return "redirect:/youdian/bannerList";
    }
    @RequestMapping("/toUpdateBanner")
    public String toUpdateBanner(Integer id,Model model,HttpServletRequest request){
        Banner banner = bannerService.getBannerById(id,request);
        banner.setId(id);
        model.addAttribute("banner",banner);
        return "updateBanner";
    }

    @RequestMapping("/deleteBanner")
    public String deleteBanner(Integer id){
        bannerService.deleteBanner(id);
        return "redirect:/youdian/bannerList";
    }
}
