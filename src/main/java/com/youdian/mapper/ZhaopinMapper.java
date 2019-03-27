package com.youdian.mapper;

import com.youdian.bean.Zhaopin;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author hs
 * @date 2019/3/3 - 11:19
 */
@Mapper
public interface ZhaopinMapper {

    @Select("select * from zhaopin")
    public List<Zhaopin> zhaopinList();

    @Select("select * from zhaopin where id=#{id}")
    public Zhaopin getZhaopinById(Integer id);

    @Insert("insert into zhaopin(title,job,createtime,task,must) values(#{title},#{job},#{createtime},#{task},#{must})")
    public void insertZhaopin(Zhaopin zhaopin);

    @Update("update zhaopin set title=#{title},job=#{job},createtime=#{createtime},task=#{task},must=#{must} where id=#{id}")
    public void updateZhaopin(Zhaopin zhaopin);

    @Delete("delete from zhaopin where id=#{id}")
    public void deleteZhaopin(Integer id);
}
