package com.youdian.service;

import com.youdian.bean.Customer;
import com.youdian.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hs
 * @date 2019/3/18 - 21:11
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerMapper customerMapper;
    @Override
    @CacheEvict(value = "customer",allEntries = true)
    public void insertCustomer(Customer customer) {
        customerMapper.insertCustomer(customer);
    }

    @Override
    @CacheEvict(value = "customer",allEntries = true)
    public void deleteCustomer(Integer id) {
        customerMapper.deleteCustomer(id);
    }

    @Override
    @Cacheable(value = "customer")
    public List<Customer> customerList() {
        return customerMapper.customerList();
    }
}
