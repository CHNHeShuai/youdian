package com.youdian.service;

import com.youdian.bean.Company;
import com.youdian.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hs
 * @date 2019/3/5 - 10:32
 */

public interface CompanyService {

    public Company getCompanyById(Integer id,HttpServletRequest request);

    //更新公司信息
    public boolean updateCompany(Company company);
}
