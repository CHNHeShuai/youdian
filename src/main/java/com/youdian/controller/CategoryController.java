package com.youdian.controller;

import com.youdian.bean.Category;
import com.youdian.bean.Example;
import com.youdian.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hs
 * @date 2019/2/28 - 20:57
 */
@RequestMapping("/youdian")
@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/categoryList")
    public String categoryList(Model model){
        List<Category> categories = categoryService.categoryList();
        model.addAttribute("categoryList",categories);
        return "categoryList";
    }

    @GetMapping("/category")
    public Category getCategoryById(){
        Category category = categoryService.getCategoryById(1);
        List<Example> examples = category.getExamples();
        for (Example example : examples){
            System.out.println(example);
        }
        return categoryService.getCategoryById(1);
    }


    @RequestMapping("/insertCategory")
    public String insertCategory(Category category){
        categoryService.insertCategory(category);
        return "redirect:/youdian/categoryList";
    }

    @RequestMapping("/deleteCategory")
    public String  deleteCategory(@RequestParam(value = "id")Integer id){
        categoryService.deleteCategory(id);
        return "redirect:/youdian/categoryList";
    }

    @RequestMapping("/updateCategory")
    public String updateCategory(@RequestParam(value = "id")Integer id, Category category){
        category.setId(id);
        categoryService.updateCategory(category);
        return "redirect:/youdian/categoryList";
    }

    @RequestMapping("/toUpdateCategory")
    public String toUpdateCategory(Integer id,Model model){
        Category category = categoryService.getCategoryById(id);
        category.setId(id);
        model.addAttribute("category",category);
        return "updateCategory";
    }


}
