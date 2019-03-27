package com.youdian.mapper;

import com.youdian.bean.Welfare;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author hs
 * @date 2019/3/3 - 11:19
 */
@Mapper
public interface WelfareMapper {

    @Select("select * from welfare")
    public List<Welfare> welfareList();

    @Update("update welfare set miaoshu=#{miaoshu},image=#{image} where id=#{id}")
    public void updateWelfare(Welfare welfare);

    @Select("select * from welfare where id=#{id}")
    public Welfare getWelfareById(Integer id);
}
