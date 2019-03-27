package com.youdian.controller;

import com.youdian.bean.Users;
import com.youdian.service.UsersService;
import com.youdian.util.MD5Utils;
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
 * @date 2019/3/16 - 21:14
 */
@Controller
@RequestMapping("/youdian")
public class UsersController {

    @Autowired
    UsersService usersService;

    @RequestMapping("/toUpdateUsers")
    public String toUpdateUsers(Integer id,Model model,HttpServletRequest request){
        Users users = usersService.getUsersById(id);
        users.setId(id);
        model.addAttribute("users",users);
        return "updateUsers";
    }

    @RequestMapping("/usersList")
    public String usersList(Model model){
        List<Users> usersList = usersService.usersList();
        model.addAttribute("usersList",usersList);
        return "usersList";
    }

    @RequestMapping("/updateUsers")
    public String updateUsers(Users users, BindingResult bindingResult, @RequestParam(value = "image") MultipartFile imageFile,
                              HttpServletRequest request, Model model){
        //接受前台上传的图片
        String image = UploadImage.uploadImage(imageFile, request);
        users.setImage(image);
        usersService.updateUsers(users);
        request.getSession().setAttribute("users",users);
        return "redirect:/youdian/usersList";
    }



    @RequestMapping("/updatePassword")
    public String updatePassword(Users users){
        usersService.updatePassword(users);
        return "redirect:/youdian/usersList";
    }

    @RequestMapping("/login")
    public String login(Users users,HttpServletRequest request,Model model) {
        //获取前台输入的用户名
        String username = users.getUsername();
        //根据用户名查询用户，并判断是否存在
        Users user = usersService.getUsers(username);
        if(user!=null) {
            //获取数据库里的密码
            String password = user.getPassword();
            //获取前台输入的密码
            String client_password = users.getPassword();
            String pass = MD5Utils.md5(client_password);

            if(password.equals(pass)){
                request.getSession().setAttribute("users",user);
                return "index";
            }else {
                model.addAttribute("errorPassword","密码错误");
                return "login";
            }
        }else {
            model.addAttribute("errorUsername","用户名不存在!");
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("users");
        return "login";
    }

    @RequestMapping("/deleteUsers")
    public String deleteUsers(Integer id){
        usersService.deleteUsers(id);
        return "redirect:/youdian/usersList";
    }

    @RequestMapping("/addUsers")
    public String addUsers(Users users, BindingResult bindingResult, @RequestParam(value = "image") MultipartFile imageFile,
                           HttpServletRequest request, Model model){
        //接受前台上传的图片
        String image = UploadImage.uploadImage(imageFile, request);
        users.setImage(image);
        usersService.addUsers(users);
        return "redirect:/youdian/usersList";
    }
}
