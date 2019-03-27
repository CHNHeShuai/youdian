package com.youdian.controller;

import com.youdian.bean.Customer;
import com.youdian.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author hs
 * @date 2019/3/18 - 21:13
 */
@RequestMapping("/youdian")
@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping("/customerList")
    public String customerList(Model model){
        List<Customer> customerList = customerService.customerList();
        model.addAttribute("customerList",customerList);
        return "customerList";
    }

    @RequestMapping("/deleteCustomer")
    public String deleteCustomer(Integer id){
        customerService.deleteCustomer(id);
        return "redirect:/youdian/customerList";
    }

}
