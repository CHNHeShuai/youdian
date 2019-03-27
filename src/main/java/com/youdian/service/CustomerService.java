package com.youdian.service;

import com.youdian.bean.Customer;

import java.util.List;

/**
 * @author hs
 * @date 2019/3/18 - 21:10
 */
public interface CustomerService {
    public void insertCustomer(Customer customer);
    public void deleteCustomer(Integer id);
    public List<Customer> customerList();
}
