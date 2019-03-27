package com.youdian.mapper;

import com.youdian.bean.Banner;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author hs
 * @date 2019/3/3 - 13:10
 */
@Mapper
public interface BannerMapper {

    @Select("select * from banner")
    public List<Banner> bannerList();

    @Delete("delete from banner where id=#{id}")
    public void deleteBannerById(Integer id);

    @Insert("insert into banner(image) values(#{image})")
    public void addBanner(Banner banner);

    @Update("update banner set image=#{image} where id=#{id}")
    public void updateBanner(Banner banner);

    @Select("select * from banner where id=#{id}")
    public Banner getBannerById(Integer id);

}
