package com.youdian.service;

import com.youdian.bean.Company;
import com.youdian.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hs
 * @date 2019/3/5 - 10:35
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyMapper companyMapper;

    @Override
    @Cacheable(value = "company",key = "#id")
    public Company getCompanyById(Integer id,HttpServletRequest request) {
        //获取项目相对路径
        String path = request.getScheme()+ "://" +request.getServerName()+":"+request.getServerPort()+request.getContextPath();
        Company company = companyMapper.getCompanyById(id);
        //设置图片的路径
        company.setHistoryimage(path+"/"+company.getHistoryimage());
        return company;
    }

    @Override
    @CacheEvict(value = "company",allEntries = true)
    public boolean updateCompany(Company company) {
        try {
            companyMapper.updateCompany(company);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
