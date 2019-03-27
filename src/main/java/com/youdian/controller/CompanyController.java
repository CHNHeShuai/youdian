package com.youdian.controller;

import com.youdian.bean.Company;
import com.youdian.service.CompanyService;
import com.youdian.util.UploadImage;
import org.apache.tomcat.util.buf.StringUtils;
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
 * @date 2019/3/5 - 10:36
 */
@RequestMapping("/youdian")
@Controller
public class CompanyController {
    @Autowired
    CompanyService companyService;

    //后台管理页面
    @RequestMapping("/getCompanyById")
    public String getCompanyById(Integer id, Model model,HttpServletRequest request){
        Company company = companyService.getCompanyById(id,request);
        model.addAttribute("company",company);
        return "company";
    }

    @RequestMapping(value = "/updateCompany", produces = "text/html;charset=UTF-8")
    public String updateCompany(Company company,BindingResult bindingResult, @RequestParam(value = "historyimage") MultipartFile imageFile,
                                 HttpServletRequest request,Model model){
        String image = UploadImage.uploadImage(imageFile, request);
        company.setHistoryimage(image);
        boolean success = companyService.updateCompany(company);
        model.addAttribute("success",success);
        return "redirect:/youdian/getCompanyById?id=1";
    }
}
