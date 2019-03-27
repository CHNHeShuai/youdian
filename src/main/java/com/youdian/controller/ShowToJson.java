package com.youdian.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.youdian.bean.*;
import com.youdian.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hs
 * @date 2019/3/6 - 17:09
 */
@RequestMapping("/youdian")
@RestController
public class ShowToJson {

    @Autowired
    ExampleService exampleService;
    @Autowired
    CustomerService customerService;
    @Autowired
    CompanyService companyService;
    @Autowired
    ZhaopinService zhaopinService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    StateService stateService;
    @Autowired
    BannerService bannerService;
    @Autowired
    FriendService friendService;
    @Autowired
    WelfareService welfareService;


    //显示首页轮播图
    @RequestMapping("/getBanner")
    public List<Banner> bannerList(HttpServletRequest request){
        List<Banner> bannerList = bannerService.bannerList(request);
        return bannerList;
    }

    //显示公司信息
    @RequestMapping("/getCompany")
    public Company getCompany(@RequestParam(value = "id") Integer id,HttpServletRequest request){
        Company company = companyService.getCompanyById(id,request);
        return company;
    }

    //显示招聘信息
    @RequestMapping("/getZhaopin")
    public List<Zhaopin> zhaopinList(){
        return zhaopinService.zhaopinList();
    }


    @RequestMapping("/getCategory")
    public List<Category> categoryList(){
        List<Category> categoryList = categoryService.categoryList();
        return categoryList;
    }

    @RequestMapping("/getExampleByCid")
    public PageInfo getExampleListByCid(Integer cid,HttpServletRequest request,@RequestParam(value = "currentPage",defaultValue = "1") Integer currentPage,
                                        @RequestParam(value = "pageSize",defaultValue = "6") Integer pageSize){
        //分页查询
        PageHelper.startPage(currentPage,pageSize);
        List<Example> exampleList = exampleService.getExampleListByCid(cid,request);

        PageInfo pageInfo = new PageInfo(exampleList);

        return pageInfo;
    }
    //显示所有项目列表
    @RequestMapping("/getExampleList")
    public PageInfo getExample(HttpServletRequest request,@RequestParam(value = "currentPage",defaultValue = "1") Integer currentPage,
                               @RequestParam(value = "pageSize",defaultValue = "6") Integer pageSize){
        //分页查询
        PageHelper.startPage(currentPage,pageSize);
        List<Example> exampleList = exampleService.examplesList(request);

        PageInfo pageInfo = new PageInfo(exampleList);
        return pageInfo;
    }

    @RequestMapping("/getExampleById")
    public Example getExampleById(Integer id,HttpServletRequest request){
        Example example = exampleService.getExampleById(id,request);
        //更新访问量
        exampleService.updatePageview(example);
        //获取下一个id
        Example nextExample=null;
        try {
            nextExample = exampleService.getNextId(id);
            example.setNextId(nextExample.getId());
            example.setNextTitle(nextExample.getTitle());
        }catch (Exception e){
            example.setNextId(0);
            example.setNextTitle("不好意思了,到底了!");
        }
        return example;
    }

    //显示动态
    @RequestMapping("/getState")
    public List<State> stateList(HttpServletRequest request){
        List<State> stateList = stateService.stateList(request);
        return stateList;
    }

    //根据id获取状态信息
    @RequestMapping("/getStateById")
    public State getStateById(HttpServletRequest request,Integer id){
        State state = stateService.getStateById(id,request);
        stateService.updatePageview(state);
        //获取下一个state
        try {
            State nextId = stateService.getNextId(id);
            state.setNextId(nextId.getId());
            state.setNextTitle(nextId.getTitle());
        }catch (Exception e){
            state.setNextId(0);
            state.setNextTitle("不好意思,到底了!");
        }

        return state;
    }

    //根据访问量排行获取访问前三的动态信息
    @RequestMapping("/getStateByDesc")
    public List<State> getStateByDesc(HttpServletRequest request){
        List<State> stateList = stateService.stateListByDesc(request);
        return stateList;
    }

    //添加客户信息
    @RequestMapping("/addCustomer")
    public Map addCustomer(Customer customer){
        Map map = new HashMap();
        try {
            customerService.insertCustomer(customer);
            map.put("success","提交成功");
            return map;
        }catch (Exception e){
            map.put("error","提交失败");
            return map;
        }
    }

    //获取合作伙伴
    @RequestMapping("/getFriend")
    public List<Friend> getFriend(HttpServletRequest request){
        List<Friend> friendList = friendService.friendList(request);
        return friendList;
    }

    //获取企业宣传视频
    @RequestMapping("/getWelfare")
    public List<Welfare> getWelfare(HttpServletRequest request){
        return welfareService.welfareList(request);
    }
}
