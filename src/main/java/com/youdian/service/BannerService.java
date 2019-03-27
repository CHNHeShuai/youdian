package com.youdian.service;

import com.youdian.bean.Banner;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author hs
 * @date 2019/3/3 - 13:17
 */
public interface BannerService {

    public List<Banner> bannerList(HttpServletRequest request);

    public void deleteBanner(Integer id);

    public void updateBanner(Banner banner);

    public void insertBanner(Banner banner);

    public Banner getBannerById(Integer id,HttpServletRequest request);
}
