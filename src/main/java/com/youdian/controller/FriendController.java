package com.youdian.controller;

import com.youdian.bean.Friend;
import com.youdian.service.FriendService;
import com.youdian.util.UploadImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author hs
 * @date 2019/3/25 - 13:03
 */
@Controller
@RequestMapping("/youdian")
public class FriendController {

    @Autowired
    FriendService friendService;

    @RequestMapping("/friendList")
    public String friendList(Model model,HttpServletRequest request){
        List<Friend> friendList = friendService.friendList(request);
        model.addAttribute("friendList",friendList);
        return "friendList";
    }

    @RequestMapping("/addFriend")
    public String addFriend(Friend friend, BindingResult bindingResult, @RequestParam(value = "image") MultipartFile imageFile,
                            HttpServletRequest request, Model model){
        //接受前台上传的图片
        String image = UploadImage.uploadImage(imageFile, request);
        friend.setImage(image);
        friendService.addFriend(friend);
        return "redirect:/youdian/friendList";
    }

    @RequestMapping("/deleteFriend")
    public String deleteFriend(Integer id){
        friendService.deleteFriend(id);
        return "redirect:/youdian/friendList";
    }
}
