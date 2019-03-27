package com.youdian.service;

import com.youdian.bean.Welfare;
import com.youdian.mapper.WelfareMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author hs
 * @date 2019/3/8 - 12:13
 */
@Service
public class WelfareServiceImpl implements WelfareService {

    @Autowired
    WelfareMapper welfareMapper;

    @Override
    @Cacheable(value = "welfare")
    public List<Welfare> welfareList(HttpServletRequest request) {
        //获取项目相对路径
        String path = request.getScheme()+ "://" +request.getServerName()+":"+request.getServerPort()+request.getContextPath();
        List<Welfare> welfareList = welfareMapper.welfareList();
        for (Welfare welfare : welfareList){
            welfare.setImage(path+"/"+welfare.getImage());
        }
        return welfareList;
    }

    @Override
    @CacheEvict(value = "welfare",allEntries = true)
    public void updateWelfare(Welfare welfare) {
        welfareMapper.updateWelfare(welfare);
    }

    @Override
    @Cacheable(value = "welfare",key = "#id")
    public Welfare getWelfareById(Integer id) {
        return welfareMapper.getWelfareById(id);
    }

}
