package com.youdian.mapper;

import com.youdian.bean.Example;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author hs
 * @date 2019/3/1 - 9:53
 */
@Mapper
public interface ExampleMapper {

    @Select("select * from example where cid=#{cid}")
    public Example getExampleByCid(Integer cid);

    @Select("SELECT * FROM example where cid=#{cid} ORDER BY pageview  DESC")
    public List<Example> getExampleListByCid(Integer cid);

    @Select("select * from example")
    public List<Example> examplesList();

    @Select("select * from example where id=#{id}")
    public Example getExampleById(Integer id);

    @Select("SELECT * FROM example WHERE id > #{id} ORDER BY id LIMIT 0,1; ")
    public Example getNextId(Integer id);

    @Update("update example set title=#{title},image=#{image},introduct=#{introduct},mianji=#{mianji},address=#{address},cid=#{cid} where id=#{id}")
    public void  updateExample(Example example);

    @Insert("insert into example(title,image,introduct,mianji,address,pageview,createtime,cid) values(#{title},#{image},#{introduct},#{mianji},#{address},#{pageview},#{createtime},#{cid})")
    public void insertExample(Example example);

    @Delete("delete from example where id=#{id}")
    public void deleteExample(Integer id);

    @Select("SELECT * FROM example ORDER BY pageview  DESC LIMIT 0,6")
    public List<Example> exampleListByDesc();

    @Update("update example set pageview=#{pageview} where id=#{id}")
    public void updatePageview(Example example);

}
