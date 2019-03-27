package com.youdian.service;

import com.youdian.bean.Banner;
import com.youdian.mapper.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author hs
 * @date 2019/3/3 - 13:17
 */
@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    BannerMapper bannerMapper;

    @Override
    @Cacheable(value = "banner")
    public List<Banner> bannerList(HttpServletRequest request) {
        //获取项目相对路径
        String path = request.getScheme()+ "://" +request.getServerName()+":"+request.getServerPort()+request.getContextPath();
        List<Banner> bannerList = bannerMapper.bannerList();
        for (Banner banner:bannerList){
            banner.setImage(path+"/"+banner.getImage());
        }
        return bannerList;
    }

    @Override
    @CacheEvict(value = "banner",allEntries = true)
    public void deleteBanner(Integer id) {
            bannerMapper.deleteBannerById(id);
    }

    @Override
    @CacheEvict(value = "banner",allEntries = true)
    public void updateBanner(Banner banner) {
        bannerMapper.updateBanner(banner);
    }

    @Override
    @CacheEvict(value = "banner",allEntries = true)
    public void insertBanner(Banner banner) {
            bannerMapper.addBanner(banner);
    }

    @Override
    @Cacheable(value = "banner",key = "#id")
    public Banner getBannerById(Integer id,HttpServletRequest request) {
        //获取项目相对路径
        String path = request.getScheme()+ "://" +request.getServerName()+":"+request.getServerPort()+request.getContextPath();
        Banner banner = bannerMapper.getBannerById(id);
        banner.setImage(path+"/"+banner.getImage());
        return banner;
    }
}
