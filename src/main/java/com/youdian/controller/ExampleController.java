package com.youdian.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.youdian.bean.Category;
import com.youdian.bean.Example;
import com.youdian.service.CategoryService;
import com.youdian.service.ExampleService;
import com.youdian.util.UploadImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hs
 * @date 2019/3/1 - 10:14
 */
@Controller
@RequestMapping("/youdian")
public class ExampleController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ExampleService exampleService;

    @RequestMapping("/exampleList")
    public String exampleList(Model model,@RequestParam(value = "currentPage",defaultValue = "1") Integer currentPage,
                              @RequestParam(value = "pageSize",defaultValue = "6") Integer pageSize,HttpServletRequest request){
        //分页查询
        PageHelper.startPage(currentPage,pageSize);
        List<Example> exampleList = exampleService.examplesList(request);
        for (Example example : exampleList){
            //获取分类
            int cid = example.getCid();
            Category categoryById = categoryService.getCategoryById(cid);
            example.setCname(categoryById.getCname());
            String[] imgs = example.getImage().split(",");
            example.setImage(imgs[0]);
        }
        PageInfo pageInfo = new PageInfo(exampleList);

        model.addAttribute("pageInfo",pageInfo);
        return "exampleList";
    }

    @RequestMapping("/toUpdateExample")
    public String toUpdateExample(Integer id,Model model,HttpServletRequest request){
        //根据id获取example
        Example example = exampleService.getExampleById(id,request);
        //获取分类
        List<Category> categoryList = categoryService.categoryList();
        model.addAttribute("categoryList",categoryList);
        //获取图片数组
        String[] imgs = example.getImage().split(",");

        model.addAttribute("imgs",imgs);
        model.addAttribute("example",example);
        return "updateExample";
    }

    @RequestMapping("/toInsertExample")
    public String toInsertExample(Model model){
        //获取分类
        List<Category> categoryList = categoryService.categoryList();
        model.addAttribute("categoryList",categoryList);
        return "insertExample";
    }

    @RequestMapping("/updateExample")
    public String updateExample(Example example, BindingResult bindingResult, @RequestParam(value = "image") MultipartFile imageFile[],
                                HttpServletRequest request, Model model){
        //接受前台上传的图片
        List<String> images = UploadImage.uploadImages(imageFile, request);
        //拆分图片字符串
        String img = String.join(",",images);
        example.setImage(img);

        exampleService.updateExample(example);
        return "redirect:/youdian/exampleList";
    }

    @RequestMapping("/insertExample")
    public String insertExample(Example example, BindingResult bindingResult, @RequestParam(value = "image") MultipartFile imageFile[],
                                HttpServletRequest request, Model model){
        //接受前台上传的图片
        List<String> images = UploadImage.uploadImages(imageFile, request);
        //拆分图片字符串
        String img = String.join(",",images);
        example.setImage(img);
        exampleService.insertExample(example);
        return "redirect:/youdian/exampleList";
    }

    @RequestMapping("/deleteExample")
    public String deleteExample(Integer id){
        exampleService.deleteExample(id);
        return "redirect:/youdian/exampleList";
    }
}
